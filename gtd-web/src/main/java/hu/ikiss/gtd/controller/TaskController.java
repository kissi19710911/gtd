package hu.ikiss.gtd.controller;

import hu.ikiss.gtd.businessinterface.TaskBusiness;
import hu.ikiss.gtd.dto.TaskDTO;

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
public class TaskController implements Serializable {
  protected static Logger   logger           = Logger.getLogger("controller");

  private static final long serialVersionUID = 2062487591682489384L;

  @Autowired
  private TaskDTO           taskDTO;

  @Autowired
  private TaskBusiness      taskService;

  @RequestMapping(value = "/editTask", method = RequestMethod.GET)
  public String editTask(final HttpSession session) {
    TaskDTO taskDTO = null;
    try {
      taskDTO = this.taskService.findById((Long) session.getAttribute("taskId"));
    } catch (final RemoteException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    session.setAttribute("task", taskDTO);
    return "task";
  }

  @RequestMapping(value = "saveTask", method = RequestMethod.POST)
  public String saveTask(final HttpSession session) {
    try {
      this.taskDTO = (TaskDTO) session.getAttribute("task");
      this.taskDTO = this.taskService.update(this.taskDTO);
    } catch (final RemoteException e) {
      e.printStackTrace();
    }
    return "task";
  }


}
