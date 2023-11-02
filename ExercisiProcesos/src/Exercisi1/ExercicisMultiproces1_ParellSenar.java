package Exercisi1;

import java.io.*;
import java.util.Scanner;

public class ExercicisMultiproces1_ParellSenar {
    public static void main(String[] args) {
        try {
            while (true) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Introduir un nombre enter o \"exit\" per sortir: \n");
                String numIntroduit = br.readLine();

                if (numIntroduit.equals("exit")) {
                    System.out.println("Adeu!");
                    break;
                }

                // Ejecutar el programa ExecutarDir para crear el archivo
                ProcessBuilder dirPB = new ProcessBuilder("java", "src/Exercisi1/ExercicisMultiproces1.java", numIntroduit);
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
