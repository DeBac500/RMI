package Client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMI_Srv.RMI_Interface;
/**
 * Diese Klasse Stellt eine Verbindung zu einem Server her und ruft die Registry am Server mit der angegebenen 
 * IP auf dem Port 1099 ab. Danach wird nach einem Serverobjekt mit dem Namen "test" gesucht und die freigegebene Methode ausgefuehrt.
 * Von dieser Methode erhaelt man ein Ergebnis welches nachher ausgegeben wird. 
 * 
 * Sollte die Verbindung fehlschlagen oder ein anderes Problem zur Laufzeit auftreten erhaelt man eine Fehlermeldung.
 * 
 * @author Dominik Backhausen, Alexander Rieppel
 */
public class Client_Controller {
	public static void main (String[] args){
		if(System.getSecurityManager() == null)
			System.setSecurityManager(new SecurityManager()); //Security Manager setzen
		
		try{
			String name = "test";
			Registry reg = LocateRegistry.getRegistry("127.0.0.1",1099); //Ruft die Registry auf dem Server mit der angegebenen IP
																		 //auf dem port 1099 ab
			
			RMI_Interface tt = (RMI_Interface) reg.lookup(name);//Sucht nach einem Serverobjekt mit dem Namen test
			Double d = tt.dosomething(2.0);//Fuehrt die Freigegebene Methode am Server aus und erhält ein Ergebnis
			System.out.println("Ergebniss = " + d);//Gibt Ergebnis zur kontrolle aus
		}catch (Exception e){
			System.err.println("Fehler: " + e.getMessage());
		}
	}
}
