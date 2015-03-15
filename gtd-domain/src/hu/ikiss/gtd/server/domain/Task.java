package hu.ikiss.gtd.server.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Entity implementation class for Entity: Task
 *
 */
@Entity
@Table(name = "TASKS")
@NamedQueries({
		@NamedQuery(name = "Task.findByPrimaryKey", query = "select m from Task m where m.id = :id"),
		@NamedQuery(name = "Task.deleteByPrimaryKey", query = "delete from Task where id = :id")
// @NamedQuery(name = "Task.insert", query = "insert into Task values (:task)"),
// @NamedQuery(name = "Task.updateNameByPrimaryKey", query =
// "update Task set name = :name where id = :id")
})
public class Task implements Serializable, Comparable<Task> {

	private Integer id;
	private String name;
	private static final long serialVersionUID = 1L;

	public Task() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TASKS_SEQ")
	@SequenceGenerator(name = "TASKS_SEQ", sequenceName = "TASKS_SEQ", allocationSize=1)
	@Column(name = "ID")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Task o) {
		return new CompareToBuilder().append(this.name, o.name).toComparison();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.name).toHashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (o.getClass() == this.getClass()) {
			return new EqualsBuilder().append(this.getName(),
					((Task) o).getName()).isEquals();
		} else {
			return false;
		}

	}
}
