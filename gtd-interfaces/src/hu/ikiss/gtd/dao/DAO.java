package hu.ikiss.gtd.dao;

import hu.ikiss.gtd.dto.ProjectDTO;

public interface DAO<T> {

  ProjectDTO create(T dto);

  void deleteByPrimaryKey(Long id);

  T findByPrimaryKey(Long id);

  ProjectDTO update(T DTO);

}
