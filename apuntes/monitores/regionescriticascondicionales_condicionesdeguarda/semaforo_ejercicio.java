package septiembre.monitores.regionescriticascondicionales_condicionesdeguarda;

public class semaforo_ejercicio {
    public static int i;
    public static boolean access = false;
    public semaforo_ejercicio(int i){
        this.i = i;
    }

    //Metodo1 depende de la ejecucion de metodo2
    public synchronized void metodo1(){
        while(i == 0 || access==true){
            try{
                System.out.println("Bloqueado metodo1");
                wait();
            }catch(InterruptedException e){}
        }
        i--;
        System.out.println("Metodo 1, i=" + i);
        access = false;
        notifyAll();
    }

    public synchronized void metodo2(){
        while(i == 500 || access==true){
            try{
                System.out.println("Bloqueado metodo2");

                wait();
            }catch(InterruptedException e){

            }
        }
        
        i++;
        System.out.println("Metodo 2, i=" + i);
        access=false;
        notifyAll();
    }
}
