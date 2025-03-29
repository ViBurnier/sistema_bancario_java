package banco;

import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

/// de acordo com a chave de login, return bank_balance

public class Login extends Register{
    public String name, password;

    static ArrayList<ArrayList<Double>> listLog = new ArrayList<>();

    HashMap<String, Double> conta = new HashMap<>();

            ArrayList<Double> subArray = new ArrayList<>();


    private void bank_balance(String id){
        //verifica se o id ja esta no listLog
        //se nao estiver criar um novo array para esse usuario

        double idNew = Double.parseDouble(id);

        boolean idExiste = false;

        for(ArrayList<Double> subArray : listLog){
            if(!subArray.isEmpty() && subArray.get(0) == idNew){
                idExiste = true;
                break;
            }
        }

        if (!idExiste) {
            ArrayList<Double> novoSubArray = new ArrayList<>();
            novoSubArray.add(idNew); // Adiciona o ID ao novo sub-array
            novoSubArray.add(create_map()); // Adiciona o saldo inicial ao sub-array
            listLog.add(novoSubArray); // Adiciona o novo sub-array ao array pai
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

            if (Objects.equals(client[0], name) && BCrypt.checkpw(password, client[1])) {
                id_permission = client[2];
                break;
            }

        }

        return id_permission;
    }

    public static ArrayList<ArrayList<Double>> getListLog() {
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
