package Exercisi3;

public class ExercicisMultiproces3_Missatges {
    public static void main(String[] args) {
        ExercicisMultiproces3_Missatges EM = new ExercicisMultiproces3_Missatges();
        System.out.println(EM.enviarMS(String.valueOf(args[0])));
    }

    String enviarMS(String texto) {
        return "Fill: rep missatge del pare \"" + texto + "\"";
    }
}
