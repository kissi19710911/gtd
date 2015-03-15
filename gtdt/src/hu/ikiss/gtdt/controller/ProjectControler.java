package hu.ikiss.gtdt.controller;

import hu.ikiss.gtdt.dto.ProjectDTOLocal;
import hu.ikiss.gtdt.service.ProjectService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectControler {
    @Autowired
    private ProjectService service;
 
    @RequestMapping("/index")
    public String listContacts(Map<String, Object> map) {
 
        map.put("contact", new ProjectDTOLocal());
        map.put("contactList", service.list());
 
        return "contact";
    }
 
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProject(@ModelAttribute("project")
    ProjectDTOLocal project, BindingResult result) {
 
        service.add(project);
 
        return "redirect:/index";
    }
 
    @RequestMapping("/delete/{projectId}")
    public String deleteProject(@PathVariable("projectId")
    Integer projectId) {
 
        service.remove(projectId);
 
        return "redirect:/index";
    }
}
