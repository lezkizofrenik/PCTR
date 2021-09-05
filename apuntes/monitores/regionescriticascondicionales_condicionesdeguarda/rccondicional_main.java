package septiembre.monitores.regionescriticascondicionales_condicionesdeguarda;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class rccondicional_main implements Runnable {
    private static rccondicional_monitor m = new rccondicional_monitor(2);
    private int type;

    public rccondicional_main(int type) {
        this.type = type;
    }

    public void run() {
        for (;;) {
            switch (type) {
                case 1:
                    m.metodo1();
                    break;
                case 2:
                    m.metodo2();
                    break;
                case 3:
                    m.metodo3();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 3; i++) {
            ex.execute(new rccondicional_main(i));
        }

    }

}
