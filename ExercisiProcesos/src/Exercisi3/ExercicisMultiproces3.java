package Exercisi3;

import java.io.*;

public class ExercicisMultiproces3 {
    public static void main(String[] args) {
        try {

            String msgPare = "El Pare diu: Hola";
            System.out.println(msgPare);

            ProcessBuilder reposta = new ProcessBuilder("java", "src/Exercisi3/ExercicisMultiproces3_Missatges.java", msgPare);
            reposta.inheritIO(); // Redirigir la salida estándar al proceso padre

            Process repostaProcess = reposta.start();
            int repostaExitCode = repostaProcess.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
