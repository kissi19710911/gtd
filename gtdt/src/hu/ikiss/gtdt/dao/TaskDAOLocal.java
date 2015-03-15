package hu.ikiss.gtdt.dao;

import hu.ikiss.gtdt.dto.TaskDTOLocal;


public interface TaskDAOLocal  extends CommonDAO <TaskDTOLocal>{
	TaskDTOLocal create(TaskDTOLocal dto);

}
