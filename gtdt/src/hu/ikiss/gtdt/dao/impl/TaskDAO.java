package hu.ikiss.gtdt.dao.impl;

import hu.ikiss.gtdt.dao.DomainVSDtoConverter;
import hu.ikiss.gtdt.dao.TaskDAOLocal;
import hu.ikiss.gtdt.dto.TaskDTOLocal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import hu.ikiss.gtd.server.domain.Task;

import org.springframework.stereotype.Repository;

@Repository
public class TaskDAO implements
		TaskDAOLocal {

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
