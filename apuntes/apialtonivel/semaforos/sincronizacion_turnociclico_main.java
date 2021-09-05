package septiembre.apialtonivel.semaforos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class sincronizacion_turnociclico_main implements Runnable {

    private int turn;
    private static sincronizacion_turnociclico s = new sincronizacion_turnociclico();

    public sincronizacion_turnociclico_main(int turn) {
        this.turn = turn;
    }

    public void run() {
        for (;;) {
            switch (turn) {
                case 1:
                    s.metodo1();
                    break;
                case 2:
                    s.metodo2();
                    break;
                case 3:
                    s.metodo3();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(3);
        ex.execute(new sincronizacion_turnociclico_main(1));
        ex.execute(new sincronizacion_turnociclico_main(2));
        ex.execute(new sincronizacion_turnociclico_main(3));

    }
}
