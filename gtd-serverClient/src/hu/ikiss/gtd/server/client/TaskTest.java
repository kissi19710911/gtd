package hu.ikiss.gtd.server.client;

import hu.ikiss.gtd.businessinterface.ProjectBusiness;
import hu.ikiss.gtd.businessinterface.TaskBusiness;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.naming.NamingException;


public class TaskTest {


  private static final String HOST = "localhost";

  public static void main(final String... args) {
    final TaskTest test = new TaskTest();
    try {
      test.doTests();
    } catch (final NamingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  private final RemoteEJBConnection ejbConnection = new RemoteEJBConnection();


  public TaskTest() {
  }

  private void businessTest1() throws NamingException {
    this.lookupTaskBusiness();
  }

  private void doTests() throws NamingException {
    // daoTest1();
    // businessTest1();
    this.remoteTomcatTest();
  }

  private TaskBusiness lookupTaskBusiness() {
    try {
      this.ejbConnection.setAppName("gtd-application");
      this.ejbConnection.setModuleName("gtd-server-0.0.1-SNAPSHOT");
      this.ejbConnection.setDistinctName("");
      this.ejbConnection.setBeanName("TaskBusiness");// TaskBusinessRemote.class.getSimpleName();
      this.ejbConnection.setViewClassName(TaskBusiness.class.getName());
      final TaskBusiness bean = (TaskBusiness) this.ejbConnection.lookup();
      return bean;

    } catch (final NamingException ne) {
      throw new RuntimeException(ne);
    }

  }

  private void remoteTomcatTest() {
    try {
      final Registry registry = LocateRegistry.getRegistry(TaskTest.HOST, 9345);
      final String[] names = registry.list();
      for (final String name1 : names) {
        System.out.println("~~~~" + name1 + "~~~~");
      }
      final ProjectBusiness serv = (ProjectBusiness) registry.lookup(ProjectBusiness.serviceName);
      System.out.println(serv.create(null));
    } catch (final Exception e) {
      System.err.println("Remoteservice exception:");
      e.printStackTrace();
    }
  }

}
