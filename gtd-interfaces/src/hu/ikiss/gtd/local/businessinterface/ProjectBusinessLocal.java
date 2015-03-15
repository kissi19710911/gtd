package hu.ikiss.gtd.local.businessinterface;

import hu.ikiss.gtd.remote.dto.ProjectDTORemote;

import javax.ejb.Local;

@Local
public interface ProjectBusinessLocal {
	ProjectDTORemote create(ProjectDTORemote dto);
}
