package hu.ikiss.gtd.server.client;

import hu.ikiss.gtd.local.dto.TaskDTOLocal;
import hu.ikiss.gtd.remote.businessinterface.ProjectBusinessRemote;
import hu.ikiss.gtd.remote.businessinterface.TaskBusinessRemote;
import hu.ikiss.gtd.remote.dao.TaskDAORemote;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.naming.NamingException;

public class TaskTest {


	private static final String HOST = "localhost";
  private final RemoteEJBConnection ejbConnection = new RemoteEJBConnection();

	private TaskBusinessRemote lookupTaskBusiness() {
		try {
			ejbConnection.setAppName("gtd-application");
			ejbConnection.setModuleName("gtd-server-0.0.1-SNAPSHOT");
			ejbConnection.setDistinctName("");
			ejbConnection.setBeanName("TaskBusiness");// TaskBusinessRemote.class.getSimpleName();
			ejbConnection.setViewClassName(TaskBusinessRemote.class.getName());
			TaskBusinessRemote bean = (TaskBusinessRemote) ejbConnection
					.lookup();
			return bean;

		} catch (NamingException ne) {
			throw new RuntimeException(ne);
		}

	}

	private TaskDAORemote lookupTaskDAO() {
		try {
			ejbConnection.setAppName("gtd-application");
			ejbConnection.setModuleName("gtd-dao-0.0.1-SNAPSHOT");
			ejbConnection.setDistinctName("");
			ejbConnection.setBeanName("TaskDAO");
			ejbConnection.setViewClassName(TaskDAORemote.class.getName());
			TaskDAORemote bean = (TaskDAORemote) ejbConnection
					.lookup();
			return bean;

		} catch (NamingException ne) {
			throw new RuntimeException(ne);
		}

	}

	private void doTests() throws NamingException {
//		daoTest1();
//		businessTest1();
	  remoteTomcatTest();
	}

	private void remoteTomcatTest() {
	  try { 
	    Registry registry = LocateRegistry.getRegistry(HOST,9345); 
	    String[] names = registry.list(); 
	    for(String name1 : names){ 
	        System.out.println("~~~~" + name1 + "~~~~"); 
	    } 
	    ProjectBusinessRemote serv = (ProjectBusinessRemote) registry.lookup(ProjectBusinessRemote.serviceName); 
	    System.out.println(serv.create(null)); 
	} catch (Exception e) { 
	    System.err.println("Remoteservice exception:"); 
	    e.printStackTrace(); 
	}  }

  private void daoTest1() {
		TaskDTOLocal localDTO = new TaskDTOLocal();
		localDTO.setName("Tululu");
		localDTO = lookupTaskDAO().create(localDTO);
	}

	private void businessTest1() throws NamingException {
	  lookupTaskBusiness();
	}

	public TaskTest() {
	}
	
    public static void main(String... args){
      TaskTest test = new TaskTest();
      try {
        test.doTests();
      } catch (NamingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

  }

}
