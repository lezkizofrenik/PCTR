package septiembre.apialtonivel.semaforos;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class emsem implements Runnable {
    boolean tipo;
    public static int i = 0;
    private static Semaphore s = new Semaphore(1);

    public emsem(boolean tipo) {
        this.tipo = tipo;
    }

    public void run() {
        while (true) {
            if (tipo)
                tipo1();
            else
                tipo2();
        }
    }

    public void tipo1() {
        try {
            s.acquire();
        } catch (InterruptedException e) {

        }
            i++;
            System.out.println(i + " " + Thread.currentThread().getName());
            s.release();
        
    }

    public void tipo2() {
        try {
            s.acquire();
        } catch (InterruptedException e) {
        }
            i--;
            System.out.println(i + " " + Thread.currentThread().getName());
            s.release();
      
    }

    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        ex.execute(new emsem(true));
        ex.execute(new emsem(false));

        ex.shutdown();
        try {
            ex.awaitTermination(6, TimeUnit.SECONDS);
        } catch (InterruptedException e) {

        }
    }
}
