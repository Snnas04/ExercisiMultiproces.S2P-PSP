package Exercisi2;

import java.io.*;
import java.util.Scanner;

public class ExercicisMultiproces2_ModificarString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // L'usuari introdueix un valor
        System.out.println("Introduir un texte: ");
        String sortida = scan.nextLine();

        String[] command = {
                "java",
                "-jar",
                "out/artifacts/ExercisiProcesos_jar2/ExercisiProcesos.jar",
                String.valueOf(String.valueOf(sortida))
        };

        System.out.println(getSon(command, String.valueOf(scan))); //L'hi envi la sortida per poder fer la
        // consulta

        scan.close(); // Tanc el sacanner ya que emplei un scanner global per tot, i aixi al moment de tancar també tanc el scanner
    }

    public static String getSon(String[] command, String value) {
        String read = "";

        try {
            Runtime r = Runtime.getRuntime();

            Process proces = r.exec(command);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(proces.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(proces.getInputStream()));

            out.write(value);
            out.close();
            String linea = null;
            try{
                while((linea = in.readLine()) != null)
                {
                    System.out.println("El pare diu: " + linea);
                }
                in.close();
            }catch(IOException ex){
                System.out.println("Error al mostrar el proces fill");
            }
        } catch (IOException ex) {
            System.err.println("Hay un problema por parte del padre a la hora de la comunicacion");
        }

        return read;
    }
}
