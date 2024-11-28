package EjerciciosRepasoExamen;

import static java.lang.Thread.sleep;

public class Trabajadores {

    private boolean trabajadorLibre = false;

    public synchronized void esperarTrabajador(String trabajadorNombre) throws InterruptedException{
        while (trabajadorLibre == false) {
            System.out.println("El " + trabajadorNombre + " esta esperando para empezar a trabajar.");
            wait();
        }
        System.out.println("El " + trabajadorNombre + " ha empezado a trabajar.");

    }

    public synchronized void Empezar () {
        trabajadorLibre = true;
        System.out.println("\nYa esta todo listo para empezar a trabajar.\n");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
        notifyAll();
    }

}
