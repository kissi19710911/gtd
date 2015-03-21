package hu.ikiss.gtd.server.init;

import hu.ikiss.gtd.remote.businessinterface.ProjectBusinessRemote;
import hu.ikiss.gtd.server.business.impl.ProjectBusiness;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.springframework.stereotype.Component;

@Component
public class InitRemoteService {
  public static boolean isRegistered = false; 
  public static ProjectBusinessRemote service; 
  public InitRemoteService(){ 
   if(!isRegistered){ 
      try { 
          service = new ProjectBusiness(); 
          ProjectBusinessRemote stub = 
              (ProjectBusinessRemote) UnicastRemoteObject.exportObject(service, 0); 
          Registry registry = LocateRegistry.createRegistry(9345); 
          registry.rebind(ProjectBusiness.serviceName, stub); 
          System.out.println("Remote service bound"); 
          isRegistered = true; 
      } catch (Exception e) { 
          System.err.println("Remote service exception:"); 
          e.printStackTrace(); 
      } 
  } 
  } 
}
