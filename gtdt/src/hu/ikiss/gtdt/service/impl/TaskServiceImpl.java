package hu.ikiss.gtdt.service.impl;

import javax.servlet.Servlet;

import hu.ikiss.gtdt.dao.CommonDAO;
import hu.ikiss.gtdt.dto.TaskDTOLocal;
import hu.ikiss.gtdt.service.GTDTService;
import hu.ikiss.gtdt.service.GTDTServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TaskServiceImpl extends GTDTServiceImpl<TaskDTOLocal> implements GTDTService<TaskDTOLocal>,Servlet{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1104411563766002193L;

	public TaskServiceImpl(CommonDAO<TaskDTOLocal> dao) {
    	super(dao);
	}

	@Autowired
    protected CommonDAO<TaskDTOLocal> dao;

}
