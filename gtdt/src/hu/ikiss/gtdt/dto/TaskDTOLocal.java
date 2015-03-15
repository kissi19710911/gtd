package hu.ikiss.gtdt.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.CompareToBuilder;

public class TaskDTOLocal implements Comparable<TaskDTOLocal>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5514408353162431151L;
	private Integer id;
	private String name;

	public TaskDTOLocal() {
	}

	public int compareTo(TaskDTOLocal o) {
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
