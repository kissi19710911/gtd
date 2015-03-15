package hu.ikiss.gtd.server.client;

import hu.ikiss.gtd.local.dto.TaskDTOLocal;
import hu.ikiss.gtd.remote.businessinterface.TaskBusinessRemote;
import hu.ikiss.gtd.remote.dao.TaskDAORemote;

import javax.naming.NamingException;

public class TaskTest {


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

	public static void main(String[] args) throws NamingException {
		TaskTest test = new TaskTest();
		test.doTests();

	}

	private void doTests() throws NamingException {
		daoTest1();
		businessTest1();
	}

	private void daoTest1() {
		TaskDTOLocal localDTO = new TaskDTOLocal();
		localDTO.setName("Tululu");
		localDTO = lookupTaskDAO().create(localDTO);
	}

	private void businessTest1() throws NamingException {
	}

	public TaskTest() {
	}
}
