package examen;

import java.util.Scanner;

public class Produc_Consum {
    static Cola cola = new Cola();
    // profe: hay que compartir la cola entre los hilos que acceden a ella:
   /* static Productor p = new Productor(cola);  ← FALTA cola
    static Consumidor c = new Consumidor(cola);   ← FALTA cola*/


    static Productor p = new Productor();
    static Consumidor c = new Consumidor();

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        Produc_Consum pc = new Produc_Consum();

        while (!salir) {
            mostrarMenu();
            System.out.println("Escribe una de las opciones: ");
            opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado INICIAR: ");
                    iniciarmodelo();
                    break;
                case 2:
                    System.out.println("Has seleccionado PARAR: ");
                    pararmodelo();
                    break;
                case 3:
                    System.out.println("Has seleccionado SUSPENDER: ");
                    suspendermodelo();
                    break;
                case 4:
                    System.out.println("Has seleccionado REANUDAR: ");
                    reanudarmodelo();
                    break;
                case 5:
                    System.out.println("Has seleccionado SALIR: ");
                    salir = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 5");
            }
        }
        System.out.println("fin del programa");
        pararmodelo();   // nos aseguramos de no dejar ningún hilo funcionando
    }

    private static void mostrarMenu() {
        System.out.println("***********************************************************");
        System.out.println("*****************   Gestor de hilos  **********************");
        System.out.println("***********************************************************");

        System.out.println("1. Iniciar el modelo productor-consumidor");
        System.out.println("2. Parar el modelo productor-consumidor");
        System.out.println("3. Suspender el modelo productor-consumidor");
        System.out.println("4. Reanudar el modelo productor-consumidor");
        System.out.println("5. Salir");
    }

    private static void iniciarmodelo() {
        if (!p.isAlive()) {
            p.start(); //Aqui faltaba iniciar el hilo del productor
            // PROFE: y también crear el hilo
            // profe:   p = new Productor(cola);  ← FALTA
        }
        if (!c.isAlive()) {  //PROFE: no explicas el cambio que has realizado.
            //profe: falta también crear el hilo
            //        c = new Consumidor(cola);   ← FALTA
            c.start();
        }
    }

    private static void pararmodelo() {
        if (p.isAlive())
            p.pararHilo();
        if (c.isAlive())
            c.pararHilo();
    }

    private static void suspendermodelo() {
        if (p.isAlive())
            p.Suspende();
        if (c.isAlive())
            c.Suspende();
    }

    private static void reanudarmodelo() {
        if (p.getState().toString() == "WAITING")
            p.Reanuda();
        if (c.getState().toString() == "WAITING")
            c.Reanuda();
    }
}