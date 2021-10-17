package view.prof_frame;

import javax.swing.*;
import java.io.IOException;

import static control.ExibirListas.exibirAlunosDumProf;

class ListaAluno {
    JPanel listaAluno;
    private JLabel listaAlunosLabel;

    public ListaAluno(){

        try {
            listaAlunosLabel.setText("<html>" + exibirAlunosDumProf() + "</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
