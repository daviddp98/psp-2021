package ejerciciosRefuerzoT2.ejercicio4;

public class Main {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(250, 800);
        Persona p1 = new Persona("p1", cuenta);
        Persona p2 = new Persona("p2", cuenta);
        Persona p3 = new Persona("p3", cuenta);

        p1.start();
        p2.start();
        p3.start();
    }
}