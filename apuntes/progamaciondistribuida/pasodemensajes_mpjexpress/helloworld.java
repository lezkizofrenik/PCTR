package septiembre.progamaciondistribuida.pasodemensajes_mpjexpress;

import mpi.*;

public class helloworld {
    public static void main(String[] args){
        MPI.Init(args);
        int me = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        System.out.println("Hola desde el proceso <" + me + ">");
        MPI.Finalize();
    }
}
