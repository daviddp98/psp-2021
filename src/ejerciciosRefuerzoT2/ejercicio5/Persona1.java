package ejerciciosRefuerzoT2.ejercicio5;

public class Persona1 extends Thread {
    Cuenta cuenta;
    String nombre;
    int cantidad;

    public Persona1(String nombre, Cuenta cuenta) {
        this.nombre = nombre.toUpperCase();
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 2; i++) {
                cuenta.ingreso((int) (Math.random() * 500 + 1), this.nombre);
                sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}