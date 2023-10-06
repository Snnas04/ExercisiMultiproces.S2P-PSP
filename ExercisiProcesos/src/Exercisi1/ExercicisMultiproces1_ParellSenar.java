package Exercisi1;

import java.io.*;
import java.util.Scanner;

public class ExercicisMultiproces1_ParellSenar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            // L'usuari introdueix un valor
            System.out.println("Introduir un nombre enter o \"exit\" per sortir: ");
            String sortida = scan.nextLine();

            if (sortida.equals("exit")) {
                System.out.println("Adeu!");
                break;
            }

            String[] command = {
                    "java",
                    "-jar",
                    "out/artifacts/ExercisiProcesos_jar/ExercisiProcesos.jar",
                    Integer.toString(Integer.parseInt(sortida))
            };

            System.out.println(getSon(command, String.valueOf(scan))); //L'hi envi la sortida per poder fer la consulta

        }
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
                    System.out.println(linea);
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
