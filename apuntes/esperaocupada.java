package septiembre;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class esperaocupada implements Runnable {

    public static int variable = 0;
    public boolean tipo;
    public static boolean turno = false;

    public esperaocupada(boolean tipo) {
        this.tipo = tipo;
    }

    // turno = false -> tipo1
    // turno = true - > tipo2
    public void tipo1() {
        while (turno) {
        }
        variable++;
        System.out.println(variable + " " + Thread.currentThread().getName());
        turno = true;
    }

    public void tipo2() {
        
        while (!turno) {
        }
        variable--;
        System.out.println(variable + " " + Thread.currentThread().getName());
        turno = false;
    }

    public void run() {
        while(true){
            if (tipo)
                tipo1();
            else
                tipo2();
        }
    }

    public static void main(String[] args) {
        int nHebras = 2;
        ExecutorService ex = Executors.newFixedThreadPool(nHebras);

        ex.execute(new esperaocupada(true));
        ex.execute(new esperaocupada(false));

        ex.shutdown();
        try {
            ex.awaitTermination(6, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }

    }
}