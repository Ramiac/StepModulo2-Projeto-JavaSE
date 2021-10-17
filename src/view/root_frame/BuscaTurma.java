package view.root_frame;

import control.erros.ErroCpf;
import control.erros.ErroEmail;
import control.erros.ErroNome;
import control.erros.ErroTelefone;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import static control.Buscas.rootBuscaAluno;
import static control.Buscas.rootBuscaTurma;

class BuscaTurma {
    JPanel buscaTurma;
    private JTextField buscaField;
    private JButton BuscaButton;
    private JLabel resultLabel;

    public BuscaTurma() {
        BuscaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    resultLabel.setText("<html>" + rootBuscaTurma(buscaField.getText()) + "</html>");
                } catch (IOException | SQLException ioException) {
                    ioException.printStackTrace();
                } catch (ErroNome erroNome) {
                    erroNome.printStackTrace();
                } catch (ErroTelefone erroTelefone) {
                    erroTelefone.printStackTrace();
                } catch (ErroEmail erroEmail) {
                    erroEmail.printStackTrace();
                } catch (ErroCpf erroCpf) {
                    erroCpf.printStackTrace();
                }

            }
        });
    }
}
