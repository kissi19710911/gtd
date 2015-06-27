package hu.ikiss.gtd.server.business.impl;

import hu.ikiss.gtd.businessinterface.TaskBusiness;
import hu.ikiss.gtd.dto.TaskDTO;
import hu.ikiss.gtd.dto.TasksDTO;

import java.rmi.RemoteException;
import java.util.List;

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
  public void delete(final TaskDTO taskDTO) throws RemoteException {
    this.taskDao.deleteByPrimaryKey(taskDTO.getId());
  }

  @Override
  public TaskDTO findById(final Long taskId) throws RemoteException {
    return this.taskDao.findByPrimaryKey(taskId);
  }

  @Override
  public TasksDTO findRelevant() throws RemoteException {
    final List<TaskDTO> res = this.taskDao.findRelevant();
    final TasksDTO tasks = new TasksDTO();
    tasks.setTasks(res);
    return tasks;
  }

  @Override
  public TaskDTO update(final TaskDTO taskDTO) throws RemoteException {
    return this.taskDao.update(taskDTO);
  }
}
