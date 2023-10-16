package Exercisi2;

import java.io.*;
import java.util.Scanner;

public class Ex3_Pare {
    public static void main(String[] args) {
        String missatge = "Hola";

        String[] command = {
                "java",
                "-jar",
                "out/artifacts/ExercisiProcesos_jar2/ExercisiProcesos.jar",
                String.valueOf((missatge))
        };

        System.out.println(getSon(command, missatge)); //L'hi envi la sortida per poder fer la
    }

    public static String getSon(String[] command, String value) {
        String read = "";

        try {
            Runtime r = Runtime.getRuntime();

            Process proces = r.exec(command);

            System.out.println("El pare diu: " + value);
        } catch (IOException ex) {
            System.err.println("Hay un problema por parte del padre a la hora de la comunicacion");
        }

        return read;
    }
}
