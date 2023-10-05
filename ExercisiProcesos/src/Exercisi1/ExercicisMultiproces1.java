package Exercisi1;

public class ExercicisMultiproces1 {
    public static void main(String[] args) {
        ExercicisMultiproces1 EM = new ExercicisMultiproces1();
        System.out.println(EM.parellSenar(Integer.parseInt(args[0])));
    }

    String parellSenar(int nombre) {
        if (nombre % 2 == 0) {
            return "Parell";
        } else {
            return "Senar";
        }
    }
}
