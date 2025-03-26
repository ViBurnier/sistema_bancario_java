package teste;
import java.util.ArrayList;

public class ExemploArrayList {
    public static void main(String[] args) {
        // Criação de um ArrayList de Strings
        ArrayList<String> frutas = new ArrayList<>();

        // Adicionando elementos
        frutas.add("Maçã");
        frutas.add("Banana");
        frutas.add("Laranja");

        // Acessando elementos por índice
        System.out.println("Primeira fruta: " + frutas.get(0)); // Maçã

        // Removendo um elemento
        frutas.remove("Banana");

        // Iterando sobre os elementos
        for (String fruta : frutas) {
            System.out.println(fruta);
        }

        // Tamanho da lista
        System.out.println("Número de frutas: " + frutas.size());
    }
}
