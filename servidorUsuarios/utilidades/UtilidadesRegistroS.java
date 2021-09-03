
package servidorUsuarios.utilidades;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class UtilidadesRegistroS
{
	public static void arrancarNS(String direccionIPNS, int numPuertoNS) throws RemoteException
	{
		try
		{

			Registry registro = LocateRegistry.getRegistry(direccionIPNS, numPuertoNS);
			registro.list();

			System.out.println("El n_s se ha obtenido y se encuentra escuchando en la direccion IP "+direccionIPNS+" y puerto "+numPuertoNS);

		}
		catch(RemoteException e)
		{
			System.out.println("El registro RMI no se localizo");

			Registry registro = LocateRegistry.createRegistry(numPuertoNS);
			System.out.println("El registro se ha creado ");
		}

	}


	public static void RegistrarObjetoRemoto(Remote objetoRemoto, String dirIPNS, int numPuertoNS, String nombreObjeto)
	{
		String UrlRegistro = "rmi://"+dirIPNS+":"+numPuertoNS+"/"+nombreObjeto;
		try
		{
			Naming.rebind(UrlRegistro, objetoRemoto);
			System.out.println("Se realizo el registro del objeto remoto con la direccion: " +UrlRegistro);
		} catch (RemoteException e)
		{
			System.out.println("Error en el registro del objeto remoto");
			e.printStackTrace();
		} catch (MalformedURLException e)
		{
			System.out.println("Error url invalida");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
