package ejerciciosRefuerzoT2.ejercicio5;

public class Main {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(250, 800);
        Persona1 p1 = new Persona1("p1", cuenta);
        Persona2 p2 = new Persona2("p2", cuenta);

        p1.start();
        p2.start();
    }
}