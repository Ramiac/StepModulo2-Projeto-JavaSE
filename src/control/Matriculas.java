package control;

import control.erros.ErroExisteAluno;
import control.erros.ErroExisteProf;
import control.erros.ErroExisteTurma;
import control.servicos.Conexao;
import model.MatriculAluno;
import model.MatriculProf;

import java.sql.SQLException;

public class Matriculas {
    public static void cadastraMatrProf(String nomeProf, String nomeTurma)
            throws
            SQLException,
            ErroExisteProf,
            ErroExisteTurma {
        MatriculProf mp = new MatriculProf();
        Conexao c = new Conexao();

        mp.setIdProf(nomeProf);
        mp.setIdTurma(nomeTurma);

        c.update("INSERT INTO matricul_prof VALUES(" +
                mp.getIdProf() + ", " + mp.getIdTurma() + ");");

        c.close();
    }

    public static void cadastraMatrAluno(String nomeAluno, String nomeTurma)
            throws
            SQLException,
            ErroExisteTurma,
            ErroExisteAluno {
        MatriculAluno mp = new MatriculAluno();
        Conexao c = new Conexao();

        mp.setIdAluno(nomeAluno);
        mp.setIdTurma(nomeTurma);

        c.update("INSERT INTO matricul_aluno VALUES(" +
                mp.getIdAluno() + ", " + mp.getIdTurma() + ");");

        c.close();
    }


}
