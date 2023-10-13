package Exercisi3;

import java.io.*;

public class Ex3_Fill {
    public static void main(String[] args) {
        Ex3_Fill EM = new Ex3_Fill();
        System.out.println(EM.rebreMissatge(String.valueOf(args[0])));
    }

    String rebreMissatge(String texto) {
        return "Fill: rep missatge del pare " + texto;
    }
}
