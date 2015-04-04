package hu.ikiss.gtd.businessinterface;

import hu.ikiss.gtd.dto.TaskDTO;

import java.rmi.RemoteException;
import java.util.Collection;

public interface TaskBusiness {
  String serviceName = "TaskServiceRMI";

  TaskDTO create(TaskDTO dto) throws RemoteException;

  Collection<TaskDTO> findRelevant() throws RemoteException;

}
