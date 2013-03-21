package RMI_Srv;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Controller {
	public static void main (String[] args){
		if(System.getSecurityManager() == null)
			System.setSecurityManager(new SecurityManager());
		
		try{
			String name = "test";
			RMI_Interface tt = new Srv();
			RMI_Interface stub = (RMI_Interface) UnicastRemoteObject.exportObject(tt,1234);
			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind(name,  stub);
			System.out.println("Gebunden!");
		}catch(Exception e){
			System.err.println("Fehler: " +e.getMessage());
		}
	}
}
