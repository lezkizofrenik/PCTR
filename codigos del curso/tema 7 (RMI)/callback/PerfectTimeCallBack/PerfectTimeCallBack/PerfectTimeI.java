// Interfaz remoto PerfectTimeI

import java.rmi.*;

public interface PerfectTimeI extends Remote {
  long getPerfectTime(DisplayPerfectTimeI dpt) throws RemoteException;
}