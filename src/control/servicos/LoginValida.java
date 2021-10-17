package control.servicos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginValida {

    public static boolean isProfLoginValido(String usuario, String senha) {
        boolean isValid = false;
        try {
            Conexao c = new Conexao();
            ResultSet resultSet = c.queryUsuarioSenha("professores");

            while (resultSet.next()) {
                if (usuario.equals(resultSet.getString("usuario")) &&
                        senha.equals(resultSet.getString("senha")) &&
                        resultSet.getBoolean("ativo")
                ) isValid = true;
            }
            c.close();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isValid;
    }

    public static boolean isAlunoLoginValido(String usuario, String senha) {
        boolean isValid = false;

        try {
            Conexao c = new Conexao();

            ResultSet resultSet = c.queryUsuarioSenha("alunos");

            while (resultSet.next()) {
                if (usuario.equals(resultSet.getString("usuario")) &&
                        senha.equals(resultSet.getString("senha")) &&
                        resultSet.getBoolean("ativo")
                ) isValid = true;
            }
            c.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return isValid;
    }
}
