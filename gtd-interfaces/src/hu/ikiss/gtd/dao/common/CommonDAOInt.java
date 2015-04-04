package hu.ikiss.gtd.dao.common;

import hu.ikiss.gtd.local.DTO;

import java.util.Collection;



public interface CommonDAOInt<T extends DTO> {
  T create(T DTO);

  void deleteByPrimaryKey(Integer id, String namedQuery);

  T findByPrimaryKey(Integer id, String namedQuery);

  Collection<T> findByQuery(String namedQuery, String... param);

  T update(T DTO);
}
