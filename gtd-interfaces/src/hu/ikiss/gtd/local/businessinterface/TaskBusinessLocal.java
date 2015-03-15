package hu.ikiss.gtd.local.businessinterface;

import hu.ikiss.gtd.remote.dto.TaskDTORemote;

import javax.ejb.Local;

@Local
public interface TaskBusinessLocal {
	TaskDTORemote create(TaskDTORemote dto);
}
