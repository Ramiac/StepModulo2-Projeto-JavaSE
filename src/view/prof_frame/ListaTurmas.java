package view.prof_frame;

import control.erros.ErroNome;

import javax.swing.*;
import java.io.IOException;

import static control.ExibirListas.exibirListaTurmasDumProf;

class ListaTurmas {
    JPanel listaTurmas;
    private JLabel listaTurmasLabel;

    public ListaTurmas(){
        try {
            listaTurmasLabel.setText("<html>" + exibirListaTurmasDumProf() + "</html>");
        } catch (IOException | ErroNome e) {
            e.printStackTrace();
        }
    }
}
