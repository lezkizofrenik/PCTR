package septiembre.monitores;

public class monitorprueba extends Thread {
    private static monitor m = new monitor();
    private boolean type;

    monitorprueba(boolean type) {
        this.type = type;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (type)
                m.inc();
            else
                m.dec();
        }
    }

    public static void main(String[] args) {
        new monitorprueba(true).start();
        new monitorprueba(false).start();
    }
}
