package control.servicos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Valida {

    public static boolean nomeIsValid(String nome) {
        if (nome.length() > 0 && nome.length() <= 40)
            return true;
        else return false;
    }

    public static boolean usuarioIsValid(String usuario){
        if (usuario.length() > 0 && usuario.length() <= 20)
            return true;
        else return false;
    }

    public static boolean senhaIsValid(String senha){
        if (senha.length() > 0 && senha.length() <= 20)
            return true;
        else return false;
    }

    public static boolean telefoneIsValid(String telefone){
//        try{
//            Long.parseLong(telefone);
            if (telefone.length() > 10 && telefone.length() <= 13)
//            {
                return true;
//            }
            else return false;
//        } catch (NumberFormatException e) {
//            return false;
//        }
    }

    public static boolean cpfIsValid(String cpf) {
        try {
            Long.parseLong(cpf);
            if (cpf.length() == 11)
                return true;
            else return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean emailIsValid(String email) {
        String padrao = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        return email.matches(padrao);
    }


}
