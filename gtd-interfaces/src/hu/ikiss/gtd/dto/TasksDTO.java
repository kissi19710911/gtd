package hu.ikiss.gtd.dto;

import hu.ikiss.gtd.local.DTO;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class TasksDTO implements Comparable<TasksDTO>, Serializable, DTO {
  private static final long serialVersionUID = 2017371963733618328L;

  private String            sessionId;

  List<TaskDTO>             tasks;

  public void addTask(final TaskDTO task) {
    this.tasks.add(task);
  }

  public void clear() {
    this.tasks.clear();
  }

  @Override
  public int compareTo(final TasksDTO o) {
    return new CompareToBuilder().append(this.sessionId, o.sessionId).toComparison();
  }

  public String getSessionid() {
    return this.sessionId;
  }

  public TaskDTO getTask(final int i) {
    return this.tasks.get(i);
  }

  public List<TaskDTO> getTasks() {
    return this.tasks;
  }

  public void removeTask(final int i) {
    this.tasks.remove(i);
  }

  public void removeTask(final TaskDTO task) {
    this.tasks.remove(task);
  }

  public void setSessionid(final String sessionid) {
    this.sessionId = sessionid;
  }

  public void setTasks(final List<TaskDTO> tasks) {
    this.tasks = tasks;
  }
}
