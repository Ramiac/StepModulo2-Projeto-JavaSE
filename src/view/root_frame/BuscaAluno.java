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
import static control.Buscas.rootBuscaProfessor;

class BuscaAluno {
    JPanel buscaAluno;
    private JTextField buscaField;
    private JButton BuscaButton;
    private JLabel resultLabel;

    public BuscaAluno() {
        BuscaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    resultLabel.setText("<html>" + rootBuscaAluno(buscaField.getText()) + "</html>");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ErroNome erroNome) {
                    erroNome.printStackTrace();
                } catch (ErroCpf erroCpf) {
                    erroCpf.printStackTrace();
                } catch (ErroTelefone erroTelefone) {
                    erroTelefone.printStackTrace();
                } catch (ErroEmail erroEmail) {
                    erroEmail.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
}
