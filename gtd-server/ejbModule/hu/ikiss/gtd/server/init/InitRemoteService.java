package hu.ikiss.gtd.server.init;

import hu.ikiss.gtd.businessinterface.ProjectBusiness;
import hu.ikiss.gtd.server.business.impl.ProjectServices;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.springframework.stereotype.Component;

@Component
public class InitRemoteService {
  public static boolean         isRegistered = false;
  public static ProjectBusiness service;

  public InitRemoteService() {
    if (!InitRemoteService.isRegistered) {
      try {
        InitRemoteService.service = new ProjectServices();
        final ProjectBusiness stub =
            (ProjectBusiness) UnicastRemoteObject.exportObject(InitRemoteService.service, 0);
        final Registry registry = LocateRegistry.createRegistry(9345);
        registry.rebind(ProjectServices.serviceName, stub);
        System.out.println("Remote service bound");
        InitRemoteService.isRegistered = true;
      } catch (final Exception e) {
        System.err.println("Remote service exception:");
        e.printStackTrace();
      }
    }
  }
}
