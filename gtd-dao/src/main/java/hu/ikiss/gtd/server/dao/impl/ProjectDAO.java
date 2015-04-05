package hu.ikiss.gtd.server.dao.impl;

import hu.ikiss.gtd.dto.ProjectDTO;
import hu.ikiss.gtd.server.domain.Project;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectDAO implements hu.ikiss.gtd.dao.ProjectDAO {

  private final CommonDAOimpl<ProjectDTO, Project> commonDAO;

  @Autowired
  private ProjectConverter                         converter;

  public ProjectDAO() {
    this.commonDAO = new CommonDAOimpl<ProjectDTO, Project>(this.converter);
  }

  @Override
  public ProjectDTO create(final ProjectDTO DTO) {
    return this.commonDAO.create(DTO);
  }

  @Override
  public void deleteByPrimaryKey(final Integer id) {
    this.commonDAO.deleteByPrimaryKey(id, "Project.deleteByPrimaryKey");

  }

  @Override
  public ProjectDTO findByPrimaryKey(final Integer id) {
    return this.commonDAO.findByPrimaryKey(id, "Project.findByPrimaryKey");
  }

  public void setEM(final EntityManager em) {
    this.commonDAO.setEm(em);

  }

  @Override
  public ProjectDTO update(ProjectDTO DTO) {
    DTO = this.commonDAO.update(DTO);
    return DTO;
  }
}
