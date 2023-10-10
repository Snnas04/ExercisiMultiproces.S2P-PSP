package Exercisi3;

import java.io.*;

public class Ex3_Fill {
    public static void main(String[] args) {
        Ex3_Fill EM = new Ex3_Fill();
        System.out.println(EM.xatProcessos(String.valueOf(args[0])));

        var missatge = "Hola padre";
        String[] command = {
                "java",
                "-jar",
                "out/artifacts/ExercisiProcesos_jar4/ExercisiProcesos.jar",
                String.valueOf(String.valueOf(missatge))
        };

        System.out.println(getFather(command, String.valueOf(missatge))); //L'hi envi la sortida per poder fer la
        // consulta
    }

    String xatProcessos(String texto) {
        return "Pare ha enviat: " + texto;
    }

    public static String getFather(String[] command, String value) {
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