package hu.ikiss.gtd.controller;

import hu.ikiss.gtd.server.dao.impl.ProjectDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class Home {

  @Autowired
  private ProjectDAO projectDAO;

  @RequestMapping(method = RequestMethod.GET)
  public String printWelcome(ModelMap model) {
    projectDAO.findByPrimaryKey(1, "namedQuery");
    model.addAttribute("message", "Spring 3 MVC Hello World");
    return "hello";

  }

}
