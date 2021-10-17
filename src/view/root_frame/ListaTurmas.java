package view.root_frame;

import control.erros.ErroNome;

import javax.swing.*;

import java.io.IOException;

import static control.ExibirListas.exibirListaCompletaTurmas;

class ListaTurmas {
    JPanel listaTurmas;
    private JLabel listaTurmasLabel;

    public ListaTurmas(){
        try {
            listaTurmasLabel.setText("<html>" + exibirListaCompletaTurmas() + "</html>");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ErroNome erroNome) {
            erroNome.printStackTrace();
        }
    }
}
