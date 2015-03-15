package hu.ikiss.gtd.server.dao.impl;

import hu.ikiss.gtd.local.dao.common.DomainVSDtoConverter;
import hu.ikiss.gtd.local.dto.TaskDTOLocal;
import hu.ikiss.gtd.server.domain.Task;

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
