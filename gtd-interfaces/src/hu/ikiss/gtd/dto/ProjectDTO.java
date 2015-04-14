package hu.ikiss.gtd.dto;

import hu.ikiss.gtd.local.DTO;

import java.io.Serializable;

import org.apache.commons.lang.builder.CompareToBuilder;

public class ProjectDTO implements Comparable<ProjectDTO>, Serializable, DTO {

  private static final long serialVersionUID = -5514408353162431151L;
  private Long              id;
  private String            name;
  private ProjectDTO        project;

  public ProjectDTO() {
  }

  @Override
  public int compareTo(final ProjectDTO o) {
    return new CompareToBuilder().append(this.name, o.name).toComparison();
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
