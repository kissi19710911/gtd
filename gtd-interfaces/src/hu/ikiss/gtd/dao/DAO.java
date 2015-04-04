package hu.ikiss.gtd.dao;

import hu.ikiss.gtd.dto.ProjectDTO;

public interface DAO<T> {

  ProjectDTO create(T dto);

  void deleteByPrimaryKey(Integer id);

  T findByPrimaryKey(Integer id);

  ProjectDTO update(T DTO);

}
