package EjerciciosRepasoExamen.EjerciciosRepasoExamen;

public class Ejercicio1 {

    private Integer numeroCompartido = null;
    private boolean disponible = false;

    // Método del productor
    public synchronized void generarNumero() throws InterruptedException {

            while (this.disponible) {
                wait(); // Espera a que el consumidor lea el número
            }
            numeroCompartido = (int) (Math.random() * 100); // Genera un número aleatorio
            System.out.println("Se ha generado un número.");
            this.disponible = true; // Marca que el número ha sido generado y está disponible para ser consumido.
            notify(); // Notifica al consumidor

    }

    // Método del consumidor
    public synchronized void consumirNumero() throws InterruptedException {

            while (!this.disponible) {
                wait(); // Espera a que el productor genere un número
            }
            System.out.println("El número generado es: " + numeroCompartido);
            this.disponible=false;
            notify(); // Notifica al productor

    }
}
