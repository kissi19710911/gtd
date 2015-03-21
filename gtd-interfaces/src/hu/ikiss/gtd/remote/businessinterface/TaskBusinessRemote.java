package hu.ikiss.gtd.remote.businessinterface;

import hu.ikiss.gtd.remote.dto.TaskDTORemote;

import java.rmi.RemoteException;

import javax.ejb.Remote;

@Remote
public interface TaskBusinessRemote extends java.rmi.Remote{
	TaskDTORemote create(TaskDTORemote dto) throws RemoteException;
}
