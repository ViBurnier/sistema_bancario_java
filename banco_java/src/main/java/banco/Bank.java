package banco;
///BCrypt
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/// Crie uma classe, em Java e encapsule-a, para controlar os dados bancários de um Cliente.
/// Sabemos que todas as contas possuem: Nome Cliente, Número da conta, Saldo. E executa as
/// operações de Saque, Depósito e Saldo Disponível.
public class Bank extends Login{

    public void withDraw(){

    }

    public void deposity(double valor){
        for(ArrayList<Double> client : getListLog()){
            if(return_id() == client[0]){
                client[1] =+ valor;
            }
        }
    }

    public static void main(String[] args) {
                Register r = new Register();
                r.register("Vitor", "123123");
                r.register("Ana", "321321");
                r.register("Alex", "456456");

        //System.out.println(Arrays.deepToString(getList()));

                Login l = new Login();

                l.login("Ana", "321321");

                    deposity(200);

                System.out.println(getListLog());
    }

}





