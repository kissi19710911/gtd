package hu.ikiss.gtd.server.business.impl;

import hu.ikiss.gtd.local.businessinterface.TaskBusinessLocal;
import hu.ikiss.gtd.local.dao.TaskDAOLocal;
import hu.ikiss.gtd.local.dto.TaskDTOLocal;
import hu.ikiss.gtd.remote.businessinterface.TaskBusinessRemote;
import hu.ikiss.gtd.remote.dto.TaskDTORemote;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.springframework.stereotype.Component;

@Component
@Stateless 
@Local(TaskBusinessLocal.class)
@Remote(TaskBusinessRemote.class)
@EJB(name="TaskServices",beanInterface=TaskBusinessLocal.class)
public class TaskServices implements TaskBusinessLocal, TaskBusinessRemote {
	@EJB
	TaskDAOLocal taskDao;

	public TaskDTORemote create(TaskDTORemote dto) {
		TaskDTOLocal dtoLocal = new TaskDTOLocal();
		dtoLocal.setName(dto.getName());
		dtoLocal = taskDao.create(dtoLocal);
		
		dto.setId(dtoLocal.getId());
		dto.setName(dtoLocal.getName());
		return dto;
	}
}