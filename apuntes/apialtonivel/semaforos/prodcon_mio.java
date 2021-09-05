package septiembre.apialtonivel.semaforos;

import java.util.*;
import java.util.concurrent.*;

public class prodcon_mio extends Thread {
    private static int tam = 5;
    private static int[] buffer;
    private int in = 0, out = 0;
    private boolean tipo;
    private static Semaphore em = new Semaphore(1), elements = new Semaphore(0), space = new Semaphore(tam);

    public prodcon_mio(boolean tipo) {
        this.tipo = tipo;
    }

    public void print() {
        System.out.print("[");

        for (int i = 0; i < tam; i++) {
            System.out.print(buffer[i] + ", ");
        }
        System.out.print("]");

    }

    public void run() {
        if (tipo)
            productor();
        else
            consumidor();

    }

    public void productor() {
        for (;;) {
            try {
                space.acquire(); // Hay spacio suficiente para producir?
                em.acquire(); // Esta el proceso consumidor funcionando?
            } catch (InterruptedException e) {

            }

            buffer[in] = (int) (100*Math.random());
            System.out.println("Productor");
            print();
            in = (in + 1) % tam;
            em.release(); // Producción acabada
            elements.release(); // Se ha producido un elemento
        }
    }

    public void consumidor() {
        for (;;) {

            try {
                elements.acquire(); // Se puede consumir un elemento?
                em.acquire(); // Esta el proceso productor funcionando?
            } catch (InterruptedException e) {

            }
            buffer[out] = -1;
            System.out.println("Consumidor");
            print();
            out = (out + 1) % tam;
            em.release(); // Se ha terminado la consumición
            space.release(); // Se libera un hueco
        }
    }

    public static void main(String[] args) {
        buffer = new int[tam];
        new prodcon_mio(false).start();
        new prodcon_mio(true).start();
    }
}
