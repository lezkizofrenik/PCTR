package septiembre.monitores.regionescriticascondicionales_condicionesdeguarda;

// Aka condiciones de guarda

public class rccondicional_monitor {
    public static int turno;

    public rccondicional_monitor(int turno){
        this.turno = turno;
    }

    public synchronized void metodo1(){
        while(turno!=1){
            try{
                wait();
            }catch(InterruptedException e){}
        }
        System.out.println("Metodo 1, turno " + turno);
        turno++;
        notifyAll();
    }

    public synchronized void metodo2(){
        while(turno!=2){
            try{
                wait();
            }catch(InterruptedException e){}
        }
        System.out.println("Metodo 2, turno " + turno);
        turno++;
        notifyAll();
    }

    public synchronized void metodo3(){
        while(turno!=3){
            try{
                wait();
            }catch(InterruptedException e){}
        }
        System.out.println("Metodo 3, turno " + turno);
        turno=1;
        notifyAll();
    }

}
