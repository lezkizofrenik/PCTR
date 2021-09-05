package septiembre.regionescriticas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class rc implements Runnable{
    private static Object lock = new Object();
    private static int n;
    private boolean type;

    public rc(boolean type){
        this.type = type;
    }

    public void run(){
        for(int i = 0; i < 10000; i++){
        synchronized(lock){
                if(type) n++;
                else n--;
                System.out.println(n + " " + Thread.currentThread().getName());
            }
        }
    }

    public static void main(String [] args){
        ExecutorService ex = Executors.newFixedThreadPool(2);
        ex.execute(new rc(true));
        ex.execute(new rc(false));

        ex.shutdown();
        try{
            ex.awaitTermination(5, TimeUnit.SECONDS);
        }catch(InterruptedException e ){

        }

        System.out.println(n);
    }
}
