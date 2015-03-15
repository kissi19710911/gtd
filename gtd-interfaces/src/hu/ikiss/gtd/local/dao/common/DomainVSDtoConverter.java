package hu.ikiss.gtd.local.dao.common;

import java.io.Serializable;

public interface DomainVSDtoConverter<T> {
	public T toDTO(Serializable domain);

	public Serializable toDomain(T dto);
}
