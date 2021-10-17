package view.aluno_frame;

import view.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static control.servicos.DeletaDat.deletaDat;
import static control.servicos.DeletaDat.deletaDatOnExit;

public class MenuAluno {
    JMenuBar menuBarAluno;
    private JMenu arquivo, exibir, buscar;
    private JMenuItem sair, professores, turmas, buscaTurma;

    MenuAluno() {
        sair = new JMenuItem("Sair");

        professores = new JMenuItem("Lista dos seus professores");
        turmas = new JMenuItem("Lista das suas turmas");

        buscaTurma = new JMenuItem("Turma");

        menuBarAluno = new JMenuBar();
        arquivo = new JMenu("Arquivo");
        exibir = new JMenu("Exibir");
        buscar = new JMenu("Buscar");

        menuBarAluno.add(arquivo);
        menuBarAluno.add(exibir);
        menuBarAluno.add(buscar);

        arquivo.add(sair);

        exibir.add(professores);
        exibir.add(turmas);

        buscar.add(buscaTurma);

        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.login();
                MainFrameAluno.frame.setVisible(false);
                deletaDat("aluno");
            }
        });

        professores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameAluno.mostraListaProf();
            }
        });


        turmas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameAluno.mostraListaTurma();
            }
        });

        buscaTurma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameAluno.mostraBuscaTurma();
            }
        });

    }
}
