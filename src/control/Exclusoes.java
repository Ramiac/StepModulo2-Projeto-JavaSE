package control;

import control.servicos.Conexao;

import java.sql.SQLException;

public class Exclusoes {

    public static void excluiProf (String nomeProf) throws SQLException {
        Conexao c = new Conexao();

        c.updateAtivoFalse("professores", nomeProf);

        c.close();
    }

    public static void excluiAluno (String nomeAluno) throws SQLException {
        Conexao c = new Conexao();

        c.updateAtivoFalse("alunos", nomeAluno);

        c.close();
    }

    public static void excluiTurma (String nomeTurma) throws SQLException {
        Conexao c = new Conexao();

        c.updateAtivoFalse("turmas", nomeTurma);

        c.close();
    }

}
