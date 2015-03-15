package hu.ikiss.gtdt.service.impl;

import hu.ikiss.gtdt.dao.CommonDAO;
import hu.ikiss.gtdt.dto.ProjectDTOLocal;
import hu.ikiss.gtdt.service.GTDTService;
import hu.ikiss.gtdt.service.GTDTServiceImpl;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl extends GTDTServiceImpl<ProjectDTOLocal>
		implements GTDTService<ProjectDTOLocal>,Servlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5107872185479576702L;

	public ProjectServiceImpl(CommonDAO<ProjectDTOLocal> dao) {
		super(dao);
	}

	@Autowired
	private CommonDAO<ProjectDTOLocal> dao;

}
