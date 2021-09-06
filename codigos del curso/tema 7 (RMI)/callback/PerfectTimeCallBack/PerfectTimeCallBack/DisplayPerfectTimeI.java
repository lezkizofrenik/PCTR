// Interfaz remoto DisplayPerfectTimeI

import java.rmi.*;

public interface DisplayPerfectTimeI extends Remote {
  void sendMessageCallBack(String str) throws RemoteException;
}