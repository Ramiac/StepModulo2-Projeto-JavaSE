package view.aluno_frame;

import javax.swing.*;

import java.io.IOException;

import static control.ExibirListas.exibirTurmasDumAluno;

class ListaTurmas {
    JPanel listaTurmas;
    private JLabel listaTurmasLabel;

    public ListaTurmas(){
        try {
            listaTurmasLabel.setText("<html>" + exibirTurmasDumAluno() + "</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
