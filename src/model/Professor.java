package model;

import control.servicos.Conexao;

import java.sql.SQLException;

public class Professor extends Pessoa{
    public static final String PATH = "arquivos\\prof.dat";

    @Override
    public void setId() {
        int id = 0;

        try {
            Conexao c = new Conexao();
            id = c.querySelectCount("professores");
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
