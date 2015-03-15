package hu.ikiss.gtd.local.dao;

import hu.ikiss.gtd.local.dao.common.CommonDAO;
import hu.ikiss.gtd.local.dto.ProjectDTOLocal;

import javax.ejb.Local;

@Local
public interface ProjectDAOLocal  extends CommonDAO <ProjectDTOLocal>{
	ProjectDTOLocal create(ProjectDTOLocal dto);

}
