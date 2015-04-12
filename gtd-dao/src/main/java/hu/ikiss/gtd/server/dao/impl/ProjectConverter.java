package hu.ikiss.gtd.server.dao.impl;

import hu.ikiss.gtd.dto.ProjectDTO;
import hu.ikiss.gtd.server.domain.Project;

import org.springframework.stereotype.Component;

@Component
public class ProjectConverter implements DomainVsConverterProject {

  @Override
  public Project toDomain(final ProjectDTO dto) {
    final Project domain = new Project();
    domain.setId(dto.getId());
    domain.setName(dto.getName());
    return domain;
  }

  @Override
  public ProjectDTO toDTO(final Project domain) {
    final Project toConvert = domain;
    final ProjectDTO res = new ProjectDTO();
    res.setId(toConvert.getId());
    res.setName(toConvert.getName());
    return res;
  }

}
