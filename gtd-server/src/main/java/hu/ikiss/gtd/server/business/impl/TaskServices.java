package hu.ikiss.gtd.server.business.impl;

import hu.ikiss.gtd.businessinterface.TaskBusiness;
import hu.ikiss.gtd.dto.TaskDTO;

import java.rmi.RemoteException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskServices implements TaskBusiness {
  @Autowired
  hu.ikiss.gtd.dao.TaskDAO taskDao;

  @Override
  public TaskDTO create(final TaskDTO dto) throws RemoteException {
    TaskDTO dtoLocal = new TaskDTO();
    dtoLocal.setName(dto.getName());
    dtoLocal = this.taskDao.create(dtoLocal);

    dto.setId(dtoLocal.getId());
    dto.setName(dtoLocal.getName());
    return dto;
  }

  @Override
  public Collection<TaskDTO> findRelevant() throws RemoteException {
    final Collection<TaskDTO> res = this.taskDao.findRelevant();
    return res;
  }
}
