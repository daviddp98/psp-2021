package examen;

public class Consumidor extends Thread {
//profe:  private Cola cola;    ← FALTA
    private String mensaje;
    private SolicitaSuspender suspender = new SolicitaSuspender();
    private boolean parar;

    public Consumidor() {
        parar = false; //Aqui faltaba iniciar la variable booleana   // PROFE:  OK: bien, pero hay que explicar porqué.
        // PROFE:    cola = c;    ← FALTA
    }

    public void run() {
        while (!parar) {   // profe: NO EXPLICAS.
            mensaje = "Hola";   //  PROFE: noooo.   El método consumidor debe hacer operaciones de lectura de la cola.  ← FALTA cola=get();

            // Primer tipo de bloqueo:  pausa de 4 seg
            try {
                sleep(2000);
                suspender.esperandoParaReanudar();  // comprobar si hay que suspender el hilo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\t\t\t\t\t\t*****  Consumidor muerto  *****");
        parar = false;
    }

    public void pararHilo() {
        parar = true;
        System.out.println("Consumidor parado");
    }

    public void Suspende() {
        suspender.set(true);
    }

    public void Reanuda() {
        suspender.set(false);
    }
}