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
  private DomainVsConverterTask              converter;

  @PersistenceContext(name = "gtdDS")
  private EntityManager                      em;

  public TaskDAO() {
    this.commonDAO = new CommonDAOimpl<TaskDTO, Task>();
  }

  @Override
  public TaskDTO create(final TaskDTO DTO) {
    return this.commonDAO.create(DTO);
  }

  @Override
  public void deleteByPrimaryKey(final Long id) {
    this.commonDAO.deleteByPrimaryKey(id, "Task.deleteByPrimaryKey");

  }

  @Override
  public TaskDTO findByPrimaryKey(final Long id) {
    return this.commonDAO.findByPrimaryKey(id, "Task.findByPrimaryKey");
  }

  @Override
  public List<TaskDTO> findRelevant() {
    return this.commonDAO.findByQuery("Task.findRelevant");
  }

  @Override
  public void setConverter() {
    this.commonDAO.setConverter(this.converter);
  }

  @Override
  public void setEm() {
    this.commonDAO.setEm(this.em);

  }

  @Override
  public TaskDTO update(TaskDTO DTO) {
    DTO = this.commonDAO.update(DTO);
    return DTO;
  }
}
