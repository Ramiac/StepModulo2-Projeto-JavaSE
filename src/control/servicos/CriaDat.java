package control.servicos;

import model.Aluno;
import model.Professor;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CriaDat {

    public static void criaDat(String tipoUsuario, String usuario, String senha) throws IOException, SQLException {
        DataOutputStream recarq;
        if (tipoUsuario.equals("Professor")) {
            recarq = new DataOutputStream(new FileOutputStream(Professor.PATH));
            recarq.writeUTF("jdbc:postgresql:PROJETO_UNIFICADO-SGE"); // endereço do servidor
            recarq.writeUTF(usuario);
            recarq.writeUTF(senha);
            baixaListas("Professor", usuario);
        } else if (tipoUsuario.equals("Aluno")) {
            recarq = new DataOutputStream(new FileOutputStream(Aluno.PATH));
            recarq.writeUTF("jdbc:postgresql:PROJETO_UNIFICADO-SGE"); // endereço do servidor
            recarq.writeUTF(usuario);
            recarq.writeUTF(senha);
            baixaListas("Aluno", usuario);
        } else {
            recarq = new DataOutputStream(new FileOutputStream("arquivos\\root.dat"));
            recarq.writeUTF("jdbc:postgresql:PROJETO_UNIFICADO-SGE"); // endereço do servidor
            recarq.writeUTF(usuario);
            recarq.writeUTF(senha);
            baixaListas("Root", usuario);
        }

        recarq.close();
    }

    private static void baixaListas(String tipoUsuario, String usuario) throws SQLException, IOException {
        Conexao c = new Conexao();
        String nome;

        if (tipoUsuario.equals("Professor")) {
            listaProfCompletaProf(c);
            listaTurmasProf(c, usuario); // Cria também lista da alunos do prof.
        } else if (tipoUsuario.equals("Root")) {
            listaCompletaProf(c);
            listaCompletaAlunos(c);
            listaCompletaTurmas(c);
            listaCompletaMatricul_aluno(c);
            listaCompletaMatricul_prof(c);
        } else {
            listaTurmasAluno(c, usuario);

        }

        c.close();
    }

    public static void listaCompletaProf(Conexao c) throws SQLException, IOException {
        DataOutputStream recarqProf = new DataOutputStream(new FileOutputStream("arquivos\\listas\\lista_prof.dat"));
        ResultSet r = c.querySelectAll("professores");
        while (r.next()) {
            recarqProf.writeInt(r.getInt("id"));
            recarqProf.writeUTF(r.getString("nome"));
            recarqProf.writeUTF(r.getString("cpf"));
            recarqProf.writeUTF(r.getString("telefone"));
            recarqProf.writeUTF(r.getString("email"));
            recarqProf.writeBoolean(r.getBoolean("ativo"));
        }
        r.close();
        recarqProf.close();
    }

    public static void listaCompletaAlunos(Conexao c) throws SQLException, IOException {
        DataOutputStream recarqAlunos = new DataOutputStream(new FileOutputStream("arquivos\\listas\\lista_alunos.dat"));
        ResultSet r = c.querySelectAll("alunos");
        while (r.next()) {
            recarqAlunos.writeInt(r.getInt("id"));
            recarqAlunos.writeUTF(r.getString("nome"));
            recarqAlunos.writeUTF(r.getString("cpf"));
            recarqAlunos.writeUTF(r.getString("telefone"));
            recarqAlunos.writeUTF(r.getString("email"));
            recarqAlunos.writeBoolean(r.getBoolean("ativo"));
        }

        r.close();
        recarqAlunos.close();
    }

    public static void listaCompletaTurmas(Conexao c) throws SQLException, IOException {
        DataOutputStream recarqTurmas = new DataOutputStream(new FileOutputStream("arquivos\\listas\\lista_turmas.dat"));
        ResultSet r = c.querySelectAll("turmas");
        while (r.next()) {
            recarqTurmas.writeInt(r.getInt("id"));
            recarqTurmas.writeUTF(r.getString("nome"));
            recarqTurmas.writeUTF(r.getString("dia_semana"));
            recarqTurmas.writeUTF(r.getString("horario"));
            recarqTurmas.writeBoolean(r.getBoolean("ativo"));
        }

        r.close();
        recarqTurmas.close();
    }

    public static void listaCompletaMatricul_aluno(Conexao c) throws SQLException, IOException {
        DataOutputStream recarqMatricul_aluno = new DataOutputStream(
                new FileOutputStream("arquivos\\listas\\lista_matricul_aluno.dat")
        );
        ResultSet r = c.querySelectJoinMatricul_aluno();
        while (r.next()) {
            recarqMatricul_aluno.writeUTF(r.getString(1)); // nome aluno
            recarqMatricul_aluno.writeUTF(r.getString(2)); // nome turma
        }

        r.close();
        recarqMatricul_aluno.close();
    }

    public static void listaCompletaMatricul_prof(Conexao c) throws SQLException, IOException {
        DataOutputStream recarqMatricul_prof = new DataOutputStream(
                new FileOutputStream("arquivos\\listas\\lista_matricul_prof.dat")
        );
        ResultSet r = c.querySelectJoinMatricul_prof();
        while (r.next()) {
            recarqMatricul_prof.writeUTF(r.getString(1)); // nome prof
            recarqMatricul_prof.writeUTF(r.getString(2)); // nome turma
        }

        r.close();
        recarqMatricul_prof.close();
    }

    public static void listaProfCompletaProf(Conexao c) throws SQLException, IOException {
        DataOutputStream recarqProf = new DataOutputStream(new FileOutputStream("arquivos\\listas\\lista_prof.dat"));
        ResultSet r = c.querySelectAll("professores");
        while (r.next()) {

            int id = r.getInt("id");
            String nome = r.getString("nome");
            String cpf = r.getString("cpf");
            String telefone = r.getString("telefone");
            String email = r.getString("email");
            boolean ativo = r.getBoolean("ativo");

            if (ativo) {
                recarqProf.writeInt(id);
                recarqProf.writeUTF(nome);
                recarqProf.writeUTF(cpf);
                recarqProf.writeUTF(telefone);
                recarqProf.writeUTF(email);
            }
        }
        r.close();
        recarqProf.close();
    }

    private static void listaTurmasProf(Conexao c, String usuario) throws IOException, SQLException {
        String profNome = "";

        ResultSet rProf = c.querySelectAll("professores");
        while (rProf.next()) {
            if (usuario.equals(rProf.getString("usuario")))
                profNome = rProf.getString("nome");
        }


        DataOutputStream recarqMatricul_prof = new DataOutputStream(
                new FileOutputStream("arquivos\\listas\\lista_matricul_prof.dat")
        );

        ResultSet r = c.querySelectJoinMatricul_prof();
        while (r.next()) {
            String nomeProf = r.getString(1);
            if (nomeProf.equalsIgnoreCase(profNome)) {
                String nomeTurma = r.getString(2);
                String diaSemana = r.getString("dia_semana");
                String horario = r.getString("horario");
                boolean ativo = r.getBoolean("ativo");

                if (ativo) {
                    recarqMatricul_prof.writeUTF(nomeTurma); // nome turma
                    recarqMatricul_prof.writeUTF(diaSemana);
                    recarqMatricul_prof.writeUTF(horario);
                    recarqMatricul_prof.writeBoolean(ativo);

                    listaAlunosProf(c, nomeTurma);
                }
            }
        }

        r.close();
        rProf.close();
        recarqMatricul_prof.close();
    }

    private static void listaAlunosProf(Conexao c, String nomeTurma) throws SQLException, IOException {
        DataOutputStream recarqMatricul_aluno = new DataOutputStream(
                new FileOutputStream("arquivos\\listas\\lista_matricul_aluno.dat", true)
        );

        ResultSet r = c.querySelectJoinMatricul_aluno();
        while (r.next()) {
            if (nomeTurma.equals(r.getString(2))) {
                recarqMatricul_aluno.writeUTF(nomeTurma); // nome da turma
                recarqMatricul_aluno.writeUTF(r.getString(1)); // nome do aluno
                recarqMatricul_aluno.writeUTF(r.getString("cpf"));
                recarqMatricul_aluno.writeUTF(r.getString("telefone"));
                recarqMatricul_aluno.writeUTF(r.getString("email"));
            }
        }

        r.close();
        recarqMatricul_aluno.close();
    }

    private static void listaTurmasAluno(Conexao c, String usuario) throws SQLException, IOException {
        String AlunoNome = "";
        ResultSet rAluno = c.querySelectAll("alunos");
        while (rAluno.next()) {
            if (usuario.equals(rAluno.getString("usuario")))
                AlunoNome = rAluno.getString("nome");
        }

        DataOutputStream recarqMatricul_aluno = new DataOutputStream(
                new FileOutputStream("arquivos\\listas\\lista_matricul_aluno.dat")
        );
        ResultSet r = c.querySelectJoinMatricul_aluno();
        while (r.next()) {
            String TurmaNome = r.getString(6);
            if (AlunoNome.equals(r.getString(1))) {
                String diaSemana = r.getString("dia_semana");
                String horario = r.getString("horario");
                boolean ativo = r.getBoolean("ativo");

                if (ativo) {
                    recarqMatricul_aluno.writeUTF(TurmaNome); // nome da turma
                    recarqMatricul_aluno.writeUTF(diaSemana);
                    recarqMatricul_aluno.writeUTF(horario);

                    listaProfAluno(c, TurmaNome); // cria lista de professores do aluno}
                }
            }
        }
        r.close();
        rAluno.close();
        recarqMatricul_aluno.close();
    }

    private static void listaProfAluno(Conexao c, String nomeTurma) throws IOException, SQLException {
        DataOutputStream recarqMatricul_prof = new DataOutputStream(
                new FileOutputStream("arquivos\\listas\\lista_matricul_prof.dat", true)
        );

        ResultSet r = c.querySelectJoinMatricul_prof();
        while (r.next()) {
            if (nomeTurma.equals(r.getString(2))) {
                recarqMatricul_prof.writeUTF(r.getString(1)); // nome do prof
                recarqMatricul_prof.writeUTF(nomeTurma); // nome da turma
                recarqMatricul_prof.writeUTF(r.getString("telefone"));
                recarqMatricul_prof.writeUTF(r.getString("email"));
            }
        }

        r.close();
        recarqMatricul_prof.close();
    }
}
