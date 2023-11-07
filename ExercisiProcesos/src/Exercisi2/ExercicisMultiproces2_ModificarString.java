package Exercisi2;

import java.io.*;
import java.util.Scanner;

public class ExercicisMultiproces2_ModificarString {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Introduir un texte, per sustituir les vocals o \"exit\" per sortir: \n");
            String texteIntroduit = br.readLine();
            
            ProcessBuilder reposta = new ProcessBuilder("java", "src/Exercisi2/ExercicisMultiproces2.java", texteIntroduit);
            reposta.inheritIO(); // Redirigir la salida estándar al proceso padre

            Process repostaProcess = reposta.start();
            int repostaExitCode = repostaProcess.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
