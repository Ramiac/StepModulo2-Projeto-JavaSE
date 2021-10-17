package control;

import control.erros.ErroCpf;
import control.erros.ErroEmail;
import control.erros.ErroNome;
import control.erros.ErroTelefone;
import model.Aluno;
import model.Professor;
import model.Turma;

import java.io.*;
import java.util.ArrayList;

import static control.format.Maiusculas.todasPalavras;

public class ExibirListas {

    public static String exibirListaCompletaProf() throws IOException, ErroNome, ErroCpf, ErroTelefone, ErroEmail {
        String lista = "";
        String listaCompleta = "";
        ArrayList<Professor> professores = new ArrayList<>();
        DataInputStream di = new DataInputStream(
                new FileInputStream("arquivos\\listas\\lista_prof.dat")
        );

        try {
            while (true) {
                Professor p = new Professor();
                p.id = di.readInt();
                p.setNome(di.readUTF());
                p.setCpf(di.readUTF());
                p.setTelefone(di.readUTF());
                p.setEmail(di.readUTF());
                p.setAtivo(di.readBoolean());
                professores.add(p);
            }
        } catch (EOFException e) {
            for (Professor p : professores) {
                lista += "<tr style=\"font-weight: normal;\">" +
                        "<td style=\"text-align: center;\">" + p.getId() + "</td>" +
                        "<td style=\"font-weight: bold;\">" + todasPalavras(p.getNome()) + "</td>" +
                        "<td>" + p.getCpf() + "</td>" +
                        "<td>" + p.getTelefone() + "</td>" +
                        "<td>" + p.getEmail() + "</td>" +
                        "<td style=\"text-align: center;\">" + p.isAtivo() + "</td>" +
                        "</tr>";
            }
        }

        di.close();

        try {
            if (professores.get(0) != null) {
                listaCompleta = "<table cellspacing=\"15\" style=\"font-size: medium;\">" +
                        "<thead><tr>" +
                        "<th>ID</th>" +
                        "<th>Nome</th>" +
                        "<th>CPF</th>" +
                        "<th>Telefone</th>" +
                        "<th>Email</th>" +
                        "<th>Ativo</th>" +
                        "</tr></thead>" +
                        "<tbody>" + lista + "</tbody>" +
                        "</table>";
            }
        } catch (IndexOutOfBoundsException e) {
            listaCompleta = "<p style=\"font-weight: bold; font-size: medium;\"> <br><br><br>Não há nenhum professore cadastrado.</p>";
        } finally {
            return listaCompleta;
        }

    }

    public static String exibirListaProfCompletaProf() throws
            IOException, ErroNome, ErroCpf, ErroTelefone, ErroEmail {
        String lista = "";
        String listaCompleta = "";
        ArrayList<Professor> professores = new ArrayList<>();
        DataInputStream di = new DataInputStream(
                new FileInputStream("arquivos\\listas\\lista_prof.dat")
        );
        try {
            while (true) {
                Professor p = new Professor();
                p.id = di.readInt();
                p.setNome(di.readUTF());
                p.setCpf(di.readUTF());
                p.setTelefone(di.readUTF());
                p.setEmail(di.readUTF());
                professores.add(p);
            }
        } catch (EOFException e) {
            for (Professor p : professores) {
                lista += "<tr style=\"font-weight: normal;\">" +
                        "<td style=\"text-align: center;\">" + p.getId() + "</td>" +
                        "<td style=\"font-weight: bold;\">" + todasPalavras(p.getNome()) + "</td>" +
                        "<td>" + p.getCpf() + "</td>" +
                        "<td>" + p.getTelefone() + "</td>" +
                        "<td>" + p.getEmail() + "</td>" +
                        "</tr>";
            }
        }

        di.close();

        try {
            if (professores.get(0) != null) {
                listaCompleta = "<table cellspacing=\"15\" style=\"font-size: medium;\">" +
                        "<thead><tr>" +
                        "<th>ID</th>" +
                        "<th>Nome</th>" +
                        "<th>CPF</th>" +
                        "<th>Telefone</th>" +
                        "<th>Email</th>" +
                        "</tr></thead>" +
                        "<tbody>" + lista + "</tbody>" +
                        "</table>";
            }

        } catch (IndexOutOfBoundsException e) {
            listaCompleta = "<p style=\"font-weight: bold; font-size: medium;\"> <br><br><br>Não há nenhum professore cadastrado.</p>";
        } finally {
            return listaCompleta;
        }

    }

    public static String exibirListaCompletaAlunos() throws IOException, ErroNome, ErroCpf, ErroTelefone, ErroEmail {
        String lista = "";
        String listaCompleta = "";
        ArrayList<Aluno> alunos = new ArrayList<>();
        DataInputStream di = new DataInputStream(
                new FileInputStream("arquivos\\listas\\lista_alunos.dat")
        );

        try {
            while (true) {
                Aluno a = new Aluno();
                a.id = di.readInt();
                a.setNome(di.readUTF());
                a.setCpf(di.readUTF());
                a.setTelefone(di.readUTF());
                a.setEmail(di.readUTF());
                a.setAtivo(di.readBoolean());
                alunos.add(a);
            }
        } catch (EOFException e) {
            for (Aluno a : alunos) {
                lista += "<tr style=\"font-weight: normal;\">" +
                        "<td style=\"text-align: center;\">" + a.getId() + "</td>" +
                        "<td style=\"font-weight: bold;\">" + todasPalavras(a.getNome()) + "</td>" +
                        "<td>" + a.getCpf() + "</td>" +
                        "<td>" + a.getTelefone() + "</td>" +
                        "<td>" + a.getEmail() + "</td>" +
                        "<td style=\"text-align: center;\">" + a.isAtivo() + "</td>" +
                        "</tr>";
            }
        }

        di.close();

        try {
            if (alunos.get(0) != null) {
                listaCompleta = "<table cellspacing=\"15\" style=\"font-size: medium;\">" +
                        "<thead><tr>" +
                        "<th>ID</th>" +
                        "<th>Nome</th>" +
                        "<th>CPF</th>" +
                        "<th>Telefone</th>" +
                        "<th>Email</th>" +
                        "<th>Ativo</th>" +
                        "</tr></thead>" +
                        "<tbody>" + lista + "</tbody>" +
                        "</table>";
            }

        } catch (IndexOutOfBoundsException e) {
            listaCompleta = "<p style=\"font-weight: bold; font-size: medium;\"> " +
                    "<br><br><br>Não há nenhum aluno cadastrado.</p>";
        } finally {
            return listaCompleta;
        }

    }

    public static String exibirListaCompletaTurmas() throws IOException, ErroNome {
        String lista = "";
        String listaCompleta = "";
        ArrayList<Turma> turmas = new ArrayList<>();
        DataInputStream di = new DataInputStream(
                new FileInputStream("arquivos\\listas\\lista_turmas.dat")
        );

        DataInputStream diProf = new DataInputStream(
                new FileInputStream("arquivos\\listas\\lista_matricul_prof.dat")
        );

        try {
            while (true) {
                Turma t = new Turma();
                t.id = di.readInt();
                t.setNome(di.readUTF());
                t.setDiaSemana(di.readUTF());
                t.setHorario(di.readUTF());
                t.setAtivo(di.readBoolean());
                turmas.add(t);
            }
        } catch (EOFException e) {
            for (Turma t : turmas) {
                String prof = "";
                try {
                    while (true) {
                        String[] matrProf = new String[2];
                        matrProf[0] = diProf.readUTF();
                        matrProf[1] = diProf.readUTF();
                        if (matrProf[1].equals(t.getNome())) {
                            prof = matrProf[0];
                            break;
                        }
                    }
                } catch (EOFException err) {
                    prof = "Sem prof ainda";
                } finally {
                    lista += "<tr style=\"font-weight: normal;\">" +
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

        di.close();
        diProf.close();
        try {
            if (turmas.get(0) != null) {
                listaCompleta = "<table cellspacing=\"15\" style=\"font-size: medium;\">" +
                        "<thead><tr>" +
                        "<th>ID</th>" +
                        "<th>Nome</th>" +
                        "<th>Professor</th>" +
                        "<th>Dia da semana</th>" +
                        "<th>Horário</th>" +
                        "<th>Ativa</th>" +
                        "</tr></thead>" +
                        "<tbody>" + lista + "</tbody>" +
                        "</table>";
            }
        } catch (IndexOutOfBoundsException e) {
            listaCompleta = "<p style=\"font-weight: bold; font-size: medium;\"> " +
                    "<br><br><br>Não há nenhuma turma cadastrada.</p>";
        } finally {
            return listaCompleta;
        }

    }

    public static String exibirListaTurmasDumProf() throws IOException, ErroNome {
        String lista = "";
        String listaCompleta = "";
        ArrayList<Turma> turmas = new ArrayList<>();
        DataInputStream di = new DataInputStream(
                new FileInputStream("arquivos\\listas\\lista_matricul_prof.dat")
        );

        try {
            while (true) {
                Turma t = new Turma();
                t.setNome(di.readUTF());
                t.setDiaSemana(di.readUTF());
                t.setHorario(di.readUTF());
                t.setAtivo(di.readBoolean());
                turmas.add(t);
            }
        } catch (EOFException e) {
            for (Turma t : turmas) {

                lista += "<tr style=\"font-weight: normal;\">" +
                        "<td style=\"font-weight: bold;\">" + todasPalavras(t.getNome()) + "</td>" +
                        "<td>" + t.getDiaSemana() + "</td>" +
                        "<td>" + t.getHorario() + "</td>" +
                        "<td style=\"text-align: center;\">" + t.isAtivo() + "</td>" +
                        "</tr>";
            }
        }

        di.close();

        try {
            if (turmas.get(0) != null) {
                listaCompleta = "<table cellspacing=\"15\" style=\"font-size: medium;\">" +
                        "<thead><tr>" +
                        "<th>Nome</th>" +
                        "<th>Dia da semana</th>" +
                        "<th>Horário</th>" +
                        "<th>Ativa</th>" +
                        "</tr></thead>" +
                        "<tbody>" + lista + "</tbody>" +
                        "</table>";
            }
        } catch (IndexOutOfBoundsException e) {
            listaCompleta = "<p style=\"font-weight: bold; font-size: medium;\"> " +
                    "<br><br><br>Não há nenhuma turma cadastrada.</p>";
        } finally {
            return listaCompleta;
        }
    }

    public static String exibirAlunosDumProf() throws IOException {
        String lista = "";
        String listaCompleta = "";
        ArrayList<String[]> alunos = new ArrayList<>();

        try {
            DataInputStream dis = new DataInputStream(
                    new FileInputStream("arquivos\\listas\\lista_matricul_aluno.dat")
            );

            try {
                while (true) {
                    String[] aluno = new String[5];
                    aluno[1] = dis.readUTF(); // nomeTurma
                    aluno[0] = dis.readUTF(); // nomeAluno
                    aluno[2] = dis.readUTF(); // cpfAluno
                    aluno[3] = dis.readUTF(); // telAluno
                    aluno[4] = dis.readUTF(); // emailAluno
                    alunos.add(aluno);
                }

            } catch (EOFException e) {
                for (int i = 0; i < alunos.size(); i++)
                    lista += "<tr style=\"font-weight: normal;\">" +
                            "<td style=\"font-weight: bold;\">" + todasPalavras(alunos.get(i)[0]) + "</td>" +
                            "<td>" + todasPalavras(alunos.get(i)[1]) + "</td>" +
                            "<td>" + alunos.get(i)[2] + "</td>" +
                            "<td>" + alunos.get(i)[3] + "</td>" +
                            "<td>" + alunos.get(i)[4] + "</td>" +
                            "</tr>";
            }

            dis.close();

            try {
                if (alunos.get(0) != null) {
                    listaCompleta = "<table cellspacing=\"15\" style=\"font-size: medium;\">" +
                            "<thead><tr>" +
                            "<th>Nome do Aluno</th>" +
                            "<th>Turma</th>" +
                            "<th>CPF</th>" +
                            "<th>telefone</th>" +
                            "<th>Email</th>" +
                            "</tr></thead>" +
                            "<tbody>" + lista + "</tbody>" +
                            "</table>";
                }
            } catch (IndexOutOfBoundsException e) {
                listaCompleta = "<p style=\"font-weight: bold; font-size: medium;\"> " +
                        "<br><br><br>Não há nenhum alunos nas suas turmas.</p>";
            }
        } catch (FileNotFoundException e) {
            listaCompleta = "<p style=\"font-weight: bold; font-size: medium;\"> " +
                    "<br><br><br>Não há nenhuma turmas matriculada por vc.</p>";
        } finally {
            return listaCompleta;
        }

    }

    public static String exibirProfsDumAluno() throws IOException {
        String lista = "";
        String listaCompleta = "";
        ArrayList<String[]> profs = new ArrayList<>();

        try {
            DataInputStream dis = new DataInputStream(
                    new FileInputStream("arquivos\\listas\\lista_matricul_prof.dat")
            );

            try {
                while (true) {
                    String[] prof = new String[4];
                    prof[0] = dis.readUTF(); // nomeProf
                    prof[1] = dis.readUTF(); // turma
                    prof[2] = dis.readUTF(); // telProf
                    prof[3] = dis.readUTF(); // emailProf

                    profs.add(prof);
                }

            } catch (EOFException e) {
                for (int i = 0; i < profs.size(); i++)
                    lista += "<tr style=\"font-weight: normal;\">" +
                            "<td style=\"font-weight: bold;\">" + todasPalavras(profs.get(i)[0]) + "</td>" +
                            "<td>" + todasPalavras(profs.get(i)[1]) + "</td>" +
                            "<td>" + profs.get(i)[2] + "</td>" +
                            "<td>" + profs.get(i)[3] + "</td>" +
                            "</tr>";
            }

            dis.close();

            try {
                if (profs.get(0) != null) {
                    listaCompleta = "<table cellspacing=\"15\" style=\"font-size: medium;\">" +
                            "<thead><tr>" +
                            "<th>Nome do Professor</th>" +
                            "<th>Turma</th>" +
                            "<th>telefone</th>" +
                            "<th>Email</th>" +
                            "</tr></thead>" +
                            "<tbody>" + lista + "</tbody>" +
                            "</table>";
                }
            } catch (IndexOutOfBoundsException e) {
                listaCompleta = "<p style=\"font-weight: bold; font-size: medium;\"> " +
                        "<br><br><br>Não há nenhum professores nas suas turmas.</p>";
            }
        }catch (FileNotFoundException e){
            listaCompleta = "<p style=\"font-weight: bold; font-size: medium;\"> " +
                    "<br><br><br>Você está matriculado(a) em nenhuma turma ainda.</p>";
        }finally {
            return listaCompleta;
        }
    }

    public static String exibirTurmasDumAluno() throws IOException {
        String lista = "";
        String listaCompleta = "";
        ArrayList<String[]> turmas = new ArrayList<>();

        DataInputStream dis = new DataInputStream(
                new FileInputStream("arquivos\\listas\\lista_matricul_aluno.dat")
        );

        try {
            while (true) {
                String[] turma = new String[3];
                turma[0] = dis.readUTF(); // Turma
                turma[1] = dis.readUTF(); // dia da semana
                turma[2] = dis.readUTF(); // horario

                turmas.add(turma);
            }

        } catch (EOFException e) {
            for (int i = 0; i < turmas.size(); i++)
                lista += "<tr style=\"font-weight: normal;\">" +
                        "<td style=\"font-weight: bold;\">" + todasPalavras(turmas.get(i)[0]) + "</td>" +
                        "<td>" + turmas.get(i)[1] + "</td>" +
                        "<td>" + turmas.get(i)[2] + "</td>" +
                        "</tr>";
        }

        dis.close();
        try {
            if (turmas.get(0) != null) {
                listaCompleta = "<table cellspacing=\"15\" style=\"font-size: medium;\">" +
                        "<thead><tr>" +
                        "<th>Turma</th>" +
                        "<th>Dia da semana</th>" +
                        "<th>Horário</th>" +
                        "</tr></thead>" +
                        "<tbody>" + lista + "</tbody>" +
                        "</table>";
            }
        } catch (IndexOutOfBoundsException e) {
            listaCompleta = "<p style=\"font-weight: bold; font-size: medium;\"> " +
                    "<br><br><br>Você não está cadastrado em nenhuma turma ainda.</p>";
        } finally {
            return listaCompleta;
        }


    }
}
