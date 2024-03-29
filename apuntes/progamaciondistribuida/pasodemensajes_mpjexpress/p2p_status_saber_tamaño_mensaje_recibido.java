package septiembre.progamaciondistribuida.pasodemensajes_mpjexpress;
import mpi.*;

public class p2p_status_saber_tamaño_mensaje_recibido {
    
public static void main(String args[]) throws Exception {
    MPI.Init(args);
    int rank = MPI.COMM_WORLD.Rank();
    int size = MPI.COMM_WORLD.Size();
    int emisor = 0; int receptor = 1;
    int tag = 100; int unitSize = 1;
    
    if(rank==emisor){ //codigo del emsior
         int bufer[] = new int[1];
         bufer[0] = 1200;
         MPI.COMM_WORLD.Send(bufer, 0, unitSize, MPI.INT, receptor, tag);
    } else{ //codigo del receptor
         int revbufer[] = new int[1];
         Status status = new Status();
         status=MPI.COMM_WORLD.Recv(revbufer, 0, unitSize, MPI.INT, emisor, tag);
         System.out.println("Receptor ha recibido el dato: "+revbufer[0]);
         System.out.println("Se han recibido "+status.Get_count(MPI.INT)+" datos");
      }
   
    MPI.Finalize();
    
    }
}
