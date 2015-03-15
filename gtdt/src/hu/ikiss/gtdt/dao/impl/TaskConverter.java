package hu.ikiss.gtdt.dao.impl;

import hu.ikiss.gtdt.dao.DomainVSDtoConverter;
import hu.ikiss.gtdt.domain.Task;
import hu.ikiss.gtdt.dto.TaskDTOLocal;

import java.io.Serializable;

public class TaskConverter implements DomainVSDtoConverter<TaskDTOLocal>{

	@Override
	public TaskDTOLocal toDTO(Serializable domain) {
		Task toConvert = (Task)domain;
		TaskDTOLocal res = new TaskDTOLocal();
		res.setId(toConvert.getId());
		res.setName(toConvert.getName());
		return res;
	}

	@Override
	public Serializable toDomain(TaskDTOLocal dto) {
		Task domain = new Task();
		domain.setId(dto.getId());
		domain.setName(dto.getName());
		return domain;
	}

}
