package view.aluno_frame;

import javax.swing.*;
import java.awt.*;

public class MainFrameAluno {

    static JFrame frame;
    private static JPanel alunoMainPanel;

    public static void mainFrameAluno(){
        alunoMainPanel  = new Welcome().alunoMainPanel;

        frame = new JFrame("Aluno - Sistema de gestão escolar");
        frame.add(new MenuAluno().menuBarAluno, BorderLayout.NORTH);
        frame.add(alunoMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static void mostraListaProf(){
        JPanel ListaProf = new ListaProf().listaProf;

        frame.getContentPane().remove(alunoMainPanel);
        alunoMainPanel = ListaProf;
        frame.getContentPane().add(ListaProf);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }

    static void mostraListaAluno(){
        JPanel ListaAluno = new ListaTurmas().listaTurmas;

        frame.getContentPane().remove(alunoMainPanel);
        alunoMainPanel = ListaAluno;
        frame.getContentPane().add(ListaAluno);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }

    static void mostraListaTurma(){
        JPanel ListaTurma = new ListaTurmas().listaTurmas;

        frame.getContentPane().remove(alunoMainPanel);
        alunoMainPanel = ListaTurma;
        frame.getContentPane().add(ListaTurma);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }

    static void mostraBuscaTurma(){
        JPanel buscaTurma = new BuscaTurma().buscaTurma;

        frame.getContentPane().remove(alunoMainPanel);
        alunoMainPanel = buscaTurma;
        frame.getContentPane().add(buscaTurma);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }
}
