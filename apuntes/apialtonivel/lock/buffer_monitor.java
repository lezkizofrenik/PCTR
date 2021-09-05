package septiembre.apialtonivel.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class buffer_monitor {
    public static int N = 100;
    public static int[] array;
    public static int in = 0, out = 0, cont = 0;
    public Lock l = new ReentrantLock();
    final Condition lleno = l.newCondition(), vacio = l.newCondition();

    public void insert(int a) throws InterruptedException {
        l.lock();
        try {
            while (cont == N)
                lleno.await();
            array[in] = a;
            in = (in+1)%N;
            cont++;
            vacio.signal(); //avisa que ya se puede consumir
        } finally {
            l.unlock();
        }
    }


    public int get() throws InterruptedException{
        l.lock();
        try{
            while(cont == 0)
                vacio.await();
        int res = array[out];
        cont--;
        lleno.signal(); //avisa que ya hay espacio
        out=(out+1)%N;
        return res; // Se puede hacer lol
        } finally{
            l.unlock();
        }
    }
}
