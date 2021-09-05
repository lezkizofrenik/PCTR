/**
 * @(#)prodConControlado.java
 * @author A.T.
 * @version 1.00 2013/11/114
 * ESPECIFICACION: productor-consumidor controlado
 */
package septiembre.apialtonivel.semaforos;

import java.util.*;
import java.util.concurrent.*;

public class prodcon_campus extends Thread {
    private static int tamBuffer = 100;
    private static double[] buffer;
    private static int InPtr = 0;
    private static int OutPtr = 0;
    private static Semaphore em = new Semaphore(1);
    private static Semaphore espacios = new Semaphore(tamBuffer);
    private static Semaphore elementos = new Semaphore(0);

    private int tipoHilo;

    public prodcon_campus(int tipo) {
        tipoHilo = tipo;
    }

    public void run() {
        switch (tipoHilo) {
            case 0: {
                for (;;) {
                    try {
                        espacios.acquire();
                    } catch (InterruptedException e) {
                    }
                    try {
                        em.acquire();
                    } catch (InterruptedException e) {
                    }
                    buffer[InPtr] = Math.random();
                    System.out.println("Hilo productor insertando " + buffer[InPtr] + " en buffer");
                    InPtr = (InPtr + 1) % tamBuffer;
                    em.release();
                    elementos.release();
                }
            }
            case 1: {
                for (;;) {
                    try {
                        elementos.acquire();
                    } catch (InterruptedException e) {
                    }
                    try {
                        em.acquire();
                    } catch (InterruptedException e) {
                    }
                    System.out.println("Hilo consumidor extrayendo " + buffer[OutPtr] + " de buffer");
                    OutPtr = (OutPtr + 1) % tamBuffer;
                    em.release();
                    espacios.release();
                }
            }
        }
    }

    public static void main(String[] args) {
        buffer = new double[tamBuffer];
        new prodcon_campus(0).start();
        new prodcon_campus(1).start();
    }
}