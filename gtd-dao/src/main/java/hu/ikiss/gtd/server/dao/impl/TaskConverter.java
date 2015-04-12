package hu.ikiss.gtd.server.dao.impl;

import hu.ikiss.gtd.dto.TaskDTO;
import hu.ikiss.gtd.server.domain.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskConverter implements DomainVsConverterTask {


  @Autowired
  DomainVsConverterProject projectConverter;

  @Override
  public Task toDomain(final TaskDTO dto) {
    final Task domain = new Task();
    domain.setId(dto.getId());
    domain.setName(dto.getName());
    domain.setProject((this.projectConverter.toDomain(dto.getProject())));
    return domain;
  }

  @Override
  public TaskDTO toDTO(final Task domain) {
    final Task toConvert = domain;
    final TaskDTO res = new TaskDTO();
    res.setId(toConvert.getId());
    res.setName(toConvert.getName());
    res.setProject(this.projectConverter.toDTO(toConvert.getProject()));
    return res;
  }

}
