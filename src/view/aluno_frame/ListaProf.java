package view.aluno_frame;

import javax.swing.*;

import java.io.IOException;

import static control.ExibirListas.exibirProfsDumAluno;

class ListaProf {
    JPanel listaProf;
    private JLabel listaProfessoresLabel;

    public ListaProf(){
        try {
            listaProfessoresLabel.setText("<html>" + exibirProfsDumAluno() + "</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
