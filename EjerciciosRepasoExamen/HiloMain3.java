package EjerciciosRepasoExamen.EjerciciosRepasoExamen;

public class HiloMain3 {

    public static void main(String[] args) {
        Ejercicio3 recursoCompartido = new Ejercicio3();

        // Hilo ping
        Thread ping = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {

                    recursoCompartido.generarPing();
                    Thread.sleep(1000); // Simula un pequeño retraso

                } catch (InterruptedException e) {
                    System.out.println("Error en el ping: " + e.getMessage());
                }
            }
        });

        // Hilo pong
        Thread pong = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {

                    recursoCompartido.generarPong();
                    Thread.sleep(1200);

                } catch (InterruptedException e) {
                    System.out.println("Error en el pong: " + e.getMessage());
                }
            }
        });

        // Iniciar hilos
        ping.start();
        pong.start();
    }
}
