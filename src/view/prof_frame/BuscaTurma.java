package view.prof_frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import static control.Buscas.profBuscaTurma;
import static control.Buscas.rootBuscaProfessor;

class BuscaTurma {
    JPanel buscaTurma;
    private JTextField buscaField;
    private JButton buscaButton;
    private JLabel resultLabel;

    public BuscaTurma() {
        buscaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    resultLabel.setText("<html>" + profBuscaTurma(buscaField.getText()) + "</html>");
                } catch (IOException | SQLException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }
}
