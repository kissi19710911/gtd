package hu.ikiss.gtdt.service;

import java.util.List;

public interface GTDTService<T> {
   T add(T dto);
   List<T> list();
   List<T> list(Integer parentId);
   void remove(Integer id);
   T update(T dto);
}
