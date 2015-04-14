package hu.ikiss.gtd.dao;

import hu.ikiss.gtd.dto.TaskDTO;

import java.util.List;

public interface TaskDAO {
  TaskDTO create(TaskDTO dto);

  void deleteByPrimaryKey(Long id);

  TaskDTO findByPrimaryKey(Long id);

  public List<TaskDTO> findRelevant();

  void setConverter();

  void setEm();

  TaskDTO update(TaskDTO DTO);
}
