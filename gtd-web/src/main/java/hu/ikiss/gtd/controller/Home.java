package hu.ikiss.gtd.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class Home {
  @Autowired
  @Qualifier("jdbc/gtdDB")
  private DataSource dataSource;

  @RequestMapping(method = RequestMethod.GET)
  public String printWelcome(ModelMap model) {

    model.addAttribute("message", "Spring 3 MVC Hello World");
    return "hello";

  }

}
