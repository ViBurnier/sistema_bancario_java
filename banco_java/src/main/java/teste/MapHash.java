package teste;

import java.util.HashMap;

public class MapHash {
    public static void main(String[] args) {
        // Criação do Map
        HashMap<String, Double> contas = new HashMap<>();

        // Adicionando contas ao Map
        contas.put("101", 1500.00); // id: "101", saldo: 1500.00
        contas.put("102", 2400.50); // id: "102", saldo: 2400.50
        contas.put("103", 1000.75); // id: "103", saldo: 1000.75

        // Acessando o saldo por ID
        System.out.println("Saldo da conta 101: " + contas.get("101")); // 1500.00

        // Atualizando o saldo
        contas.put("101", 1800.00);
        System.out.println("Novo saldo da conta 101: " + contas.get("101")); // 1800.00

        // Removendo uma conta
        contas.remove("102");
        System.out.println("Contas disponíveis: " + contas);
    }
}
