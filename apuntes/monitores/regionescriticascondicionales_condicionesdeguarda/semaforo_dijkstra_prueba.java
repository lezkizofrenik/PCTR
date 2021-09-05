package septiembre.monitores.regionescriticascondicionales_condicionesdeguarda;

public class semaforo_dijkstra_prueba implements Runnable {
    private static semaforo_dijkstra s;
    private boolean type;
    private static int n = 0;

    public semaforo_dijkstra_prueba(boolean type) {
        this.type = type;
    }

    public void run() {
        if (type) {
            for (;;) {
                metodo1();
            }
        } else {
            for (int i = 0; i < 5; i++)
                metodo2();
        }
    }

    public void metodo1() {
        s.acquire();
        n++;
        System.out.println("Metodo 1 " + n);
    }

    public void metodo2() {
        s.release();
    }

    public static void main(String[] args) {
        try {
            s = new semaforo_dijkstra(0);
        } catch (Exception e) {
        }

        Thread t1 = new Thread(new semaforo_dijkstra_prueba(true));
        Thread t2 = new Thread(new semaforo_dijkstra_prueba(false));

        t1.start();
        t2.start();
        try {
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
        }
    }
}
