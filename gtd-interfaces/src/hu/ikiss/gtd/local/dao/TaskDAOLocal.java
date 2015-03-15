package hu.ikiss.gtd.local.dao;

import hu.ikiss.gtd.local.dao.common.CommonDAO;
import hu.ikiss.gtd.local.dto.TaskDTOLocal;

import javax.ejb.Local;

@Local
public interface TaskDAOLocal  extends CommonDAO <TaskDTOLocal>{
	TaskDTOLocal create(TaskDTOLocal dto);

}
