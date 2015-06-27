package hu.ikiss.gtd.controller;

import hu.ikiss.gtd.businessinterface.TaskBusiness;
import hu.ikiss.gtd.dto.TasksDTO;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@Scope("session")
public class TasksController implements Serializable {
  protected static Logger   logger           = Logger.getLogger("controller");

  private static final long serialVersionUID = -4692836593546999157L;

  @Autowired
  private TasksDTO          tasksDTO;

  @Autowired
  private TaskBusiness      taskService;

  public TasksDTO getRelevantTasks() {
    try {
      return this.taskService.findRelevant();
    } catch (final RemoteException e) {
      e.printStackTrace();
      return null;
    }
  }


  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String tasks(final HttpSession session) {
    session.setAttribute("relevantTasks", this.getRelevantTasks());
    return "tasks";

  }

}
