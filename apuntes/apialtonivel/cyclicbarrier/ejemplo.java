package septiembre.apialtonivel.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ejemplo implements Runnable {
    private static int N = 5;
    private static CyclicBarrier c= new CyclicBarrier(N);

    public ejemplo(){
    }

    public void run(){
        try{
            System.out.println(Thread.currentThread().getName() + " bloqueado");
            c.await();
            System.out.println(Thread.currentThread().getName() + " desbloqueado");

        }catch(InterruptedException  e){}
            catch (BrokenBarrierException b){}
    }

    public static void main(String [] args){
        ExecutorService ex = Executors.newFixedThreadPool(N);
        for(int i = 0; i < 5; i++){
            ex.execute(new ejemplo());
        }

        ex.shutdown();
        try{
            ex.awaitTermination(5, TimeUnit.SECONDS);
        }catch(InterruptedException e){}
    }
}
