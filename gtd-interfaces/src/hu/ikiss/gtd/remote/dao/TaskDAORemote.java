package hu.ikiss.gtd.remote.dao;

import hu.ikiss.gtd.local.dto.TaskDTOLocal;

import javax.ejb.Remote;

@Remote
public interface TaskDAORemote {
	TaskDTOLocal create(TaskDTOLocal dto);

}
