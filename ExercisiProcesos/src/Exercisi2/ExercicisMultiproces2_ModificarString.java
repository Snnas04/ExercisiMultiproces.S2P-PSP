package Exercisi2;

import java.io.*;
import java.util.Scanner;

public class ExercicisMultiproces2_ModificarString {
    public static void main(String[] args) {
        try {
            while (true) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Introduir un texte, per sustituir les vocals o \"exit\" per sortir: \n");
                String numIntroduit = br.readLine();

                if (numIntroduit.equals("exit")) {
                    System.out.println("Adeu!");
                    break;
                }

                // Ejecutar el programa ExecutarDir para crear el archivo
                ProcessBuilder dirPB = new ProcessBuilder("java", "src/Exercisi2/ExercicisMultiproces2.java", numIntroduit);
                dirPB.inheritIO(); // Redirigir la salida estándar al proceso padre

                // Ejecutar ExecutarDir
                Process dirProcess = dirPB.start();
                int dirExitCode = dirProcess.waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
