package EjerciciosRepasoExamen;

public class HiloMain2 {

    public static void main(String[] args) {
        Barrera barrera = new Barrera();

            Runnable llegar = () -> {
                String hiloNombre = Thread.currentThread().getName();

                try {
                    barrera.llegar(hiloNombre);
                } catch (InterruptedException e) {
                    System.out.println("Error: " + e);
                }
            };

            Thread barrera1 = new Thread(llegar, "Hilo 1");
            Thread barrera2 = new Thread(llegar, "Hilo 2");
            Thread barrera3 = new Thread(llegar, "Hilo 3");

        barrera1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }

        barrera2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }

        barrera3.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }

        barrera.lleno();

        }
    }
