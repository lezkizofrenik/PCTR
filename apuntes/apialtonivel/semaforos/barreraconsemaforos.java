package septiembre.apialtonivel.semaforos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class barreraconsemaforos implements Runnable {
    boolean tipo;
    private static Semaphore s1 = new Semaphore(0), s2 = new Semaphore(0);
    private static int a, b;
    barreraconsemaforos(boolean tipo) {
        this.tipo = tipo;
    }

    public void run() {
        if (tipo)
            tipo1();
        else
            tipo2();
    }

    public void tipo1() {
        a = 5;
        s1.release();
        try {
            s2.acquire();
        } catch (InterruptedException e) {

        }
    }

    public void tipo2() {
        b= 6;
        s2.release();
        try {
            s1.acquire();
        } catch (InterruptedException e) {
        }
        System.out.println(a + b);
    }

    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        ex.execute(new barreraconsemaforos(true));
        ex.execute(new barreraconsemaforos(false));

        ex.shutdown();
        try{
            ex.awaitTermination(5, TimeUnit.SECONDS);
        }catch(InterruptedException e){}
    }
}
