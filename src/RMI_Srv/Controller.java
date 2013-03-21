package RMI_Srv;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
/**
 * Das Ist der Controller zum Starten des Servers
 * @author Dominik Backhausen
 */
public class Controller {
	public static void main (String[] args){
		if(System.getSecurityManager() == null)
			System.setSecurityManager(new SecurityManager());//Security Manager setzen
		
		try{
			String name = "test";
			RMI_Interface tt = new Srv(); //Erstelle einen Neuen Server
			RMI_Interface stub = (RMI_Interface) UnicastRemoteObject.exportObject(tt,1234);//Stellt das Server objekt auf dem port 1234 zu verfügung
			Registry reg = LocateRegistry.createRegistry(1099);//Erstellt eine Regestry auf dem Port 1099
			reg.rebind(name,  stub); // bindet den Server an die regestry unter den namen test
			System.out.println("Gebunden!");
		}catch(Exception e){
			System.err.println("Fehler: " +e.getMessage());
		}
	}
}
