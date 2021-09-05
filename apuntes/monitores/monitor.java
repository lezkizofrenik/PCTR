package septiembre.monitores;

public class monitor {
    public static int n = 0;

    public monitor(){

    }

    public synchronized void inc(){
        n++;
        System.out.println(n + " " + Thread.currentThread().getName());
    }

    public synchronized void dec(){
        n--;
        System.out.println(n + " " + Thread.currentThread().getName());

    }

    public synchronized int get(){
        return n;
    }

}
