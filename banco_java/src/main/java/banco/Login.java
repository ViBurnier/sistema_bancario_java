package banco;

import org.mindrot.jbcrypt.BCrypt;

import java.util.Arrays;
import java.util.Objects;

public class Login extends Register{

    private String name, password;

    public void login(String name, String password){
        if(name.isEmpty() || password.length() < 6){
            throw new IllegalArgumentException("Nome ou Senha inválido!");
        }
        else{
            this.name = name;
            this.password = password;
            valid_login();
        }
    }

    private void valid_login(){
        String id_permission = "";

        for (String[] client : getList()) {
            if (Objects.equals(client[0], name) && BCrypt.checkpw(password, client[1])) {
                id_permission = client[2];
            }
        }


    }

    public static void main(String[] args) {
        Register r = new Register();
        r.register("Vitor", "123123");
        r.register("aaa", "123133");
        r.register("bbb", "321321");
        Login l = new Login();
        l.login("Vitor", "123123");
        ///System.out.println(Arrays.deepToString(getList()));
    }
}
