package model;

import control.servicos.Conexao;

import java.sql.SQLException;

public class Aluno extends Pessoa{
    public static final String PATH = "arquivos\\aluno.dat";


    @Override
    public void setId() {
        int id = 0;

        try {
            Conexao c = new Conexao();
            id = c.querySelectCount("alunos");
            c.close();
        } catch (SQLException throwables) {
            System.out.println("Erro do SQL: ");
            throwables.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Erro Geral: " + exception.getMessage());
        }
        this.id = id + 1;
    }
}
