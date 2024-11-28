package EjerciciosRepasoExamen.EjerciciosRepasoExamen;

public class HiloMain1 {

    public static void main(String[] args) {
        Ejercicio1 recursoCompartido = new Ejercicio1();

        // Hilo productor
        Thread productor = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {

                    recursoCompartido.generarNumero();
                    Thread.sleep(1000); // Simula un pequeño retraso

                } catch (InterruptedException e) {
                    System.out.println("Error en el productor: " + e.getMessage());
                }
            }
        });

        // Hilo consumidor
        Thread consumidor = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {

                    recursoCompartido.consumirNumero();
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    System.out.println("Error en el consumidor: " + e.getMessage());
                }
            }
        });

        // Iniciar hilos
        productor.start();
        consumidor.start();
    }
}
