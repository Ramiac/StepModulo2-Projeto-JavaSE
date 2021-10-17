package control;

import control.erros.ErroCpf;
import control.erros.ErroEmail;
import control.erros.ErroNome;
import control.erros.ErroTelefone;
import model.Aluno;
import model.Professor;
import model.Turma;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

import static control.format.Maiusculas.todasPalavras;
import static control.servicos.Exista.*;

public class Buscas {

    public static String rootBuscaProfessor(String nomeProf) throws IOException, ErroNome, ErroCpf, ErroTelefone, ErroEmail, SQLException {

        String listaCompleta = "";

        if (!isProfExisteOuAtivo(nomeProf)) {
            listaCompleta = "Esse professor não está cadastrado no sistema";
            return listaCompleta;
        }

        String listaProf = "";
        String listaTurma = " ";

        ArrayList<Professor> profs = new ArrayList<>();
        ArrayList<String> matriculas = new ArrayList<>();
        ArrayList<Turma> turmas = new ArrayList<>();


        DataInputStream diProf = new DataInputStream(
                new FileInputStream("arquivos\\listas\\lista_prof.dat")
        );

        DataInputStream diMatricul_prof = new DataInputStream(
                new FileInputStream("arquivos\\listas\\lista_matricul_prof.dat")
        );

        DataInputStream diTurma = new DataInputStream(
                new FileInputStream("arquivos\\listas\\lista_turmas.dat")
        );

        try {
            while (true) {
                Professor p = new Professor();
                p.id = diProf.readInt();
                p.setNome(diProf.readUTF());
                p.setCpf(diProf.readUTF());
                p.setTelefone(diProf.readUTF());
                p.setEmail(diProf.readUTF());
                p.setAtivo(diProf.readBoolean());

                profs.add(p);
            }
        } catch (EOFException e) {
            for (Professor p : profs) {
                if (nomeProf.equalsIgnoreCase(p.getNome())) {
                    listaProf = "<tr style=\"font-weight: normal;\">" +
                            "<td style=\"text-align: center;\">" + p.getId() + "</td>" +
                            "<td style=\"font-weight: bold;\">" + todasPalavras(p.getNome()) + "</td>" +
                            "<td>" + p.getCpf() + "</td>" +
                            "<td>" + p.getTelefone() + "</td>" +
                            "<td>" + p.getEmail() + "</td>" +
                            "<td style=\"text-align: center;\">" + p.isAtivo() + "</td>" +
                            "</tr>";
                }
            }
        }

        try {
            while (true) {
                String[] matricula = new String[2];
                matricula[0] = diMatricul_prof.readUTF(); // nome Prof
                matricula[1] = diMatricul_prof.readUTF(); // nome Turma
                if (matricula[0].equalsIgnoreCase(nomeProf)) {
                    matriculas.add(matricula[1]);
                }
            }
        } catch (EOFException e) {
            for (String m : matriculas) {
                try {
                    while (true) {
                        Turma t = new Turma();
                        t.id = diTurma.readInt();
                        t.setNome(diTurma.readUTF());
                        t.setDiaSemana(diTurma.readUTF());
                        t.setHorario(diTurma.readUTF());
                        t.setAtivo(diTurma.readBoolean());

                        turmas.add(t);
                    }

                } catch (EOFException exc) {
                    for (Turma t : turmas) {
                        if (t.getNome().equalsIgnoreCase(m)) {
                            listaTurma += "<tr style=\"font-weight: normal;\">" +
                                    "<td style=\"text-align: center;\">" + t.getId() + "</td>" +
                                    "<td style=\"font-weight: bold;\">" + todasPalavras(t.getNome()) + "</td>" +
                                    "<td>" + t.getDiaSemana() + "</td>" +
                                    "<td>" + t.getHorario() + "</td>" +
                                    "<td style=\"text-align: center;\">" + t.isAtivo() + "</td>" +
                                    "</tr>";
                        }
                    }
                }
            }
        } finally {
            diMatricul_prof.close();
            diProf.close();
            diTurma.close();

            if (listaTurma.equals(" ")) {
                listaTurma = "<tr><td colspan = \"5\" style=\"text-align: center;\">" +
                        "Esse prof ainda não matriculou nenhuma turma.</td></tr>";
            }


            listaCompleta = "<h2>Professor: </h2>" +
                    "<table cellspacing=\"15\" style=\"font-size: medium;\">" +
                    "<thead><tr>" +
                    "<th>ID</th>" +
                    "<th>Nome</th>" +
                    "<th>CPF</th>" +
                    "<th>Telefone</th>" +
                    "<th>Email</th>" +
                    "<th>Ativo</th>" +
                    "</tr></thead>" +
                    "<tbody>" + listaProf + "</tbody>" +
                    "</table>" +
                    "<h2>Turma(s) dele: " +
                    "<table cellspacing=\"15\" style=\"font-size: medium;\">" +
                    "<thead><tr>" +
                    "<th>ID</th>" +
                    "<th>Turma</th>" +
                    "<th>Dia da semana</th>" +
                    "<th>Horário</th>" +
                    "<th>Ativa</th>" +
                    "</tr></thead>" +
                    "<tbody>" + listaTurma + "</tbody>" +
                    "</table>";


        }
        return listaCompleta;
    }

    public static String rootBuscaAluno(String nomeAluno) throws SQLException, IOException, ErroNome, ErroCpf, ErroTelefone, ErroEmail {
        String listaCompleta = "";

        if (!isAlunoExisteOuAtivo(nomeAluno)) {
            listaCompleta = "Esse aluno não está cadastrado no sistema";
            return listaCompleta;
        }

        String listaAluno = "";
        String listaTurma = " ";

        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<String> matriculas = new ArrayList<>();
        ArrayList<Turma> turmas = new ArrayList<>();


        DataInputStream diAluno = new DataInputStream(
                new FileInputStream("arquivos\\listas\\lista_alunos.dat")
        );

        DataInputStream diMatricul_aluno = new DataInputStream(
                new FileInputStream("arquivos\\listas\\lista_matricul_aluno.dat")
        );

        DataInputStream diTurma = new DataInputStream(
                new FileInputStream("arquivos\\listas\\lista_turmas.dat")
        );

        try {
            while (true) {
                Aluno a = new Aluno();
                a.id = diAluno.readInt();
                a.setNome(diAluno.readUTF());
                a.setCpf(diAluno.readUTF());
                a.setTelefone(diAluno.readUTF());
                a.setEmail(diAluno.readUTF());
                a.setAtivo(diAluno.readBoolean());

                alunos.add(a);
            }
        } catch (EOFException e) {
            for (Aluno a : alunos) {
                if (nomeAluno.equalsIgnoreCase(a.getNome())) {
                    listaAluno = "<tr style=\"font-weight: normal;\">" +
                            "<td style=\"text-align: center;\">" + a.getId() + "</td>" +
                            "<td style=\"font-weight: bold;\">" + todasPalavras(a.getNome()) + "</td>" +
                            "<td>" + a.getCpf() + "</td>" +
                            "<td>" + a.getTelefone() + "</td>" +
                            "<td>" + a.getEmail() + "</td>" +
                            "<td style=\"text-align: center;\">" + a.isAtivo() + "</td>" +
                            "</tr>";
                }
            }
        }

        try {
            while (true) {
                String[] matricula = new String[2];
                matricula[0] = diMatricul_aluno.readUTF(); // nome Aluno
                matricula[1] = diMatricul_aluno.readUTF(); // nome Turma
                if (matricula[0].equalsIgnoreCase(nomeAluno)) {
                    matriculas.add(matricula[1]);
                }
            }
        } catch (EOFException e) {
            for (String m : matriculas) {
                try {
                    while (true) {
                        Turma t = new Turma();
                        t.id = diTurma.readInt();
                        t.setNome(diTurma.readUTF());
                        t.setDiaSemana(diTurma.readUTF());
                        t.setHorario(diTurma.readUTF());
                        t.setAtivo(diTurma.readBoolean());

                        turmas.add(t);
                    }

                } catch (EOFException exc) {
                    for (Turma t : turmas) {
                        if (t.getNome().equalsIgnoreCase(m)) {
                            listaTurma += "<tr style=\"font-weight: normal;\">" +
                                    "<td style=\"text-align: center;\">" + t.getId() + "</td>" +
                                    "<td style=\"font-weight: bold;\">" + todasPalavras(t.getNome()) + "</td>" +
                                    "<td>" + t.getDiaSemana() + "</td>" +
                                    "<td>" + t.getHorario() + "</td>" +
                                    "<td style=\"text-align: center;\">" + t.isAtivo() + "</td>" +
                                    "</tr>";
                        }
                    }
                }
            }
        } finally {
            diMatricul_aluno.close();
            diAluno.close();
            diTurma.close();

            if (listaTurma.equals(" ")) {
                listaTurma = "<tr><td colspan = \"5\" style=\"text-align: center;\">" +
                        "Esse aluno ainda não matriculou em nenhuma turma.</td></tr>";
            }


            listaCompleta = "<h2>Aluno: </h2>" +
                    "<table cellspacing=\"15\" style=\"font-size: medium;\">" +
                    "<thead><tr>" +
                    "<th>ID</th>" +
                    "<th>Nome</th>" +
                    "<th>CPF</th>" +
                    "<th>Telefone</th>" +
                    "<th>Email</th>" +
                    "<th>Ativo</th>" +
                    "</tr></thead>" +
                    "<tbody>" + listaAluno + "</tbody>" +
                    "</table>" +
                    "<h2>Turma(s) dele: " +
                    "<table cellspacing=\"15\" style=\"font-size: medium;\">" +
                    "<thead><tr>" +
                    "<th>ID</th>" +
                    "<th>Turma</th>" +
                    "<th>Dia da semana</th>" +
                    "<th>Horário</th>" +
                    "<th>Ativa</th>" +
                    "</tr></thead>" +
                    "<tbody>" + listaTurma + "</tbody>" +
                    "</table>";


        }
        return listaCompleta;
    }

    public static String rootBuscaTurma(String nomeTurma) throws SQLException, IOException, ErroNome, ErroCpf, ErroTelefone, ErroEmail {
        String listaCompleta = "";

        if (!isTurmaExisteOuAtiva(nomeTurma)) {
            listaCompleta = "Essa turma não está cadastrada no sistema";
            return listaCompleta;
        }

        String listaTurma = "";
        String listaAluno = "";

        ArrayList<Turma> turmas = new ArrayList<>();
        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<String> matriculas = new ArrayList<>();

        DataInputStream diAluno = new DataInputStream(
                new FileInputStream("arquivos\\listas\\lista_alunos.dat")
        );

        DataInputStream diMatricul_aluno = new DataInputStream(
                new FileInputStream("arquivos\\listas\\lista_matricul_aluno.dat")
        );

        DataInputStream diTurma = new DataInputStream(
                new FileInputStream("arquivos\\listas\\lista_turmas.dat")
        );

        DataInputStream diProf = new DataInputStream(
                new FileInputStream("arquivos\\listas\\lista_matricul_prof.dat")
        );

        try {
            while (true) {
                Turma t = new Turma();
                t.id = diTurma.readInt();
                t.setNome(diTurma.readUTF());
                t.setDiaSemana(diTurma.readUTF());
                t.setHorario(diTurma.readUTF());
                t.setAtivo(diTurma.readBoolean());

                turmas.add(t);
            }
        } catch (EOFException e) {
            for (Turma t : turmas) {
                if (t.getNome().equalsIgnoreCase(nomeTurma)) {
                    String prof = "";
                    try {
                        while (true) {
                            String[] matrProf = new String[2];
                            matrProf[0] = diProf.readUTF(); // nome prof
                            matrProf[1] = diProf.readUTF(); // nome turma
                            if (matrProf[1].equals(t.getNome())) prof = matrProf[0];
                        }
                    } catch (EOFException err) {
                        prof = "Sem prof ainda";
                    } finally {
                        listaTurma = "<tr style=\"font-weight: normal;\">" +
                                "<td style=\"text-align: center;\">" + t.getId() + "</td>" +
                                "<td style=\"font-weight: bold;\">" + todasPalavras(t.getNome()) + "</td>" +
                                "<td>" + prof + "</td>" +
                                "<td>" + t.getDiaSemana() + "</td>" +
                                "<td>" + t.getHorario() + "</td>" +
                                "<td style=\"text-align: center;\">" + t.isAtivo() + "</td>" +
                                "</tr>";
                    }
                }
            }
        }

        try {
            while (true) {
                String[] matricula = new String[2];
                matricula[0] = diMatricul_aluno.readUTF(); // nome Aluno
                matricula[1] = diMatricul_aluno.readUTF(); // nome Turma
                if (matricula[1].equalsIgnoreCase(nomeTurma)) {
                    matriculas.add(matricula[0]);
                }
            }
        } catch (EOFException e) {
            for (String m : matriculas) {
                try {
                    while (true) {
                        Aluno a = new Aluno();
                        a.id = diAluno.readInt();
                        a.setNome(diAluno.readUTF());
                        a.setCpf(diAluno.readUTF());
                        a.setTelefone(diAluno.readUTF());
                        a.setEmail(diAluno.readUTF());
                        a.setAtivo(diAluno.readBoolean());

                        alunos.add(a);
                    }

                } catch (EOFException exc) {
                    for (Aluno a : alunos) {
                        if (a.getNome().equalsIgnoreCase(m)) {
                            listaAluno += "<tr style=\"font-weight: normal;\">" +
                                    "<td style=\"text-align: center;\">" + a.getId() + "</td>" +
                                    "<td style=\"font-weight: bold;\">" + todasPalavras(a.getNome()) + "</td>" +
                                    "<td>" + a.getCpf() + "</td>" +
                                    "<td>" + a.getTelefone() + "</td>" +
                                    "<td>" + a.getEmail() + "</td>" +
                                    "<td style=\"text-align: center;\">" + a.isAtivo() + "</td>" +
                                    "</tr>";
                        }
                    }
                }
            }
        } finally {
            diMatricul_aluno.close();
            diAluno.close();
            diTurma.close();
            diProf.close();

            if (listaAluno.equals("")) {
                listaAluno = "<tr><td colspan = \"5\" style=\"text-align: center;\">" +
                        "Essa turma ainda não tem nenhum aluno matriculado.</td></tr>";
            }


            listaCompleta = "<h2>Turma: </h2>" +
                    "<table cellspacing=\"15\" style=\"font-size: medium;\">" +
                    "<thead><tr>" +
                    "<th>ID</th>" +
                    "<th>Turma</th>" +
                    "<th>Professor</th>" +
                    "<th>Dia da semana</th>" +
                    "<th>Horário</th>" +
                    "<th>Ativa</th>" +
                    "</tr></thead>" +
                    "<tbody>" + listaTurma + "</tbody>" +
                    "</table>" +
                    "<h2>Aluno(s) nela: " +
                    "<table cellspacing=\"15\" style=\"font-size: medium;\">" +
                    "<thead><tr>" +
                    "<th>ID</th>" +
                    "<th>Nome</th>" +
                    "<th>CPF</th>" +
                    "<th>Telefone</th>" +
                    "<th>Email</th>" +
                    "<th>Ativo</th>" +
                    "</tr></thead>" +
                    "<tbody>" + listaAluno + "</tbody>" +
                    "</table>";


        }
        return listaCompleta;
    }

    public static String profBuscaTurma(String nomeTurma) throws SQLException, IOException {
        String listaCompleta;

        if (!isTurmaExisteOuAtiva(nomeTurma)) {
            listaCompleta = "Essa turma não está cadastrada no sistema";
            return listaCompleta;
        }

        String listaTurma = "";
        String listaAluno = "";

        ArrayList<String[]> turmas = new ArrayList<>();
        ArrayList<String[]> alunos = new ArrayList<>();

        DataInputStream diMatricul_aluno = null;

        try {
            diMatricul_aluno = new DataInputStream(
                    new FileInputStream("arquivos\\listas\\lista_matricul_aluno.dat")
            );
        }catch (FileNotFoundException exc){
            return "Você ainda não matriculou nenhuma turma.";
        }

        DataInputStream diProf = new DataInputStream(
                new FileInputStream("arquivos\\listas\\lista_matricul_prof.dat")
        );

        try {

            while (true) {
                String[] t = new String[4];
                t[0] = diProf.readUTF(); // turma
                t[1] = diProf.readUTF(); // dia da semana
                t[2] = diProf.readUTF(); // horario
                t[3] = String.valueOf(diProf.readBoolean());

                turmas.add(t);
            }
        } catch (IOException e) {
            for (String[] t : turmas) {
                if (t[0].equalsIgnoreCase(nomeTurma)) {
                    listaTurma = "<tr style=\"font-weight: normal;\">" +
                            "<td style=\"font-weight: bold;\">" + todasPalavras(t[0]) + "</td>" +
                            "<td>" + t[1] + "</td>" +
                            "<td>" + t[2] + "</td>" +
                            "</tr>";
                    break;

                }
            }
        }

        try {
            while (true) {
                String[] a = new String[5];
                a[0] = diMatricul_aluno.readUTF(); // turma
                a[1] = diMatricul_aluno.readUTF(); // nome aluno
                a[2] = diMatricul_aluno.readUTF(); // cpf aluno
                a[3] = diMatricul_aluno.readUTF(); // telefone aluno
                a[4] = diMatricul_aluno.readUTF(); // email aluno

                alunos.add(a);
            }
        } catch (IOException e) {
            for (String[] a : alunos) {
                if (a[0].equalsIgnoreCase(nomeTurma)) {

                    listaAluno += "<tr style=\"font-weight: normal;\">" +
                            "<td style=\"font-weight: bold;\">" + todasPalavras(a[1]) + "</td>" +
                            "<td>" + a[2] + "</td>" +
                            "<td>" + a[3] + "</td>" +
                            "<td>" + a[4] + "</td>" +
                            "</tr>";

                }
            }
        } finally {

            diMatricul_aluno.close();
            diProf.close();

            if (listaTurma.equals("")) listaTurma = "<tr><td colspan = \"3\" style=\"text-align: center;\">" +
                    "Essa turma não é sua.</td></tr>";
            else if (listaAluno.equals("")) listaAluno = "<tr><td colspan = \"4\" style=\"text-align: center;\">" +
                    "Ainda nenhum aluno matriculado nessa turma.</td></tr>";


            listaCompleta = "<h2>Turma: </h2>" +
                    "<table align= \"center\" cellspacing=\"15\" style=\"font-size: medium;\">" +
                    "<thead><tr>" +
                    "<th>Turma</th>" +
                    "<th>Dia da semana</th>" +
                    "<th>Horário</th>" +
                    "</tr></thead>" +
                    "<tbody>" + listaTurma + "</tbody>" +
                    "</table>" +
                    "<h2>Aluno(s) nela: " +
                    "<table align= \"center\" cellspacing=\"15\" style=\"font-size: medium;\">" +
                    "<thead><tr>" +
                    "<th>Nome</th>" +
                    "<th>CPF</th>" +
                    "<th>Telefone</th>" +
                    "<th>Email</th>" +
                    "</tr></thead>" +
                    "<tbody>" + listaAluno + "</tbody>" +
                    "</table>";
        }

        return listaCompleta;
    }

    public static String alunoBuscaTurma(String nomeTurma) throws SQLException, IOException {
        String listaCompleta = "";

        if (!isTurmaExisteOuAtiva(nomeTurma)) {
            listaCompleta = "Essa turma não está cadastrada no sistema";
            return listaCompleta;
        }

        String listaTurma = "";

        ArrayList<String[]> turmas = new ArrayList<>();
        ArrayList<String[]> profs = new ArrayList<>();


        DataInputStream diMatricul_aluno = new DataInputStream(
                new FileInputStream("arquivos\\listas\\lista_matricul_aluno.dat")
        );

        DataInputStream diMatricul_prof = null;

        try {
            diMatricul_prof = new DataInputStream(
                    new FileInputStream("arquivos\\listas\\lista_matricul_prof.dat")
            );
        }catch (FileNotFoundException exc){
            return "Você ainda não está matriculado(a) em nenhuma turma.";
        }

        try {
            while (true) {
                String[] t = new String[3];

                t[0] = diMatricul_aluno.readUTF(); // Turma
                t[1] = diMatricul_aluno.readUTF(); // dia_semana
                t[2] = diMatricul_aluno.readUTF(); // horario

                turmas.add(t);
            }
        } catch (EOFException e) {

            for (String[] t : turmas) {
                if (t[0].equalsIgnoreCase(nomeTurma)) {
                    String prof = "";
                    try {
                        while (true) {
                            String[] p = new String[2];

                            p[0] = diMatricul_prof.readUTF(); // nome prof
                            p[1] = diMatricul_prof.readUTF(); // Turma
                            diMatricul_prof.readUTF(); // tel prof, nao necessario
                            diMatricul_prof.readUTF(); // email prof nao necessario

                            if (p[1].equalsIgnoreCase(nomeTurma)) {
                                prof = p[0];
                                break;
                            }

                        }
                    } catch (EOFException err) {
                        prof = "sem prof ainda";
                    } finally {

                        listaTurma = "<tr style=\"font-weight: normal;\">" +
                                "<td style=\"font-weight: bold;\">" + todasPalavras(t[0]) + "</td>" +
                                "<td style=\"font-weight: bold;\">" + todasPalavras(prof) + "</td>" +
                                "<td>" + t[1] + "</td>" +
                                "<td>" + t[2] + "</td>" +
                                "</tr>";


                    }
                    break;
                }
            }
        } finally {
            diMatricul_aluno.close();
            diMatricul_prof.close();

            if (listaTurma.equals("")) listaTurma = "<tr><td colspan=\"4\" style=\"text-align : center;\">" +
                    "Você não se matriculou ainda nessa turma.</td></tr>";

            listaCompleta = "<table align= \"center\" cellspacing=\"15\" style=\"font-size: medium;\">" +
                    "<thead><tr>" +
                    "<th>Turma</th>" +
                    "<th>Prof</th>" +
                    "<th>Dia da semana</th>" +
                    "<th>Horário</th>" +
                    "</tr></thead>" +
                    "<tbody>" + listaTurma + "</tbody>" +
                    "</table>";
        }
        return listaCompleta;
    }

}


