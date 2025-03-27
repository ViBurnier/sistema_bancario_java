package banco;

import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

/// de acordo com a chave de login, return bank_balance

public class Login extends Register{
    private String name, password;
    ArrayList<ArrayList<Double>> listLog = new ArrayList<>();
    HashMap<String, Double> conta = new HashMap<>();

    private void bank_balance(String id){
        //verificar se o ID e maior que listlog.size
        //se for cria um novo array para esse usuario

        //id e string tenho que converter.

        int idNew = Integer.parseInt(id);

        ArrayList<Double> subArray = new ArrayList<>();

        if(idNew > listLog.size()){
            subArray.add(2.1);
            subArray.add(5.32);
            listLog.add(subArray);
            System.out.println(listLog);
        }

    }

    public void login(String name, String password){

        if(name.isEmpty() || password.length() > 6){
            throw new IllegalArgumentException("Nome ou Senha inválido!");
        }
        else{
            this.name = name;
            this.password = password;
            bank_balance(return_id());
        }
    }

    private double create_map(){

        conta.put(return_id(), 0.0);

        return conta.get(return_id());
    }

    private String return_id(){
        String id_permission = "";

        for (String[] client : getList()) {

            if (BCrypt.checkpw(password, client[1])) {
                id_permission = client[2];
                break;
            }

        }

        return id_permission;
    }

    public ArrayList<ArrayList<Double>> getListLog() {
        return listLog;
    }

//    public static void setBank_balance(double bank_balance) {
//        Login.bank_balance = bank_balance;
//    }
//
//    public static double getBank_balance() {
//        return bank_balance;
//    }
}
