package RMI_Srv;

import java.rmi.Remote;
import java.rmi.RemoteException;;

public interface RMI_Interface extends Remote{
	public Double dosomething(double i) throws RemoteException;
}