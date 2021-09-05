package septiembre.progamaciondistribuida.pasodemensajes_mpjexpress;
import mpi.*;

public static void main(String args[]) throws Exception {
    MPI.Init(args);
    int rank = MPI.COMM_WORLD.Rank();
    int size = MPI.COMM_WORLD.Size();
    int emisor = 0; int receptor = 1;
    int tag = 100; int unitSize = 1;
    
    if(rank==emisor){ //codigo del emsior
         int bufer[] = new int[unitSize];
         bufer[0] = 1200;
         //buffer, offset, tamaño, tipo, receptor, tag
         MPI.COMM_WORLD.Send(bufer, 0, unitSize, MPI.INT, receptor, tag);
    } else{ //codigo del receptor
         int revbufer[] = new int[unitSize];
         //buffer, offset, tamaño, tipo, emisor, tag

         MPI.COMM_WORLD.Recv(revbufer, 0, unitSize, MPI.INT, emisor, tag);
         System.out.println("Receptor ha recibido el dato: "+revbufer[0]);
      }
   
    MPI.Finalize();
    
    }
   }