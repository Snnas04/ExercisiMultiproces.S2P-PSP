package Exercisi4;

import java.io.*;

public class ExecutarDir
{
    public static void main(String[] args) throws InterruptedException
    {
        if (args.length != 1)
        {
            System.out.println("Debes proporcionar el nombre del archivo");
            return;
        }

        String nomArxiu = args[0];

        ProcessBuilder pb;
        try {
            FileWriter writer = new FileWriter(nomArxiu);

            // Obtener el directorio del escritorio del usuario
            String userDir = System.getProperty("user.home");
            String desktopDir = userDir + "/Desktop";

            pb = new ProcessBuilder("alacritty", "/home", "ls");
            pb.directory(new File(desktopDir)); // Establecer el directorio del escritorio como directorio de trabajo
            Process p = pb.start(); // Ejecutar el programa a través de un proceso hijo
            mostrarResultat(p, writer);
            System.out.println("Fitxer creat");
            p.destroy();
        } catch (IOException ex) {
            System.out.println("Error al ejecutar cmd");
        }
    }

    // Método para escribir en el archivo el resultado mediante el proceso hijo
    private static void mostrarResultat(Process p, FileWriter writer)
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String linea = null;

        try
        {
            while ((linea = in.readLine()) != null) {
                writer.write(linea + "\n"); // Escribir la línea en el archivo
            }
            in.close();
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }
}
