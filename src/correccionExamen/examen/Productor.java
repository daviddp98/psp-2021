package examen;

import java.util.ArrayList;
import java.util.Arrays;

import static examen.Produc_Consum.cola;

public class Productor extends Thread {
//profe:  private Cola cola;   ← FALTA
    private boolean parar;
    ArrayList<String> fuente = new ArrayList(Arrays.asList("Mensaje1", "Mensaje2", "Mensaje3", "Mensaje4", "Mensaje5"));
    int i;   // índice para recorrer la fuente.
    int totalmensajes;   // PROFE:  FALTA fuente.size()
    private SolicitaSuspender suspender = new SolicitaSuspender();

    public Productor() {
        parar = false;
    }  // profe:   cola = c;    ← FALTA


    public void run() {
        while (!parar) {//&&  // PROFE:   && i<totalmensajes.   EL HILO DEBE PARAR CUANDO SE RECORRAN LOS 5 MENSAJES


            cola.put(fuente.get(i));

            // Primer tipo de bloqueo:  pausa de 2 seg
            try {
                sleep(2000);
                // Segundo tipo de bloque:  comprobar si hay que suspender el hilo
                suspender.esperandoParaReanudar();  // comprobar si hay que suspender el hilo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (i == totalmensajes) {
            System.out.println("\t\t\t\t*****  Escritos todos los mensajes. Productor muerto ************");
            parar = false;
        }
    }

    public void pararHilo() {
        System.out.println("Productor parado");
    } // profe:  parar = true;  ← FALTA


    public boolean isParar() {
        return parar;
    }

    public void Suspende() {
        System.out.println("Suspendiendo el hilo productor");
        suspender.set(true);
    }

    public void Reanuda() {
        System.out.println("Reanudando el hilo productor");
        suspender.set(false);
    }
}