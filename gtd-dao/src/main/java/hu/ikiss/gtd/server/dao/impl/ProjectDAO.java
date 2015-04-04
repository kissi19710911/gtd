package hu.ikiss.gtd.server.dao.impl;

import hu.ikiss.gtd.dao.common.DomainVSDtoConverter;
import hu.ikiss.gtd.dto.ProjectDTO;
import hu.ikiss.gtd.server.domain.Project;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class ProjectDAO implements hu.ikiss.gtd.dao.ProjectDAO {

  private final CommonDAOimpl<ProjectDTO, Project>        commonDAO;

  private final DomainVSDtoConverter<ProjectDTO, Project> converter;

  @PersistenceContext(unitName = "gtdDS")
  private EntityManager                                        em;

  public ProjectDAO() {
    this.converter = new ProjectConverter();
    this.commonDAO = new CommonDAOimpl<ProjectDTO, Project>(this.converter);
  }

  @Override
  public ProjectDTO create(final ProjectDTO DTO) {
    this.commonDAO.setEm(this.em);
    return this.commonDAO.create(DTO);
  }

  @Override
  public void deleteByPrimaryKey(final Integer id) {
    this.commonDAO.setEm(this.em);
    this.commonDAO.deleteByPrimaryKey(id, "Project.deleteByPrimaryKey");

  }

  @Override
  public ProjectDTO findByPrimaryKey(final Integer id) {
    this.commonDAO.setEm(this.em);
    return this.commonDAO.findByPrimaryKey(id, "Project.findByPrimaryKey");
  }

  @Override
  public ProjectDTO update(final ProjectDTO DTO) {
    this.commonDAO.setEm(this.em);
    this.em.merge(this.converter.toDomain(DTO));
    return DTO;
  }
}
