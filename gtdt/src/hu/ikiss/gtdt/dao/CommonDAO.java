package hu.ikiss.gtdt.dao;



public interface CommonDAO<T extends Comparable<T>> {
	T findByPrimaryKey(Integer id, String namedQuery);
	void deleteByPrimaryKey(Integer id, String namedQuery);
    T create(T DTO);
    
    T update(T DTO);
}
