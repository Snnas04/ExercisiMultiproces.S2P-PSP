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

                ProcessBuilder reposta = new ProcessBuilder("java", "src/Exercisi1/ExercicisMultiproces1.java", numIntroduit);
                reposta.inheritIO(); // Redirigir la salida estándar al proceso padre

                Process repostaProcess = reposta.start();
                int direpostaExitCode = repostaProcess.waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
