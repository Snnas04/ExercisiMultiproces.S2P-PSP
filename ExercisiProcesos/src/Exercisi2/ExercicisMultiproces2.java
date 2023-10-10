package Exercisi2;

public class ExercicisMultiproces2 {
    public static void main(String[] args) {
        ExercicisMultiproces2 EM = new ExercicisMultiproces2();
        System.out.println(EM.canviVocals(String.valueOf(args[0])));
    }

    String canviVocals(String texto) {
        texto = texto.toUpperCase();
        // Creamos un arreglo que contenga todas las vocales
        char[] vocales = {'A', 'E', 'I', 'O', 'U'};

        // Recorremos el texto, sustituyendo cada vocal por un "_"
        for (int i = 0; i < texto.length(); i++) {
            if (vocales.length > 0) {
                for (int j = 0; j < vocales.length; j++) {
                    if (texto.charAt(i) == vocales[j]) {
                        texto = texto.replace(texto.charAt(i), '_');
                    }
                }
            }
        }
        return "El fill diu: " + texto;
    }
}
