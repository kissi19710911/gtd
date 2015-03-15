package hu.ikiss.gtd.remote.dao;

import hu.ikiss.gtd.local.dto.ProjectDTOLocal;

import javax.ejb.Remote;

@Remote
public interface ProjectDAORemote {
	ProjectDTOLocal create(ProjectDTOLocal dto);

}
