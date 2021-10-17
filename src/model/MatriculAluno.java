package model;

import control.erros.ErroExisteAluno;
import control.servicos.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;

import static control.servicos.Exista.isAlunoExisteOuAtivo;

public class MatriculAluno extends Matriculas{
    int idAluno;

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(String nomeAluno) throws SQLException, ErroExisteAluno {
        Conexao c = new Conexao();
        int idAluno;

        if (!isAlunoExisteOuAtivo(nomeAluno)) throw new ErroExisteAluno();
        else {
            ResultSet rAluno = c.querySelectAll("alunos");

            while (rAluno.next()) {
                if (nomeAluno.equalsIgnoreCase(rAluno.getString("nome"))) {
                    idAluno = rAluno.getInt("id");
                    this.idAluno = idAluno;
                }
            }
            rAluno.close();
        }

        c.close();
    }
}
