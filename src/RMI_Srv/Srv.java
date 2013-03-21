package RMI_Srv;

import java.rmi.RemoteException;

public class Srv implements RMI_Interface{
	
	public Srv(){
		super();
	}

	@Override
	public Double dosomething(double i) throws RemoteException {
		return Math.PI + i;
	}

}
