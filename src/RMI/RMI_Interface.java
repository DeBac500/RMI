package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;;

public interface RMI_Interface extends Remote{
	public Integer dosomething(int i) throws RemoteException;
}