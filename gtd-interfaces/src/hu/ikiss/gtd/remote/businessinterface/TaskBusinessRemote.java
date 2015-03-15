package hu.ikiss.gtd.remote.businessinterface;

import hu.ikiss.gtd.remote.dto.TaskDTORemote;

import javax.ejb.Remote;

@Remote
public interface TaskBusinessRemote {
	TaskDTORemote create(TaskDTORemote dto);
}
