package view.prof_frame;

import view.Login;
import view.root_frame.MainFrameRoot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static control.servicos.DeletaDat.deletaDat;

public class MenuProf {
    JMenuBar menuBarProf;
    private JMenu arquivo, exibir, buscar;
    private JMenuItem novo, matricula, sair, professores, alunos, turmas, buscaTurma;
    private JMenuItem novaTurma;
    private JMenuItem novaMatProf;

    MenuProf() {
        novo = new JMenu("Novo Cadastro");
        matricula = new JMenu("Nova Matricula");
        sair = new JMenuItem("Sair");

        novaTurma = new JMenuItem("Turma");

        novaMatProf = new JMenuItem("Matricula Professor");

        professores = new JMenuItem("Lista dos professores");
        alunos = new JMenuItem("Lista dos seus alunos");
        turmas = new JMenuItem("Lista das suas turmas");

        buscaTurma = new JMenuItem("Turma");

        menuBarProf = new JMenuBar();
        arquivo = new JMenu("Arquivo");
        exibir = new JMenu("Exibir");
        buscar = new JMenu("Buscar");

        menuBarProf.add(arquivo);
        menuBarProf.add(exibir);
        menuBarProf.add(buscar);

        arquivo.add(novo);
        novo.add(novaTurma);
        arquivo.add(matricula);
        matricula.add(novaMatProf);
        arquivo.add(sair);

        exibir.add(professores);
        exibir.add(alunos);
        exibir.add(turmas);

        buscar.add(buscaTurma);

        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.login();
                MainFrameProf.frame.setVisible(false);
                deletaDat("prof");
            }
        });

        novaTurma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameProf.mostraNovaTurma();
            }
        });

        novaMatProf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameProf.mostraNovaMatrProf();
            }
        });

        professores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameProf.mostraListaProf();
            }
        });

        alunos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameProf.mostraListaAluno();
            }
        });

        turmas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameProf.mostraListaTurma();
            }
        });

        buscaTurma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameProf.mostraBuscaTurma();
            }
        });

    }
}
