package banco;
///BCrypt
import org.mindrot.jbcrypt.BCrypt;

import java.util.Arrays;
import java.util.Objects;

/// Crie uma classe, em Java e encapsule-a, para controlar os dados bancários de um Cliente.
/// Sabemos que todas as contas possuem: Nome Cliente, Número da conta, Saldo. E executa as
/// operações de Saque, Depósito e Saldo Disponível.
public class Bank {
    private double balance;
    private static String[][] listClient = {};

    /// recebe o registro de usuário
    public static void registerUser(String name, String password){
        /// caso os campos estiverem vazios(false)
        if(Objects.equals(name, " ") || Objects.equals(name, "") || password.length() < 6){
            System.out.println("Nome ou senha invalidos!");
        }
        else{
        /// A função hashing criptografa a senha.
        ///saveUser salva o usuário, passando name e password já criptografado.
            saveUser(name, password);
        }
    };

    private static String hashing(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    };

    private static void saveUser(String nameUser, String password){

        boolean keyPermission = false;

        for (String[] client : listClient) {
            if (Objects.equals(client[0], nameUser) || BCrypt.checkpw(password, client[1])) {
                System.out.println("Nome ou senha já existem!");
                break;
            }
            else{
                keyPermission = true;
            }

        }

        if(keyPermission || listClient.length == 0){
            String[] newUser;

            newUser = new String[]{nameUser, hashing(password)};

            addListClient(newUser, newArray());
        }
    }

    private static void addListClient(String[] newUser, String[][] newArray){
        newArray[listClient.length] = newUser;
        update_listClient(newArray);
    }

    private static String[][] newArray(){
        String[][] newArray = new String[listClient.length + 1][];
        System.arraycopy(listClient, 0, newArray, 0, listClient.length);
        return newArray;
    }

    private static void update_listClient(String[][] newArray){
        String[][] r_listClient = new String[newArray.length][];
        System.arraycopy(newArray, 0, r_listClient, 0, newArray.length);
        listClient = r_listClient;
    }


    public static void main(String[] args) {
        Bank b = new Bank();
        b.registerUser("Vitor", "123123");
        b.registerUser("Ana", "141312");
        b.registerUser("Carlos", "512512");
        System.out.println(Arrays.deepToString(listClient));
        b.registerUser("Mussun", "123123");
    }
}





