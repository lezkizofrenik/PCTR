package septiembre.progamaciondistribuida.Tiempo Real;

public class resumen {
    //Hilo que se activa de forma regular cada milisegundo
    RealTimeThread htr = new RealTimeThread();
    RelativeTime miliseg = new RelativeTime(1,0); 
    ReleaseParameters relpar  = new Periodic Parameters(miliseg);
    htr.setReleaseParameters(relpar);

    // Ajuste de prioridad
    RealTimeThread htr2 = new RealTimeThread();
    int maxPri = PriorityScheduler.instance().getMaxPriority();
    PriorityParameters pri = new PriorityParameters(maxPri);
    htr2.setSchedulingParameters(pri);

    // Ajuste de prioridad e importancia (ajuste mas fino de la prioridad)
    // RTJS utiliza como criterio de planificación único el Gold Standard, el cual define 28 niveles de prioridad
    // Si 2 hilos tienen la misma prioridad, se desempata por la importancia (la mayor)
    RealTimeThread htr3 = new RealTimeThread();
    ImportanceParameters ip1 = new ImportanceParameters(maxPri, 1);
    htr3.setSchedulingParameters(ip1);

    RealTimeThread htr4 = new RealTimeThread();
    ImportanceParameters ip2 = new ImportanceParameters(maxPri, 2);
    htr4.setSchedulingParameters(ip2);

    //Se incrementa la impoortancia de htr3 sobre htr4
    htr3.setImportance(3);
}
