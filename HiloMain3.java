package EjerciciosRepasoExamen;

public class HiloMain3 {

    public static void main(String[] args) {
        Trabajadores trabajadores = new Trabajadores();

        Runnable esperarTrabajador = () -> {

            String trabajadorNombre = Thread.currentThread().getName();
            try {
                trabajadores.esperarTrabajador(trabajadorNombre);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        };

        Thread trabajador1 = new Thread(esperarTrabajador, "Trabajador 1");
        Thread trabajador2 = new Thread(esperarTrabajador, "Trabajador 2");
        Thread trabajador3 = new Thread(esperarTrabajador, "Trabajador 3");

        trabajador1.start();

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }

        trabajador2.start();

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }

        trabajador3.start();

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }

        trabajadores.Empezar();

    }
}
