package model;

import control.erros.ErroExisteTurma;
import control.servicos.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;

import static control.servicos.Exista.isTurmaExisteOuAtiva;


public abstract class Matriculas {
    int  idTurma;

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(String nomeTurma) throws ErroExisteTurma, SQLException {
        Conexao c = new Conexao();
        int idTurma;

        if (isTurmaExisteOuAtiva(nomeTurma)){
            ResultSet rTurma = c.querySelectAll("turmas");

            while (rTurma.next()) {
                if (nomeTurma.equalsIgnoreCase(rTurma.getString("nome"))) {
                    idTurma = rTurma.getInt("id");
                    this.idTurma = idTurma;
                }
            }
            rTurma.close();
        }else  throw new ErroExisteTurma();
        c.close();
    }
}
