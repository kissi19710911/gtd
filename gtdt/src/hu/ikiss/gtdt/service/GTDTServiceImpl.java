package hu.ikiss.gtdt.service;

import hu.ikiss.gtdt.dao.CommonDAO;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.transaction.annotation.Transactional;

public abstract class GTDTServiceImpl<T extends Comparable<T>> extends HttpServlet implements GTDTService<T>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3836053802687743045L;
	protected CommonDAO<T> dao;
	
	public GTDTServiceImpl(CommonDAO<T> dao){
		this.dao = dao;
	}

	@Override
	@Transactional
	public T add(T dto) {
		return dao.create(dto);
	}

	@Override
	@Transactional
	public T update(T dto) {
		return dao.update(dto);
	}

	@Override
	@Transactional
	public List<T> list() {
		return null;
	}

	@Override
	@Transactional
	public List<T> list(Integer parentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
