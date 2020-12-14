package ejerciciosRefuerzoT2.suspenderHilos;

/*
 * SUSPENDER HILOS
Crear un hilo (extensd Thread) que pinte el valor
de un contador en un bucle
controlado por una variable que finalice el bucle.
Dentro del bucle ademas de pintar el valor del contador,
 poneis a dormir (sleep() para ver los numeros)el hilo
  y llamais al método que comprueba si el hilo está
   suspendido o no.

AL FINALIZAR EL bucle VISUALIZAR MENSAJE de fin de hilo

En main INTRODUCIR CADENAS POR TECLADO HASTA
ESCRIBIR UN *
si la cadena es S suspender el hilo
si la cadena es R reanudar el hilo
El hilo no se lanzará despues de introducir la cadena
por teclado, solo una vez...
AL FINALIZAR EL BUCLE  VISUALIZAR VALOR DEL CONTADOR
debe finalizar el hilo
*/

import java.util.Scanner;

class MyHilo_actividad2_4 extends Thread {
    private SolicitaSuspender suspender = new SolicitaSuspender();
    private boolean stopHilo = false;
    private int c = 0;

    public void pararHilo() {
        stopHilo = true;
    }

    int getContador() {
        return c;
    }

    public void Suspende() {
        suspender.set(true);
    }

    public void Reanuda() {
        suspender.set(false);
    }

    public void run() {
        try {
            while (!stopHilo) {
                c++;
                System.out.print(" " + c + " ");
                //sleep(200);
                suspender.esperandoParaReanudar();
                sleep(200);
            }
            System.out.println("Fin del hilo.");

        } catch (InterruptedException exception) {
        }
    }
}// HILO

class SolicitaSuspender {
    private boolean solicitaSuspender;

    public synchronized void set(boolean b) {
        solicitaSuspender = b;
        notifyAll();
    }

    public synchronized void esperandoParaReanudar() throws InterruptedException {
        while (solicitaSuspender) {
            wait();
        }
    }
}// SolicitaSuspender

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyHilo_actividad2_4 hilo = new MyHilo_actividad2_4();

        String cad;
        while (true) {
            System.out.print("\tIntroduce CADENA: ");
            cad = sc.nextLine();

            if (!hilo.isAlive()) {
                System.out.println("Lanzando hilo...");
                hilo.start();
            }
            if (cad.equals("*"))
                break;
            if (cad.equals("S")) // SUSPENDER HILO
                hilo.Suspende();

            if (cad.equals("R")) // REANUDAR HILO
                hilo.Reanuda();
        }

        // REANUDAMOS EL HILO POR SI ESTÁ SUSPENDIDO
        hilo.Reanuda();
        System.out.println(" Contador:" + hilo.getContador());
        hilo.pararHilo();
    }
}//actividad2_4