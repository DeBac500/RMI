package Client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMI_Srv.RMI_Interface;

public class Client_Controller {
	public static void main (String[] args){
		if(System.getSecurityManager() == null)
			System.setSecurityManager(new SecurityManager());
		
		try{
			String name = "test";
			Registry reg = LocateRegistry.getRegistry(1099);
			RMI_Interface tt = (RMI_Interface) reg.lookup(name);
			Double d = tt.dosomething(3.0);
			System.out.println("Ergebniss = " + d);
		}catch (Exception e){
			System.err.println("Fehler: " + e.getMessage());
		}
	}
}
