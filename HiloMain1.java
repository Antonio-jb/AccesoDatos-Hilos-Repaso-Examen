package EjerciciosRepasoExamen;

import java.util.LinkedList;

public class HiloMain1 {

        public static void main(String[] args) {
            Ascensor ascensor = new Ascensor();
            LinkedList<Integer> lista = new LinkedList<Integer>();

            ascensor.setElementosLista(lista);

            Thread persona = new Thread(() -> {
                try {
                    int valor = 1;
                    while (true) {
                        ascensor.persona(valor);
                        valor ++;
                        Thread.sleep(1000);
                    }
                }catch (InterruptedException e){
                    System.out.println("error: " + e);
                }
            });

            Thread lleno = new Thread(() -> {
                try {
                    int valor2 = lista.size();
                    while (true) {
                        ascensor.lleno(valor2);
                    }
                }catch (InterruptedException e){
                    System.out.println("error: " + e);
                }
            });

            persona.start();
            lleno.start();
        }
    }

