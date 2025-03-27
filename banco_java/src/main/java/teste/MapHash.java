package teste;

import java.util.Scanner;

import java.util.HashMap;

public class MapHash {
    public static void main(String[] args) {
        // Criando um HashMap
        HashMap<Integer, String> map = new HashMap<>();

        // Adicionando pares chave-valor
        map.put(1, "Maçã");
        map.put(2, "Banana");
        map.put(3, "Laranja");

        map.remove(1);
        map.put(1, "Relogio");
        // Acessando valores pelo índice (chave)
        System.out.println("Valor na chave 2: " + map.get(2)); // Banana

        // Removendo um par pela chave


        // Iterando sobre o Map
        for (Integer chave : map.keySet()) {
            System.out.println("Chave: " + chave + ", Valor: " + map.get(chave));
        }
    }
}

