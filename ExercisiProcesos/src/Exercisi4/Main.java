package Exercisi4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Introdueix el nom de l'arxiu: ");
            String nomArxiu = br.readLine();

            // Ejecutar el programa ExecutarDir para crear el archivo
            ProcessBuilder dirPB = new ProcessBuilder("java", "src/Exercisi4/ExecutarDir.java", nomArxiu);
            dirPB.inheritIO(); // Redirigir la salida estándar al proceso padre

            // Ejecutar ExecutarDir
            Process dirProcess = dirPB.start();
            int dirExitCode = dirProcess.waitFor();

            if (dirExitCode == 0) {
                System.out.println("ExecutarDir completat");

                // Ejecutar el programa ExecutarFind para buscar en el archivo
                ProcessBuilder trobardPB = new ProcessBuilder("java", "src/Exercisi4/ExecutarFind.java", nomArxiu);
                trobardPB.inheritIO(); // Redirigir la salida estándar al proceso padre

                Process trobardProcess = trobardPB.start();
                int trobardExitCode = trobardProcess.waitFor();

                if (trobardExitCode == 0) {
                    System.out.println("ExecutarFind completat");
                } else {
                    System.out.println("Error en l'execucció de ExecutarFind.");
                }
            } else {
                System.out.println("Error en l'execucció de ExecutarDir.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
