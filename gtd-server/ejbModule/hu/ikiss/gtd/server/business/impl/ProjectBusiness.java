package hu.ikiss.gtd.server.business.impl;

import hu.ikiss.gtd.local.businessinterface.ProjectBusinessLocal;
import hu.ikiss.gtd.local.dto.ProjectDTOLocal;
import hu.ikiss.gtd.remote.businessinterface.ProjectBusinessRemote;
import hu.ikiss.gtd.remote.dto.ProjectDTORemote;
import hu.ikiss.gtd.server.dao.impl.ProjectDAO;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.springframework.stereotype.Component;

@Component
@Stateless
@Local(ProjectBusinessLocal.class)
@Remote(ProjectBusinessRemote.class)
@EJB(name="ProjectBusiness",beanInterface=ProjectBusinessLocal.class)
public class ProjectBusiness implements ProjectBusinessLocal, ProjectBusinessRemote {
  @EJB
	ProjectDAO projectDao;

	public ProjectDTORemote create(ProjectDTORemote dto) {
		ProjectDTOLocal dtoLocal = new ProjectDTOLocal();
		dtoLocal.setName(dto.getName());
		dtoLocal = projectDao.create(dtoLocal);
		
		dto.setId(dtoLocal.getId());
		dto.setName(dtoLocal.getName());
		return dto;
	}
}
