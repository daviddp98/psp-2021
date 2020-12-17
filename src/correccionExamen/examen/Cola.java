package examen;

public class Cola {
    private String mensaje;

    private boolean disponible = false;

    public synchronized String get() {
        while (!disponible) { //Aqui falta la variable booleana  PROFE: ¿Por qué? No explicas.
            try {
                wait();  // PROFE: no indicas que es otro cambio ni explicas porqué.
            } catch (InterruptedException e) {
            }
        }
        disponible = false;
        System.out.println("\t\t\t\t\t\tRecuperado " + mensaje + " de la cola");
        // PROFE: notifyAll();    ← FALTA

        return mensaje;
    }

    public synchronized void put(String mensaje) { //Aqui he añadido el synchronized    PROFE: ¿Por qué? No explicas.
        while (disponible == true) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.mensaje = mensaje;
        System.out.println("\t\t\t\tEscrito " + mensaje + " en la cola");
        disponible = true;

        notifyAll();
    }
}