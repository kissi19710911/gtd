package hu.ikiss.gtd.remote.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.CompareToBuilder;

public class ProjectDTORemote implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8187789147329651382L;
	private Integer id;
	private String name;

	public ProjectDTORemote() {
	}

	public int compareTo(ProjectDTORemote o) {
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
