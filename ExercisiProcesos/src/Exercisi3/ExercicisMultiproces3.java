package Exercisi3;

import java.io.*;

public class ExercicisMultiproces3 {
    public static void main(String[] args) {
        String missatge = "Hola";

        String[] command = {
                "java",
                "-jar",
                "out/artifacts/ExercisiProcesos_jar3/ExercisiProcesos.jar",
                String.valueOf(String.valueOf(missatge))
        };

        System.out.println(getSon(command, missatge)); //L'hi envi la sortida per poder fer la
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
                System.out.println("El pare diu: " + linea);
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
