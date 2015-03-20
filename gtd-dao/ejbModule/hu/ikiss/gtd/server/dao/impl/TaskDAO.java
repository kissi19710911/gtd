package hu.ikiss.gtd.server.dao.impl;

import hu.ikiss.gtd.local.dao.TaskDAOLocal;
import hu.ikiss.gtd.local.dao.common.DomainVSDtoConverter;
import hu.ikiss.gtd.local.dto.TaskDTOLocal;
import hu.ikiss.gtd.remote.dao.TaskDAORemote;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import hu.ikiss.gtd.server.domain.Task;

import org.springframework.stereotype.Component;

@Component
@Stateless
@Local(TaskDAOLocal.class)
@Remote(TaskDAORemote.class)
@EJB(name = "TaskDAO", beanInterface = TaskDAOLocal.class)
public class TaskDAO implements
		TaskDAOLocal, TaskDAORemote {

	@PersistenceContext(unitName = "gtdDS")
	private EntityManager em;

	private  DomainVSDtoConverter<TaskDTOLocal> converter;

	private CommonDAOimpl<TaskDTOLocal> commonDAO;
	
	public TaskDTOLocal create(TaskDTOLocal DTO) {
		commonDAO.setEm(em);
		return commonDAO.create(DTO);
	}
	
	public TaskDAO() {
		converter = new TaskConverter();
		commonDAO = new CommonDAOimpl<TaskDTOLocal>(converter);
	}

	@Override
	public TaskDTOLocal findByPrimaryKey(Integer id, String namedQuery) {
		commonDAO.setEm(em);
		return commonDAO.findByPrimaryKey(id, "Task.findByPrimaryKey");
	}

	@Override
	public void deleteByPrimaryKey(Integer id, String namedQuery) {
		commonDAO.setEm(em);
		commonDAO.deleteByPrimaryKey(id, "Task.deleteByPrimaryKey");
		
	}

	@Override
	public TaskDTOLocal update(TaskDTOLocal DTO) {
		commonDAO.setEm(em);
		em.merge(converter.toDomain(DTO));
		return DTO;
	}
}
