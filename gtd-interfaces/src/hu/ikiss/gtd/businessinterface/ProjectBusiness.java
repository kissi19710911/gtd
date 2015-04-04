package hu.ikiss.gtd.businessinterface;

import hu.ikiss.gtd.dto.ProjectDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProjectBusiness extends Remote {
  String serviceName = "ProjectServiceRMI";

  ProjectDTO create(ProjectDTO dto) throws RemoteException;
}
