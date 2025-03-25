package banco;

import org.mindrot.jbcrypt.BCrypt;

import java.util.Arrays;
import java.util.Objects;

public class Register {
    /// Array lista base.
    private static String[][] listClient = {};

    private static String name;
    private static String password;

    /// recebe o registro de usuário
    public void registerUser(String name, String password){
        /// verifica se os campos estão vazios.
        if(Objects.equals(name, " ") || Objects.equals(name, "") || password.length() < 6){
            throw new IllegalArgumentException("A senha deve ter no mínimo 6 caracteres!");
        }
        else{
            ///saveUser salva o usuário, passando name e password.
            this.name = name;
            this.password = password;
            saveUser();
        }
    };

    /// criptografa a senha (BCrypt)
    private static String hashing(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    };

    /// verifica se o usuário já existe dentro da listClient.
    private static void saveUser(){

        /// essa chave serve como segundo parâmetro para o if fora do loop.
        boolean keyPermission = false;

        /// percorre a listClient e verifica se o nome ou senha já existe dentro da lista,
        ///  caso exista exibe a mensagem e para o código.
        for (String[] client : listClient) {
            if (Objects.equals(client[0], name) || BCrypt.checkpw(password, client[1])) {
//                throw new IllegalArgumentException("Nome ou Senha já existe!");
                System.out.println("JA EXISTE");
            }
            else{
                keyPermission = true;
            }
        }
        /// Aqui tem dois casos. Caso 1: se a lista for igual a zero a keyPermision dará false
        /// porque o length do listClient será 0 e não entrará no FOR.
        /// Caso 2: se a chave for true, o loop FOR correu.
        if(keyPermission || listClient.length == 0){
            /// cria um novo array para o novo usuário.
            String[] newUser;
            /// array novo usuário recebe nome e a senha criptografada do usuário.
            newUser = new String[]{name, hashing(password)};
            /// método recebe novo array e O método newArray().
            addListClient(newUser, newArray());
        }
    }
    //CRIAR METODOS INDEPENDENTES

    /// adiciona cliente a lista
    private static void addListClient(String[] newUser, String[][] newArray){
        /// depois do método newArray() executado, recebe novo usuário.
        newArray[listClient.length] = newUser;

        /// atualiza a lista mandando o novo array com o novo usuário.
        update_listClient(newArray);
    }

    /// cria um novo array.
    private static String[][] newArray(){
        /// cria o novo array com o tamanho da listClient mais 1.
        String[][] newArray = new String[listClient.length + 1][];
        /// pegando o listClient da posição 0, para o newArray da posição 0 em diante, copiando todos as posições do list.
        System.arraycopy(listClient, 0, newArray, 0, listClient.length);
        /// retorna o newArray.
        return newArray;
    }

    /// atualiza listClient
    private static void update_listClient(String[][] newArray){
        /// cria o r_listClient e recebe o tamanho do newArray.
        String[][] r_listClient = new String[newArray.length][];
        /// copia o conteúdo do newArray para o r_listClient e listClient
        /// recebe a nova lista.
        System.arraycopy(newArray, 0, r_listClient, 0, newArray.length);
        listClient = r_listClient;
    }

    public static String[][] getListClient() {
        return listClient;
    }

    public static void main(String[] args) {
        Register b = new Register();
        b.registerUser("Vitor", "123123");
        b.registerUser("Ana", "141312");
        b.registerUser("Carlos", "512512");
        System.out.println(Arrays.deepToString(getListClient()));
    }
}
