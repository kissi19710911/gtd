package hu.ikiss.gtdt.dao;

import java.io.Serializable;

public interface DomainVSDtoConverter<T> {
	public T toDTO(Serializable domain);

	public Serializable toDomain(T dto);
}
