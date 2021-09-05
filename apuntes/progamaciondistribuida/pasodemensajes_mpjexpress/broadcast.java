package septiembre.progamaciondistribuida.pasodemensajes_mpjexpress;

public class broadcast {
    //Envia un dato dsede un proceso a los demas
    public static void main(String args[]) throws Exception {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        int emisor = 0;
        int[] data = new int[10];

        if (rank == emisor) {
            Random input = new Random();
            System.out.println("Generando enteros...");
            for (int i = 0; i < 10; i++)
                data[i] = input.nextInt();
        }
        // El metodo Bcast debe llamarse desde el emisor y desde los receptores
        // El ultimo parametro es el emisor
        // Lo mismo pero sin receptor y sin tag
        MPI.COMM_WORLD.Bcast(data, 0, 10, MPI.INT, 0);

        if (rank != emisor) {
            System.out.println("vector recibido...");
            for (int i = 0; i < 10; i++)
                System.out.print(data[i] + " ");
        }
        MPI.Finalize();
    }
}