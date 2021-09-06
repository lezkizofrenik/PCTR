// Implementación de la interfaz PerfectTimeI
// mediante la clase PerfectTime
// Utiliza el método remoto de la interfaz DisplayPerfectTimeI

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;

public class PerfectTime extends UnicastRemoteObject implements PerfectTimeI {

  int i = 0;

  public long getPerfectTime(DisplayPerfectTimeI p) throws RemoteException {
    long time = System.currentTimeMillis();
    p.sendMessageCallBack("Servicio " + ++i + " realizado.");
    return time;
  }

  public PerfectTime() throws RemoteException {
    super();
  }

  public static void main(String [] args) throws Exception {
    System.setSecurityManager(new RMISecurityManager()); // gestor de seguridad
    PerfectTime pt = new PerfectTime(); // se crea el objeto remoto
    Naming.rebind("PerfectTime", pt);  // se registra el objeto
    System.out.println("Servidor remoto de tiempo preparado.");
  }
}