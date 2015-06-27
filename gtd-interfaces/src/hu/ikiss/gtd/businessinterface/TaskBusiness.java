package hu.ikiss.gtd.businessinterface;

import hu.ikiss.gtd.dto.TaskDTO;
import hu.ikiss.gtd.dto.TasksDTO;

import java.rmi.RemoteException;

public interface TaskBusiness {
  String serviceName = "TaskServiceRMI";

  TaskDTO create(TaskDTO dto) throws RemoteException;

  void delete(TaskDTO taskDTO) throws RemoteException;

  TaskDTO findById(Long taskId) throws RemoteException;

  TasksDTO findRelevant() throws RemoteException;

  TaskDTO update(TaskDTO taskDTO) throws RemoteException;

}
