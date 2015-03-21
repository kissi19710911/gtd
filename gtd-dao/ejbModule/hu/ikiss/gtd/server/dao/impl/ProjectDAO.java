package hu.ikiss.gtd.server.dao.impl;

import hu.ikiss.gtd.local.dao.ProjectDAOLocal;
import hu.ikiss.gtd.local.dao.common.DomainVSDtoConverter;
import hu.ikiss.gtd.local.dto.ProjectDTOLocal;
import hu.ikiss.gtd.remote.dao.ProjectDAORemote;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
@Stateless
@Local(ProjectDAO.class)
@Remote(ProjectDAORemote.class)
@EJB(name = "ProjectDAO", beanInterface = ProjectDAO.class)
public class ProjectDAO implements
ProjectDAOLocal, ProjectDAORemote {

	@PersistenceContext(unitName = "gtdDS")
	private EntityManager em;

	private  DomainVSDtoConverter<ProjectDTOLocal> converter;

	private CommonDAOimpl<ProjectDTOLocal> commonDAO;
	
	public ProjectDTOLocal create(ProjectDTOLocal DTO) {
		commonDAO.setEm(em);
		return commonDAO.create(DTO);
	}
	
	public ProjectDAO() {
		converter = new ProjectConverter();
		commonDAO = new CommonDAOimpl<ProjectDTOLocal>(converter);
	}

	@Override
	public ProjectDTOLocal findByPrimaryKey(Integer id, String namedQuery) {
		commonDAO.setEm(em);
		return commonDAO.findByPrimaryKey(id, "Project.findByPrimaryKey");
	}

	@Override
	public void deleteByPrimaryKey(Integer id, String namedQuery) {
		commonDAO.setEm(em);
		commonDAO.deleteByPrimaryKey(id, "Project.deleteByPrimaryKey");
		
	}

	@Override
	public ProjectDTOLocal update(ProjectDTOLocal DTO) {
		commonDAO.setEm(em);
		em.merge(converter.toDomain(DTO));
		return DTO;
	}
}
