package ejerciciosRefuerzoT2.ejercicio4;

public class Persona extends Thread {
    Cuenta cuenta;
    String nombre;

    public Persona(String nombre, Cuenta cuenta) {
        this.nombre = nombre.toUpperCase();
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                cuenta.ingreso((int) (Math.random() * 500 + 1), this.nombre);
                sleep(1000);
                cuenta.reintegro((int) (Math.random() * 500 + 1), this.nombre);
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}