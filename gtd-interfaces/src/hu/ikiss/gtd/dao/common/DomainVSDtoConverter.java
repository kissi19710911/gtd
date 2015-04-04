package hu.ikiss.gtd.dao.common;

import hu.ikiss.gtd.local.DTO;
import hu.ikiss.gtd.local.Domain;

public interface DomainVSDtoConverter<T extends DTO, L extends Domain> {
  public L toDomain(T dto);

  public T toDTO(L domain);
}
