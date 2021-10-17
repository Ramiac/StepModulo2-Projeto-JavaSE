package view.aluno_frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import static control.Buscas.alunoBuscaTurma;
import static control.Buscas.profBuscaTurma;

class BuscaTurma {
    JPanel buscaTurma;
    private JTextField buscaField;
    private JLabel resultLabel;
    private JButton buscaButton;

    public BuscaTurma() {
        buscaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    resultLabel.setText("<html>" + alunoBuscaTurma(buscaField.getText()) + "</html>");
                } catch (IOException | SQLException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }
}
