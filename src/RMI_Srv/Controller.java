package RMI_Srv;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Dies ist der Controller zum Starten des Servers
 * 
 * Die Klasse erzeugt einen neuen Server und stellt das Serverobjekt auf dem Port 1234 zur Verfuegung.
 * Darüber hinaus wird eine Registry auf dem Port 1099 erstellt und bindet den Server an die Registry mit dem Namen "test"
 * 
 * Sollte das Binden des Servers fehlschlagen erhaelt man eine Fehlermeldung.
 * 
 * @author Dominik Backhausen, Alexander Rieppel
 */
public class Controller {
	public static void main (String[] args){
		boolean a = true;
		int port = 0;
		if(args.length > 0)
			if(args[0].charAt(0) == 'd'){
				a = false;
				port = 1099;
			}else{
				a = false;
				port = Integer.parseInt(args[0]);
			}
		
		if(a)
			System.out.println("Falsche eingabe! \n Bitte Port eingeben <port> \n d defaultwert (1099");
		else{
			
			if(System.getSecurityManager() == null)
				System.setSecurityManager(new SecurityManager());//Security Manager setzen
		
			try{
				String name = "test";
				RMI_Interface tt = new Srv(); //Erstellt einen neuen Server
				RMI_Interface stub = (RMI_Interface) UnicastRemoteObject.exportObject(tt,1234);//Stellt das Server objekt auf dem port 1234 zur verfügung
				Registry reg = LocateRegistry.createRegistry(1099);//Erstellt eine Registry auf dem Port 1099
				reg.rebind(name,  stub); // bindet den Server an die regestry unter den namen test
				System.out.println("Gebunden!");
			}catch(Exception e){
				System.err.println("Fehler: " +e.getMessage());
			}
		}
	}
}
