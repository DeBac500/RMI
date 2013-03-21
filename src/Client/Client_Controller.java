package Client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMI_Srv.RMI_Interface;
/**
 * Diese Klasse Stellt eine Verbindung zu einem Server her und führt auf diesem Server Methoden aus
 * @author Dominik Backhausen
 */
public class Client_Controller {
	public static void main (String[] args){
		boolean a =true;
		int port = 0;
		String add="localhost";
		if(args.length > 0){
			if(args[0].charAt(0)=='d'){
				a=false;
				port = 1099;
				add = "127.0.0.1";
			}else if(args.length >1){ 
				a=false;
				port = Integer.parseInt(args[1]);
				add = args[0];
			}
		}
		if(a)
			System.out.println("No valid Server Address and Port\n <port> | Server addresse und Serverport angeben \n d | default werte verwenden (127.0.0.1:1099)");
		else{
			if(System.getSecurityManager() == null)
				System.setSecurityManager(new SecurityManager()); //Security Manager setzen
			
			try{
				String name = "test";
				Registry reg = LocateRegistry.getRegistry(add,port); //Ruft die Regestry auf dem server mit deer IP 10.0.0.3 auf dem port 1099 ab
				RMI_Interface tt = (RMI_Interface) reg.lookup(name);//Sucht nach einem Serverobjekt mit dem namen test
				Double d = tt.dosomething(2.0);//Führt die Freigegebene Methode am server aus und erhält ein ergebniss
				System.out.println("Ergebniss = " + d);//Gibt ergebniss zur kontrolle aus
			}catch (Exception e){
				System.err.println("Fehler: " + e.getMessage());
			}
		}
	}
}
