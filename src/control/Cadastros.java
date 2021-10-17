package control;

import control.erros.*;
import control.servicos.Conexao;
import model.Aluno;
import model.Professor;
import model.Turma;

import java.sql.SQLException;
import java.util.Locale;

import static control.servicos.Exista.isProfExisteOuAtivo;

public class Cadastros {

    public static void cadastraProf(
            String nome,
            String usuario,
            String senha,
            String cpf,
            String telefone,
            String email
    ) throws
            SQLException,
            ErroNome,
            ErroUsuario,
            ErroSenha,
            ErroCpf,
            ErroTelefone,
            ErroEmail {

        Professor p = new Professor();
        Conexao connect = new Conexao();

        p.setId();
        p.setNome(nome);
        p.setUsuario(usuario);
        p.setSenha(senha);
        p.setCpf(cpf);
        p.setTelefone(telefone);
        p.setEmail(email);

        connect.update("INSERT INTO professores VALUES(" +
                p.getId() +
                ", '" + p.getUsuario() +
                "', '" + p.getSenha() +
                "', '" + p.getNome().toLowerCase() +
                "', '" + p.getCpf() +
                "', '" + p.getTelefone() +
                "', '" + p.getEmail() +
                "', " + p.isAtivo() + ");"
        );
        connect.close();
    }

    public static void cadastraAluno(
            String nome,
            String usuario,
            String senha,
            String cpf,
            String telefone,
            String email
    ) throws
            SQLException,
            ErroNome,
            ErroUsuario,
            ErroSenha,
            ErroCpf,
            ErroTelefone,
            ErroEmail {

        Aluno a = new Aluno();
        Conexao connect = new Conexao();

        a.setId();
        a.setNome(nome);
        a.setUsuario(usuario);
        a.setSenha(senha);
        a.setCpf(cpf);
        a.setTelefone(telefone);
        a.setEmail(email);

        connect.update("INSERT INTO alunos VALUES(" +
                a.getId() +
                ", '" + a.getUsuario() +
                "', '" + a.getSenha() +
                "', '" + a.getNome().toLowerCase() +
                "', '" + a.getCpf() +
                "', '" + a.getTelefone() +
                "', '" + a.getEmail() +
                "', " + a.isAtivo() + ");"
        );
        connect.close();
    }

    public static void cadastraTurmas(String nome, String diaSemana, String horario)
            throws SQLException, ErroNome {
        Turma t = new Turma();
        Conexao connect = new Conexao();

        t.setId();
        t.setNome(nome);
        t.setDiaSemana(diaSemana);
        t.setHorario(horario);

        connect.update("INSERT INTO turmas VALUES(" +
                t.getId() +
                ", '" + t.getNome().toLowerCase() +
                "', '" + t.getDiaSemana() +
                "', " + t.isAtivo() +
                ", '" + t.getHorario() + "');"
        );

        connect.close();
    }



}
