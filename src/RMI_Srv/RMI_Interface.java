package RMI_Srv;

import java.rmi.Remote;
import java.rmi.RemoteException;;
/**
 * Das ist das Interface das Remote erweitert und die Methoden die Freigegeben werden sollen aufführt
 * @author Dominik Backhausen, Alexander Rieppel
 */
public interface RMI_Interface extends Remote{
	/**
	 * Diese Methode Wird Freigegeben
	 * 
	 * @param i Parameter um das Ergebniss zu beinflussen
	 * @return Ergebniss der Verarbeitung
	 * @throws RemoteException
	 */
	public Double dosomething(double i) throws RemoteException;
}