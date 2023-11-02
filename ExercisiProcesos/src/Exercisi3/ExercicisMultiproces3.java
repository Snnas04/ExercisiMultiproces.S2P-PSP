package Exercisi3;

import java.io.*;

public class ExercicisMultiproces3 {
    public static void main(String[] args) {
        try {

            String numIntroduit = "El Pare diu: Hola";
            System.out.println(numIntroduit);

            // Ejecutar el programa ExecutarDir para crear el archivo
            ProcessBuilder dirPB = new ProcessBuilder("java", "src/Exercisi3/ExercicisMultiproces3_Missatges.java", numIntroduit);
            dirPB.inheritIO(); // Redirigir la salida estándar al proceso padre

            // Ejecutar ExecutarDir
            Process dirProcess = dirPB.start();
            int dirExitCode = dirProcess.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
