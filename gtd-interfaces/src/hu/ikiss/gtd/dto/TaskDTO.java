package hu.ikiss.gtd.dto;

import hu.ikiss.gtd.local.DTO;

import java.io.Serializable;

import org.apache.commons.lang.builder.CompareToBuilder;

public class TaskDTO implements Comparable<TaskDTO>, Serializable, DTO {

  private static final long serialVersionUID = -5514408353162431151L;
  private Long              id;
  private String            name;
  private ProjectDTO        project;

  public TaskDTO() {
  }

  @Override
  public int compareTo(final TaskDTO o) {
    return new CompareToBuilder().append(this.project, o.project).append(this.name, o.name)
        .toComparison();
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public ProjectDTO getProject() {
    return this.project;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public void setProject(final ProjectDTO project) {
    this.project = project;
  }

}
