package hu.ikiss.gtdt.dao.impl;

import hu.ikiss.gtdt.dao.CommonDAO;
import hu.ikiss.gtdt.dao.DomainVSDtoConverter;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CommonDAOimpl<T extends Comparable<T>> implements CommonDAO<T> {

	private EntityManager em;

	DomainVSDtoConverter<T> converter;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public T findByPrimaryKey(Integer id, String namedQuery) {
		Query query = em.createNamedQuery(namedQuery);
		query.setParameter("id", id);
		Object queryRes = query.getSingleResult();
		T res = converter.toDTO((Serializable) queryRes);
		return res;
	}

	@Override
	public void deleteByPrimaryKey(Integer id, String namedQuery) {
		Query query = em.createNamedQuery(namedQuery);
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public T create(T DTO) {

		Serializable domain = converter.toDomain(DTO);
		em.persist(domain);
		return converter.toDTO(domain);
	}

	@Override
	public T update(T DTO) {
		Serializable domain = converter.toDomain(DTO);
		domain = em.merge(domain);
		return converter.toDTO(domain);
	}

	@SuppressWarnings("unused")
	private CommonDAOimpl() {

	}

	public CommonDAOimpl(DomainVSDtoConverter<T> converter) {
		this.converter = converter;
	}

}
