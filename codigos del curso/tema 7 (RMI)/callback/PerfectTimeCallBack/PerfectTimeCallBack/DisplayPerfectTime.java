// Implementación de la interfaz DisplayPerfectTimeI
// mediante la clase DisplayPerfectTime
// Utiliza el método remoto de la interfaz PerfectTimeI

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class DisplayPerfectTime extends UnicastRemoteObject
                                implements DisplayPerfectTimeI {

  public void sendMessageCallBack(String str) throws RemoteException {
    System.out.println("Mensaje del servidor: " + str);
  }

  public DisplayPerfectTime() throws RemoteException {
  	super();
  }

  public static void main(String [] args) throws Exception {
    System.setSecurityManager(new RMISecurityManager()); // gestor de seguridad
    PerfectTimeI t = (PerfectTimeI) Naming.lookup("//localhost/PerfectTime");
    DisplayPerfectTimeI dpt = new DisplayPerfectTime();

    for (int i = 0; i < 10; i++)
        System.out.println("Perfect time = " + t.getPerfectTime(dpt) + ".");
        
    System.out.println("\nFin del programa.");
    System.exit(0);
  }
}