package hu.ikiss.gtd.local.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.CompareToBuilder;

public class ProjectDTOLocal implements Comparable<ProjectDTOLocal>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5514408353162431151L;
	private Integer id;
	private String name;

	public ProjectDTOLocal() {
	}

	public int compareTo(ProjectDTOLocal o) {
		return new CompareToBuilder().append(this.name, o.name).toComparison();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
