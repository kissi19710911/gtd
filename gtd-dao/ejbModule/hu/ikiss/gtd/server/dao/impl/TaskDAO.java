package hu.ikiss.gtd.server.dao.impl;

import hu.ikiss.gtd.dto.TaskDTO;
import hu.ikiss.gtd.server.domain.Task;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskDAO implements hu.ikiss.gtd.dao.TaskDAO {

  private final CommonDAOimpl<TaskDTO, Task> commonDAO;

  @Autowired
  private TaskConverter                           converter;

  @PersistenceContext(unitName = "gtdDS")
  private EntityManager                           em;

  public TaskDAO() {
    this.commonDAO = new CommonDAOimpl<TaskDTO, Task>(this.converter);
  }

  @Override
  public TaskDTO create(final TaskDTO DTO) {
    this.commonDAO.setEm(this.em);
    return this.commonDAO.create(DTO);
  }

  @Override
  public void deleteByPrimaryKey(final Integer id) {
    this.commonDAO.setEm(this.em);
    this.commonDAO.deleteByPrimaryKey(id, "Task.deleteByPrimaryKey");

  }

  @Override
  public TaskDTO findByPrimaryKey(final Integer id) {
    this.commonDAO.setEm(this.em);
    return this.commonDAO.findByPrimaryKey(id, "Task.findByPrimaryKey");
  }

  @Override
  public List<TaskDTO> findRelevant() {
    this.commonDAO.setEm(this.em);
    return this.commonDAO.findByQuery("Task.findRelevant");
  }

  @Override
  public TaskDTO update(final TaskDTO DTO) {
    this.commonDAO.setEm(this.em);
    this.em.merge(this.converter.toDomain(DTO));
    return DTO;
  }
}
