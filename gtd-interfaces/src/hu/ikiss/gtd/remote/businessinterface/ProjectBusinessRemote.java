package hu.ikiss.gtd.remote.businessinterface;

import hu.ikiss.gtd.remote.dto.ProjectDTORemote;

import java.rmi.RemoteException;

import javax.ejb.Remote;

@Remote
public interface ProjectBusinessRemote  extends java.rmi.Remote{
	ProjectDTORemote create(ProjectDTORemote dto) throws RemoteException;
}
