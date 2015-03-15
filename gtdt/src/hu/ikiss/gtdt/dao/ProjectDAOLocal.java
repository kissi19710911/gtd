package hu.ikiss.gtdt.dao;

import hu.ikiss.gtdt.dto.ProjectDTOLocal;

public interface ProjectDAOLocal  extends CommonDAO <ProjectDTOLocal>{
	ProjectDTOLocal create(ProjectDTOLocal dto);

}
