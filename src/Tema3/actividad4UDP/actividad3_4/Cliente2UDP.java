package Tema3.actividad4UDP.actividad3_4;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.util.Scanner;

public class Cliente2UDP {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        DatagramSocket clientSocket = new DatagramSocket(); //Socket del cliente

        //DATOS DEL SERVIDOR AL QUE ENVIAR MENSAJE
        InetAddress IPServidor = InetAddress.getLocalHost(); //Localhost
        int puerto = 12345; //puerto por el que escucha

        System.out.print("Introduce mensaje: ");
        String cadena = sc.nextLine();

        byte[] enviados = new byte[1024];
        enviados = cadena.getBytes();

        // ENVIANDO DATAGRAMA AL SERVIDOR
        DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
        clientSocket.send(envio);

        // RECIBIENDO DATAGRAMA DEL SERVIDOR
        byte[] recibidos = new byte[2];
        DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
        System.out.println("Esperando datagrama...");
        clientSocket.setSoTimeout(5000);
        clientSocket.receive(recibo);

        // Obtener el número e caracteres
        byte[] hh = recibo.getData();
        int numero = hh[0];

        System.out.println("Recibo Nº de caracteres que son a=> " + numero);

        clientSocket.close();// cerrar socket
    }
}