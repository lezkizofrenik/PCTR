package septiembre.apialtonivel.semaforos;

import java.util.concurrent.Semaphore;

public class sincronizacion_turnociclico {
    private static int N =3;
    private static Semaphore [ ] s = new Semaphore [N]; 
    //private static int n;

    public sincronizacion_turnociclico(){
        for(int i = 0; i < N-1 ;i++){
            s[i] = new Semaphore(0);
        }
        s[N-1] = new Semaphore(1);
    }

    public static void metodo1(){
        try{
            
            s[0].acquire();

        }catch(InterruptedException e){}
        System.out.println("Metodo 1");
        s[1].release();
    }

    public static void metodo2(){
        try{
            s[1].acquire();
        }catch(InterruptedException e){}
        System.out.println("Metodo 2");
        s[2].release();
    }

    public static void metodo3(){
        try{
            s[2].acquire();
        }catch(InterruptedException e){}
        System.out.println("Metodo 3");
        s[0].release();
    }
}
