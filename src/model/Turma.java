package model;

import control.erros.ErroNome;
import control.servicos.Conexao;
import control.servicos.Valida;

import java.sql.SQLException;

public class Turma {
    public int id;
    String nome, diaSemana, horario;
    boolean ativo = true;

    public int getId() {
        return id;
    }

    public void setId() {
        int id = 0;

        try {
            Conexao c = new Conexao();
            id = c.querySelectCount("turmas");
            c.close();
        } catch (SQLException throwables) {
            System.out.println("Erro do SQL: ");
            throwables.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Erro Geral: " + exception.getMessage());
        }
        this.id = id + 1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ErroNome {
        if (Valida.nomeIsValid(nome))
        this.nome = nome;
        else throw new ErroNome();
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
