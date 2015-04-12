package hu.ikiss.gtd.server.domain;

import hu.ikiss.gtd.local.Domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Task.deleteByPrimaryKey", query = "delete from Task where id = :id"),
    @NamedQuery(name = "Task.findRelevant", query = "select t from Task t") // TODO add relevant
// param
// @NamedQuery(name = "Task.insert", query = "insert into Task values (:task)"),
// @NamedQuery(name = "Task.updateNameByPrimaryKey", query =
// "update Task set name = :name where id = :id")
})
public class Task implements Serializable, Comparable<Task>, Domain {

  private static final long serialVersionUID = 1L;
  private Integer           id;
  private String            name;
  private Project           project;

  public Task() {
    super();
  }

  @Override
  public int compareTo(final Task o) {
    return new CompareToBuilder().append(this.name, o.name).toComparison();
  }

  @Override
  public boolean equals(final Object o) {
    if (o instanceof Task) {
      if (o.getClass() == this.getClass()) {
        return new EqualsBuilder().append(this.getName(), ((Task) o).getName()).isEquals();
      } else {
        return false;
      }
    } else {
      return false;
    }

  }

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TASKS_SEQ")
  @SequenceGenerator(name = "TASKS_SEQ", sequenceName = "TASKS_SEQ", allocationSize = 1)
  @Column(name = "ID")
  public Integer getId() {
    return this.id;
  }

  @Column(name = "NAME")
  public String getName() {
    return this.name;
  }


  @ManyToOne(optional = false)
  @JoinColumn(name = "PROJECT_ID", referencedColumnName = "id", nullable = false, updatable = false)
  public Project getProject() {
    return this.project;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(this.name).append(this.project).toHashCode();
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public void setProject(final Project project) {
    this.project = project;
  }
}
