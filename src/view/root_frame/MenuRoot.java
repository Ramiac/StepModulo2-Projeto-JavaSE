package view.root_frame;

import control.erros.ErroCpf;
import control.erros.ErroEmail;
import control.erros.ErroNome;
import control.erros.ErroTelefone;
import view.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static control.servicos.DeletaDat.deletaDat;

public class MenuRoot {
    JMenuBar menuBarRoot;
    private JMenu arquivo, exibir, buscar;
    private JMenuItem novo, matricula, exclusao, sair, professores, alunos, turmas, buscaProf, buscaAluno, buscaTurma;
    private JMenuItem novoProf, novoAluno, novaTurma;
    private JMenuItem novaMatAlun, novaMatProf;
    private JMenuItem exclProf, exclAluno, exclTurma;

    public MenuRoot() {
        novo = new JMenu("Novo Cadastro");
        matricula = new JMenu("Nova Matricula");
        exclusao = new JMenu("Exclusão");
        sair = new JMenuItem("Sair");

        novoProf = new JMenuItem("Professor");
        novoAluno = new JMenuItem("Aluno");
        novaTurma = new JMenuItem("Turma");

        novaMatProf = new JMenuItem("Matricula Professor");
        novaMatAlun = new JMenuItem("Matricula Aluno");

        exclProf = new JMenuItem("Professor");
        exclAluno = new JMenuItem("Aluno");
        exclTurma = new JMenuItem("Turma");

        professores = new JMenuItem("Lista dos professores");
        alunos = new JMenuItem("Lista dos alunos");
        turmas = new JMenuItem("Lista das turmas");

        buscaProf = new JMenuItem("Professor");
        buscaAluno = new JMenuItem("Aluno");
        buscaTurma = new JMenuItem("Turma");

        menuBarRoot = new JMenuBar();
        arquivo = new JMenu("Arquivo");
        exibir = new JMenu("Exibir");
        buscar = new JMenu("Buscar");

        menuBarRoot.add(arquivo);
        menuBarRoot.add(exibir);
        menuBarRoot.add(buscar);

        arquivo.add(novo);
        novo.add(novoProf);
        novo.add(novoAluno);
        novo.add(novaTurma);
        arquivo.add(matricula);
        matricula.add(novaMatProf);
        matricula.add(novaMatAlun);
        arquivo.add(exclusao);
        exclusao.add(exclProf);
        exclusao.add(exclAluno);
        exclusao.add(exclTurma);
        arquivo.add(sair);

        exibir.add(professores);
        exibir.add(alunos);
        exibir.add(turmas);

        buscar.add(buscaProf);
        buscar.add(buscaAluno);
        buscar.add(buscaTurma);

        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.login();
                MainFrameRoot.frame.setVisible(false);
                deletaDat("root");
            }
        });

        novoProf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameRoot.mostraNovoProf();
            }
        });

        novoAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameRoot.mostraNovoAluno();
            }
        });

        novaTurma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameRoot.mostraNovaTurma();
            }
        });

        novaMatProf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameRoot.mostraMatriProf();
            }
        });

        novaMatAlun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameRoot.mostraMatriAluno();
            }
        });

        professores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MainFrameRoot.mostraListaProf();
                } catch (ErroNome erroNome) {
                    erroNome.printStackTrace();
                } catch (ErroCpf erroCpf) {
                    erroCpf.printStackTrace();
                } catch (ErroEmail erroEmail) {
                    erroEmail.printStackTrace();
                } catch (ErroTelefone erroTelefone) {
                    erroTelefone.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        exclProf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameRoot.mostraExlclProf();
            }
        });

        exclAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameRoot.mostraExlclAluno();
            }
        });

        exclTurma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameRoot.mostraExlclTurma();
            }
        });

        alunos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameRoot.mostraListaAluno();
            }
        });

        turmas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameRoot.mostraListaTurma();
            }
        });

        buscaProf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameRoot.mostraBuscaProf();
            }
        });

        buscaAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameRoot.mostraBuscaAluno();
            }
        });

        buscaTurma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameRoot.mostraBuscaTurma();
            }
        });

    }


}
