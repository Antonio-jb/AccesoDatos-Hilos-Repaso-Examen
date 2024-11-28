package EjerciciosRepasoExamen;

import static java.lang.Thread.sleep;

public class Barrera {

    private boolean barreraLlena = false;

        public synchronized void llegar (String hiloNombre) throws InterruptedException {

                while (barreraLlena == false) {
                    System.out.println("El " + hiloNombre + " ha llegado a la barrera.");
                    wait();
                }
                System.out.println("El " + hiloNombre + " ha entrado en la barrera.");
        }

                    public synchronized void lleno () {
                        barreraLlena = true;
                        System.out.println("\nYa han llegado todos a la barrera.\n");
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            System.out.println("Error: " + e);
                        }
                        notifyAll();
                    }
}


