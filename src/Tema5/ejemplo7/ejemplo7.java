package Tema5.ejemplo7;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class ejemplo7 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyGen =
                    KeyPairGenerator.getInstance("DSA");

            //SE INICIALIZA EL GENERADOR DE CLAVES
            SecureRandom numero = SecureRandom.getInstance("SHA1PRNG");
            keyGen.initialize(2048, numero);

            //SE CREA EL PAR DE CLAVES PRIVADA Y PÚBLICA
            KeyPair par = keyGen.generateKeyPair();
            PrivateKey clavepriv = par.getPrivate();
            PublicKey clavepub = par.getPublic();

            //ACTIVIDAD 5.2
            PKCS8EncodedKeySpec pkcs8SpecPriv= new PKCS8EncodedKeySpec(clavepriv.getEncoded());
            X509EncodedKeySpec pkX509Publ= new X509EncodedKeySpec(clavepub.getEncoded());

            //Escribir a fichero binario las claves
            FileOutputStream outPriv= new FileOutputStream("Clave.privada");
            outPriv.write(pkcs8SpecPriv.getEncoded());
            outPriv.close();

            FileOutputStream outPub= new FileOutputStream("Clave.publica");
            outPub.write(pkX509Publ.getEncoded());
            outPub.close();
            //FIN ACTIVIDAD 5.2


            //FIRMA CON CLAVE PRIVADA EL MENSAJE
            //AL OBJETO Signature SE LE SUMINISTRAN LOS DATOS A FIRMAR
            Signature dsa = Signature.getInstance("SHA256withDSA");
            dsa.initSign(clavepriv);
            String mensaje = "Este mensaje va a ser firmado";
            dsa.update(mensaje.getBytes());

            byte[] firma = dsa.sign(); //MENSAJE FIRMADO

            //EL RECEPTOR DEL MENSAJE
            //VERIFICA CON LA CLAVE PÚBLICA EL MENSAJE FIRMADO
            //AL OBJETO Signature SE LE SUMINIST. LOS DATOS A VERIFICAR
            Signature verificadsa =
                    Signature.getInstance("SHA256withDSA");
            verificadsa.initVerify(clavepub);
            verificadsa.update(mensaje.getBytes());
            boolean check = verificadsa.verify(firma);

            if (check)
                System.out.println("FIRMA VERIFICADA CON CLAVE PÚBLICA");
            else System.out.println("FIRMA NO VERIFICADA");

        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//main
}//..Ejemplo7