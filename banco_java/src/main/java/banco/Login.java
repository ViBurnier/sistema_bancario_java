package banco;

import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

/// de acordo com a chave de login, return bank_balance

public class Login extends Register{
    ArrayList<String> listLog = new ArrayList<>();
    private void bank_balance(String id){


        //verificar se o ID e maior que listlog.size
        //se for cria um novo array para esse usuario

        //id e string tenho que converter.

        System.out.println(Integer.parseInt(id));
    }




    private String name, password;
    ArrayList<String> account_info = new ArrayList<String>();

    public void login(String name, String password){

        if(name.isEmpty() || password.length() > 6){
            throw new IllegalArgumentException("Nome ou Senha inválido!");
        }
        else{
            this.name = name;
            this.password = password;
            login_acess();
        }
    }

    private double create_map(String id){
        HashMap<String, Double> conta = new HashMap<>();

        conta.put(id, 0.0);

        return conta.get(id);
    }

    /// NAO TA PEGANDO O BCRYPT
    private String return_id(){
        String id_permission = "";

        for (String[] client : getList()) {
            boolean t = BCrypt.checkpw(password, client[1]);

            if (t) {
                id_permission = client[2];
                break;
            }

        }

        return id_permission;
    }

    private void login_acess(){
        /// SALDO DA CONTA ()
        create_map(return_id());
        bank_balance(return_id());
    }


//    public static void setBank_balance(double bank_balance) {
//        Login.bank_balance = bank_balance;
//    }
//
//    public static double getBank_balance() {
//        return bank_balance;
//    }
}
