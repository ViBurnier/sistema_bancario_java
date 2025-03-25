package banco;

import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Login extends Register{

    private static double bank_balance;

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

    private Double create_map(String id){
        HashMap<String, Double> conta = new HashMap<>();

        conta.put(id, 0.0);

        return conta.get(id);
    }

    private String return_id(){
        String id_permission = "";

        for (String[] client : getList()) {
            if (Objects.equals(client[0], name) && BCrypt.checkpw(password, client[1])) {
                id_permission = client[2];
                break;
            }
            else{
                throw new IllegalArgumentException("Conta nao encontrada!");
            }
        }

        return id_permission;
    }

    private void login_acess(){
        /// SALDO DA CONTA ()
        bank_balance =  create_map(return_id());


    }

    public static double getBank_balance() {
        return bank_balance;
    }
}
