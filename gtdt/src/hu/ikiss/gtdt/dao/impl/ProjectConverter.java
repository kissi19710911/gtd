package hu.ikiss.gtdt.dao.impl;

import hu.ikiss.gtdt.dao.DomainVSDtoConverter;
import hu.ikiss.gtdt.domain.Project;
import hu.ikiss.gtdt.dto.ProjectDTOLocal;

import java.io.Serializable;

public class ProjectConverter implements DomainVSDtoConverter<ProjectDTOLocal>{

	@Override
	public ProjectDTOLocal toDTO(Serializable domain) {
		Project toConvert = (Project)domain;
		ProjectDTOLocal res = new ProjectDTOLocal();
		res.setId(toConvert.getId());
		res.setName(toConvert.getName());
		return res;
	}

	@Override
	public Serializable toDomain(ProjectDTOLocal dto) {
		Project domain = new Project();
		domain.setId(dto.getId());
		domain.setName(dto.getName());
		return domain;
	}

}
