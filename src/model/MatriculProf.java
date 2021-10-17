package model;

import control.erros.ErroExisteProf;
import control.servicos.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;

import static control.servicos.Exista.isProfExisteOuAtivo;

public class MatriculProf extends Matriculas {
    int idProf;

    public int getIdProf() {
        return idProf;
    }

    public void setIdProf(String nomeProf) throws SQLException, ErroExisteProf {
        Conexao c = new Conexao();
        int idProf;

        if (!isProfExisteOuAtivo(nomeProf)) throw new ErroExisteProf();
        else {
            ResultSet rProf = c.querySelectAll("professores");

            while (rProf.next()) {
                if (nomeProf.equalsIgnoreCase(rProf.getString("nome"))) {
                    idProf = rProf.getInt("id");
                    this.idProf = idProf;
                }
            }
            rProf.close();
        }
        c.close();
    }
}
