package hu.ikiss.gtd.remote.businessinterface;

import hu.ikiss.gtd.remote.dto.ProjectDTORemote;

import javax.ejb.Remote;

@Remote
public interface ProjectBusinessRemote {
	ProjectDTORemote create(ProjectDTORemote dto);
}
