package hu.ikiss.gtd.server.dao.impl;

import hu.ikiss.gtd.dao.common.CommonDAOInt;
import hu.ikiss.gtd.dao.common.DomainVSDtoConverter;
import hu.ikiss.gtd.local.DTO;
import hu.ikiss.gtd.local.Domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class CommonDAOimpl<T extends DTO, L extends Domain> implements CommonDAOInt<T> {

  DomainVSDtoConverter<T, L> converter;

  @PersistenceContext(unitName = "gtdDS")
  private EntityManager      em;


  public CommonDAOimpl(final DomainVSDtoConverter<T, L> converter) {
    this.converter = converter;
  }

  @Override
  public T create(final T DTO) {

    final L domain = this.converter.toDomain(DTO);
    this.em.persist(domain);
    return this.converter.toDTO(domain);
  }

  @Override
  public void deleteByPrimaryKey(final Integer id, final String namedQuery) {
    final Query query = this.em.createNamedQuery(namedQuery);
    query.setParameter("id", id);
    query.executeUpdate();
  }

  @Override
  public T findByPrimaryKey(final Integer id, final String namedQuery) {
    final Query query = this.em.createNamedQuery(namedQuery);
    query.setParameter("id", id);
    final L queryRes = (L) query.getSingleResult();
    final T res = this.converter.toDTO(queryRes);
    return res;
  }

  @Override
  public List<T> findByQuery(final String namedQuery, final String... param) {
    final Query query = this.em.createNamedQuery(namedQuery);
    final List<T> res = new ArrayList<T>();
    int i = 1;
    if (param != null) {
      for (final String par : param) {
        query.setParameter(i++, par);
      }
    }
    for (final L r : (Collection<L>) query.getResultList()) {
      res.add(this.converter.toDTO(r));
    }
    return res;
  }

  public void setEm(final EntityManager em) {
    this.em = em;
  }

  @Override
  public T update(final T DTO) {
    L domain = this.converter.toDomain(DTO);
    domain = this.em.merge(domain);
    return this.converter.toDTO(domain);
  }

}
