package hu.ikiss.gtd.controller;

import hu.ikiss.gtd.businessinterface.TaskBusiness;
import hu.ikiss.gtd.dto.TaskDTO;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("/")
@SessionAttributes({"project", "task"})
public class Tasks {

  @Autowired
  TaskBusiness taskService;

  @RequestMapping(value = "editTask", method = RequestMethod.GET)
  public String editTask(@RequestParam final Long taskId, final ModelMap model) {
    TaskDTO taskDTO = null;
    try {
      taskDTO = this.taskService.findById(taskId);
    } catch (final RemoteException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    model.addAttribute("task", taskDTO);
    return "task";
  }

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String tasks(final ModelMap model) {

    try {
      model.addAttribute("tasks", this.taskService.findRelevant());
    } catch (final RemoteException e) {
      e.printStackTrace();
    }
    return "tasks";

  }

}
