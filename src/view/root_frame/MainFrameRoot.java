package view.root_frame;

import control.erros.ErroCpf;
import control.erros.ErroEmail;
import control.erros.ErroNome;
import control.erros.ErroTelefone;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrameRoot {
    static JFrame frame;
    private static JPanel rootMainPanel;

    public static void mainFrameRoot(){
        rootMainPanel  = new Welcome().rootMainPanel;

        frame = new JFrame("Root - Sistema de gestão escolar");
        frame.add(new MenuRoot().menuBarRoot, BorderLayout.NORTH);
        frame.add(rootMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void mostraNovoProf(){
        JPanel rootNovoProfPanel = new NovoProf().novoProf;

        frame.getContentPane().remove(rootMainPanel);
        rootMainPanel = rootNovoProfPanel;
        frame.getContentPane().add(rootNovoProfPanel);
        frame.repaint();
        frame.printAll(frame.getGraphics());

    }

    public static void mostraNovoAluno(){
        JPanel rootNovoAlunPanel = new NovoAluno().novoAluno;

        frame.getContentPane().remove(rootMainPanel);
        rootMainPanel = rootNovoAlunPanel;
        frame.getContentPane().add(rootNovoAlunPanel);
        frame.repaint();
        frame.printAll(frame.getGraphics());

    }

    public static void mostraNovaTurma(){
        JPanel rootNovaTurmaPanel = new NovaTurma().novaTurma;

        frame.getContentPane().remove(rootMainPanel);
        rootMainPanel = rootNovaTurmaPanel;
        frame.getContentPane().add(rootNovaTurmaPanel);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }

    public static void mostraMatriProf(){
        JPanel rootMatricProfPanel = new NovaMatrProf().novaMatricProf;

        frame.getContentPane().remove(rootMainPanel);
        rootMainPanel = rootMatricProfPanel;
        frame.getContentPane().add(rootMatricProfPanel);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }

    public static void mostraMatriAluno(){
        JPanel rootMatricAlunoPanel = new NovaMatrAluno().novaMatrAluno;

        frame.getContentPane().remove(rootMainPanel);
        rootMainPanel = rootMatricAlunoPanel;
        frame.getContentPane().add(rootMatricAlunoPanel);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }

    public static void mostraExlclProf(){
        JPanel rootExclProf = new ExclProf().exclProfPanel;

        frame.getContentPane().remove(rootMainPanel);
        rootMainPanel = rootExclProf;
        frame.getContentPane().add(rootExclProf);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }
    public static void mostraExlclAluno(){
        JPanel rootExclAluno = new ExclAluno().exclAluno;

        frame.getContentPane().remove(rootMainPanel);
        rootMainPanel = rootExclAluno;
        frame.getContentPane().add(rootExclAluno);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }

    public static void mostraExlclTurma(){
        JPanel rootExclTurma = new ExclTurma().exclTurma;

        frame.getContentPane().remove(rootMainPanel);
        rootMainPanel = rootExclTurma;
        frame.getContentPane().add(rootExclTurma);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }

    public static void mostraListaProf() throws ErroNome, ErroCpf, ErroEmail, ErroTelefone, IOException {
        JPanel rootListaProfPanel = new ListaProf().listaProf;

        frame.getContentPane().remove(rootMainPanel);
        rootMainPanel = rootListaProfPanel;
        frame.getContentPane().add(rootListaProfPanel);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }

    public static void mostraListaAluno(){
        JPanel rootListaAlunoPanel = new ListaAluno().listaAluno;

        frame.getContentPane().remove(rootMainPanel);
        rootMainPanel = rootListaAlunoPanel;
        frame.getContentPane().add(rootListaAlunoPanel);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }

    public static void mostraListaTurma(){
        JPanel rootListaTurmaPanel = new ListaTurmas().listaTurmas;

        frame.getContentPane().remove(rootMainPanel);
        rootMainPanel = rootListaTurmaPanel;
        frame.getContentPane().add(rootListaTurmaPanel);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }

    public static void mostraBuscaProf(){
        JPanel rootBuscaProfPanel = new BuscaProf().buscaProf;

        frame.getContentPane().remove(rootMainPanel);
        rootMainPanel = rootBuscaProfPanel;
        frame.getContentPane().add(rootBuscaProfPanel);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }

    public static void mostraBuscaAluno(){
        JPanel rootBuscaAlunoPanel = new BuscaAluno().buscaAluno;

        frame.getContentPane().remove(rootMainPanel);
        rootMainPanel = rootBuscaAlunoPanel;
        frame.getContentPane().add(rootBuscaAlunoPanel);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }

    public static void mostraBuscaTurma(){
        JPanel rootBuscaTurmaPanel = new BuscaTurma().buscaTurma;

        frame.getContentPane().remove(rootMainPanel);
        rootMainPanel = rootBuscaTurmaPanel;
        frame.getContentPane().add(rootBuscaTurmaPanel);
        frame.repaint();
        frame.printAll(frame.getGraphics());
    }


}
