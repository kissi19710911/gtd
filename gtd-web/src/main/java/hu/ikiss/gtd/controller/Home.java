package hu.ikiss.gtd.controller;

import hu.ikiss.gtd.businessinterface.TaskBusiness;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class Home {

  @Autowired
  TaskBusiness taskService;

  @RequestMapping(method = RequestMethod.GET)
  public String tasks(final ModelMap model) {

    try {
      model.addAttribute/* put */("tasks", this.taskService.findRelevant());
    } catch (final RemoteException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return "tasks";

  }

}
