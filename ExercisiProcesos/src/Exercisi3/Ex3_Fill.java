package Exercisi2;

public class Ex3_Fill {
    public static void main(String[] args) {
        Ex3_Fill EM = new Ex3_Fill();
        System.out.println(EM.enviarMS(String.valueOf(args[0])));
    }

    String enviarMS(String texto) {
        return "El fill diu: " + texto;
    }
}
