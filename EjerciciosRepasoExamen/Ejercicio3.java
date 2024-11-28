package EjerciciosRepasoExamen.EjerciciosRepasoExamen;

public class Ejercicio3 {

    private boolean turnoPing = false;

    // Método del productor
    public synchronized void generarPing() throws InterruptedException {

            while (this.turnoPing) {
                wait();
            }

            System.out.println("Ping");
            this.turnoPing = true;
            notify(); // Notifica al pong.

    }

    // Método del consumidor
    public synchronized void generarPong() throws InterruptedException {

            while (!this.turnoPing) {
                wait();
            }
            System.out.println("Pong");
            this.turnoPing =false;
            notify(); // Notifica al ping.

    }
}
