package ejerciciosRefuerzoT2.ejercicio5;

public class Cuenta {
    int saldo, saldoMax;
    int turno = 1;
    boolean disponible = false;

    public Cuenta(int saldo, int saldoMax) {
        this.saldo = saldo;
        this.saldoMax = saldoMax;
        System.out.println("SALDO INICIAL: " + saldo + " => SALDO MAXIMO: " + saldoMax);
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldoMax() {
        return saldoMax;
    }

    public void setSaldoMax(int saldoMax) {
        this.saldoMax = saldoMax;
    }

    public synchronized void ingreso(int cantidad, String nombre) {
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        if (this.saldo + cantidad > this.saldoMax)
            System.out.println("ERROR /!\\ NO PUEDE INGRESAR " + cantidad + " POR QUE EL SALDO MAXIMO ES " + this.saldo);
        else {
            this.saldo = this.saldo + cantidad;
            System.out.println(nombre + " INGRESA " + cantidad + " => EL SALDO ACTUAL ES: " + this.saldo);
        }
        disponible = false;

        notifyAll();
    }

    public synchronized void reintegro(int cantidad, String nombre) {
        while (disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        disponible = true;
        if ((this.saldo - cantidad) < 0)
            System.out.println("ERROR /!\\ NO PUEDE SACAR " + cantidad + " POR QUE EL SALDO ACTUAL ES " + this.saldo);
        else {
            this.saldo = this.saldo - cantidad;
            System.out.println(nombre + " RETIRA " + cantidad + " => EL SALDO ACTUAL ES: " + this.saldo);
        }
        notifyAll();
    }
}