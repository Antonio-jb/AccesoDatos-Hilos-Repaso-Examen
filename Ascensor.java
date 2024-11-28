package EjerciciosRepasoExamen;

import java.util.LinkedList;

public class Ascensor {

    private LinkedList<Integer> lista = new LinkedList<Integer>();
    private final int CAPACIDAD = 5;

    public void setElementosLista(LinkedList<Integer> listaPrev){
        this.lista = listaPrev;
    }

    public void persona(int valor) throws InterruptedException {
        synchronized (this){
            while (lista.size() == CAPACIDAD) {
                wait();
            }
            this.lista.add(valor);
            System.out.println("Persona " + valor + " ha entrado en el ascensor.");
            notify();
        }
    }

    public void lleno(int valor2) throws InterruptedException {
        synchronized (this){
            if (lista.size() == CAPACIDAD) {
                System.out.println("\nHan entrado ya " + CAPACIDAD + " personas, ascensor lleno.\n");
                while (lista.size() > 0) {
                    int persona = this.lista.getFirst();
                    this.lista.removeFirst();
                    System.out.println("Persona " + persona + " ha salido del ascensor.");
                    Thread.sleep(1000);
                }

                notify();
                wait();
                System.out.println("\nSe ha vaciado ya el ascensor.");
                System.out.println("Esperando a que entren más personas para entrar.\n");
            }
            }
        }
    }


