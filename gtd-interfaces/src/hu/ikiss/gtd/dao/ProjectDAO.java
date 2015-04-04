package hu.ikiss.gtd.dao;

import hu.ikiss.gtd.dto.ProjectDTO;

public interface ProjectDAO extends DAO<ProjectDTO> {

  @Override
  ProjectDTO create(ProjectDTO dto);

}
