package septiembre.monitores.regionescriticascondicionales_condicionesdeguarda;

public class prodcon_conguarda {
    private static int N = 10;
    private static int [] array = new int [N];
    private static int in = 0, out = 0, n = 0;
    private static boolean turno = false;

    public synchronized void producir(){
        while(n == N /*|| turno==true*/){
            try{
                wait();
            }catch(InterruptedException e){}
            array[in] = (int)(Math.random()*100);
            System.out.println("Producir, Array["+in+"]= " + array[in]);
            n++;
            in = (in + 1)%N;
            //turno = true; -> implica alternancia
            notifyAll();
        }
    }

    public synchronized void consumir(){
        while(/*turno == false ||*/ n == 0){
            try{
                wait();
            }catch(InterruptedException e){

            }

        }

        array[out] = -1;
        n--;
        System.out.println("Consumir, array[" + out+"]= " + array[out]);
        out = (out + 1)%N;
        //turno= false;
        notifyAll();

    }
}
