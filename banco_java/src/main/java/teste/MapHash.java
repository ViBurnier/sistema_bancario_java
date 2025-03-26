package teste;

import java.util.Scanner;

public class MapHash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Inicializa o Scanner

        System.out.println("Qual é o seu nome?"); // Exibe a pergunta
        String nome = scanner.nextLine(); // Aguarda a resposta do usuário

        System.out.println("Olá, " + nome + "! Qual é a sua idade?");
        int idade = scanner.nextInt(); // Aguarda a resposta do usuário para um número

        System.out.println("Obrigado! Você escolheu o caminho baseado nas respostas.");
        scanner.close(); // Fecha o Scanner (boa prática)
    }
}

