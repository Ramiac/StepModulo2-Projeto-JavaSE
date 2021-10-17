package view.prof_frame;

import javax.swing.*;
import java.awt.*;

public class MainFrameProf {

    static JFrame frame;
    private static JPanel profMainPanel;

    public static void mainFrameProf() {
        profMainPanel = new Welcome().profMainPanel;

        frame = new JFrame("Professor - Sistema de gestão escolar");
        frame.add(new MenuProf().menuBarProf, BorderLayout.NORTH);
        frame.add(profMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static void mostraNovaTurma() {
        JPanel NovaTurmaPanel = new NovaTurma().novaTurma;

        frame.getContentPane().remove(profMainPanel);
        profMainPanel = NovaTurmaPanel;
        frame.getContentPane().add(NovaTurmaPanel);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }

    static void mostraNovaMatrProf() {
        JPanel novaMatrProf = new NovaMatrProf().novaMatricProf;

        frame.getContentPane().remove(profMainPanel);
        profMainPanel = novaMatrProf;
        frame.getContentPane().add(novaMatrProf);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }

    static void mostraListaProf(){
        JPanel ListaProf = new ListaProf().listaProf;

        frame.getContentPane().remove(profMainPanel);
        profMainPanel = ListaProf;
        frame.getContentPane().add(ListaProf);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }

    static void mostraListaAluno(){
        JPanel ListaAluno = new ListaAluno().listaAluno;

        frame.getContentPane().remove(profMainPanel);
        profMainPanel = ListaAluno;
        frame.getContentPane().add(ListaAluno);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }

    static void mostraListaTurma(){
        JPanel ListaTurma = new ListaTurmas().listaTurmas;

        frame.getContentPane().remove(profMainPanel);
        profMainPanel = ListaTurma;
        frame.getContentPane().add(ListaTurma);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }

    static void mostraBuscaTurma(){
        JPanel buscaTurma = new BuscaTurma().buscaTurma;

        frame.getContentPane().remove(profMainPanel);
        profMainPanel = buscaTurma;
        frame.getContentPane().add(buscaTurma);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }



}
