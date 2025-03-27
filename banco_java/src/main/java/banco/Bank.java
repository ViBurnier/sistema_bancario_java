package banco;
///BCrypt
import org.mindrot.jbcrypt.BCrypt;

import java.util.Arrays;
import java.util.Objects;

/// Crie uma classe, em Java e encapsule-a, para controlar os dados bancários de um Cliente.
/// Sabemos que todas as contas possuem: Nome Cliente, Número da conta, Saldo. E executa as
/// operações de Saque, Depósito e Saldo Disponível.
public class Bank extends Login{




    public static void main(String[] args) {
                Register r = new Register();
                r.register("Vitor", "123123");
                r.register("Ana", "321321");
                r.register("Alex", "456456");


                Login l = new Login();
                l.login("Ana", "321321");


                l.login("Vitor", "123123");


    }

}





