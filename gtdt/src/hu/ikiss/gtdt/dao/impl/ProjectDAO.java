package hu.ikiss.gtdt.dao.impl;

import hu.ikiss.gtdt.dao.DomainVSDtoConverter;
import hu.ikiss.gtdt.dao.ProjectDAOLocal;
import hu.ikiss.gtdt.dto.ProjectDTOLocal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class ProjectDAO implements
ProjectDAOLocal {

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
