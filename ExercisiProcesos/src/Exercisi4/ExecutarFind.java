package Exercisi4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecutarFind
{
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.out.println("Has de proporcionar el nom de l'arxiu");
            return;
        }

        String nomArxiu = args[0];

        try
        {
            // Solicitar al usuario que introduzca un texto
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Introduexi un text: ");
            String texto = br.readLine();

            // Leer el contenido del archivo y buscar el texto
            BufferedReader fileReader = new BufferedReader(new FileReader(nomArxiu));
            String linea;
            while ((linea = fileReader.readLine()) != null) {
                if (linea.contains(texto)) {
                    System.out.println(linea);
                }
            }
            fileReader.close();

            System.out.println("Recerca completada");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
