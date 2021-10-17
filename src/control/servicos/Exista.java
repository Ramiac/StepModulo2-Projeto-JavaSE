package control.servicos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Exista {

    public static boolean isProfExisteOuAtivo(String nome) throws SQLException {
        boolean exist = false;

        Conexao c = new Conexao();
        ResultSet r = c.querySelectAllAtivos("professores");
        try {
            while (r.next()) {
                if (nome.equalsIgnoreCase(r.getString("nome"))) {
                    exist = true;
                    break;
                }

            }
        } catch (SQLException e) {
            exist = false;
        }

        c.close();
        return exist;
    }

    public static boolean isAlunoExisteOuAtivo(String nome) throws SQLException {
        boolean exist = false;

        Conexao c = new Conexao();
        ResultSet r = c.querySelectAllAtivos("alunos");

        while (r.next()) {
            if (nome.equalsIgnoreCase(r.getString("nome"))) {
                exist = true;
                break;
            }
        }
        c.close();

        return exist;
    }

    public static boolean isTurmaExisteOuAtiva(String nome) throws SQLException {
        boolean exist = false;

        Conexao c = new Conexao();
        ResultSet r = c.querySelectAllAtivos("turmas");
        try {
            while (r.next()) {
                if (nome.equalsIgnoreCase(r.getString("nome"))) {
                    exist = true;
                    break;
                }
            }
        } catch (SQLException e) {
            exist = false;
        }
        c.close();

        return exist;
    }
}
