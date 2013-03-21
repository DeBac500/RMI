package RMI_Srv;

import java.rmi.RemoteException;
/**
 * Diese Klasse implementiert das interface und ist somit der Server der die Methoden zu verfügung stellt und seinen dienst anbietet
 * @author Dominik Backhasuen
 */
public class Srv implements RMI_Interface{
	/**
	 * Konstruktor
	 */
	public Srv(){
		super();
	}
	/**
	 * Die Methode die Freigegeben werden und pi berechnet und dien parameter dazu addiert
	 */
	@Override
	public Double dosomething(double i) throws RemoteException {
		return Math.PI + i;
	}

}
