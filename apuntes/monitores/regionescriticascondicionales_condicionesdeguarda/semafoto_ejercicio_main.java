package septiembre.monitores.regionescriticascondicionales_condicionesdeguarda;

public class semafoto_ejercicio_main implements Runnable {
    public static semaforo_ejercicio s = new semaforo_ejercicio(0); // Metodo 1 se bloquea
    public boolean type;

    public semafoto_ejercicio_main(boolean type) {
        this.type = type;
    }

    public void run() {
        for (;;) {
            if (type)
                s.metodo1();
            else
                s.metodo2();
        }
    }

    public static void main (String [] args){
        new Thread(new semafoto_ejercicio_main(true)).start();
        new Thread(new semafoto_ejercicio_main(false)).start();
    }

}
