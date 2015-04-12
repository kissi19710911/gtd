package hu.ikiss.gtd.dao;

import hu.ikiss.gtd.dto.TaskDTO;

import java.util.List;

public interface TaskDAO {
  TaskDTO create(TaskDTO dto);

  void deleteByPrimaryKey(Integer id);

  TaskDTO findByPrimaryKey(Integer id);

  public List<TaskDTO> findRelevant();

  void setEm();

  TaskDTO update(TaskDTO DTO);
}
