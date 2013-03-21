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
			Registry reg = LocateRegistry.getRegistry("10.0.0.3",1099);
			System.out.println("t1");
			RMI_Interface tt = (RMI_Interface) reg.lookup(name);
			System.out.println("t2");
			Double d = tt.dosomething(2.0);
			System.out.println("Ergebniss = " + d);
		}catch (Exception e){
			System.err.println("Fehler: " + e.getMessage());
		}
	}
}
