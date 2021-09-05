package septiembre.monitores.regionescriticascondicionales_condicionesdeguarda;

public class semaforo_dijkstra {
    public static int s;

    public semaforo_dijkstra(int s) throws Exception{
        if(s < 0) throw new Exception();
        else this.s=s;
    }

    public synchronized void acquire(){
        if( s> 0){
            s--;
            System.out.println("Acquire " + s);
        }
        else{
            try{
                System.out.println("Acquire bloqueado " + s);
                wait();
            }catch(InterruptedException e){

            }
        }
    }

    public synchronized void release(){
        s++;
        notifyAll();
        System.out.println("Release " + s);
    }

    public synchronized void acquire(int i){
        if( s> 0) s-=i;
        else{
            try{
                wait();
            }catch(InterruptedException e){
                
            }
        }
    }

    public synchronized void release(int i){
        s += i;
        notifyAll();

    }
}
