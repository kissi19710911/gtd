package hu.ikiss.gtd.dao.common;

import hu.ikiss.gtd.local.DTO;

import java.util.Collection;



public interface CommonDAOInt<T extends DTO> {
  T create(T DTO);

  void deleteByPrimaryKey(Long id, String namedQuery);

  T findByPrimaryKey(Long id, String namedQuery);

  Collection<T> findByQuery(String namedQuery, String... param);

  T update(T DTO);
}
