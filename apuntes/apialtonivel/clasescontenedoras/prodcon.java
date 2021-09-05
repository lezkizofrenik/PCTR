package septiembre.apialtonivel.clasescontenedoras;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class prodcon extends Thread {
    private static LinkedBlockingQueue<Integer> q = new LinkedBlockingQueue<>();
    private boolean type;

    public prodcon(boolean type){
        this.type =type;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            if(type){
                try {
                    Integer a = new Integer(i);
                    q.put(a);
                    System.out.println("Insertado " +a + " " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                }
            }
            else{
                try{
                    System.out.println("Extraido " + q.take().intValue() + " " + Thread.currentThread().getName());
                }catch(InterruptedException e){

                }
            }
        }
    }

    public static void main(String [] args){
        new prodcon(true).start();
        new prodcon(false).start();
    }
}
