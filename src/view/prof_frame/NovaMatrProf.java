package view.prof_frame;

import control.erros.ErroExisteProf;
import control.erros.ErroExisteTurma;
import control.servicos.Conexao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import static control.CriaLogs.novoLogProf;
import static control.Matriculas.cadastraMatrProf;
import static control.servicos.CriaDat.listaCompletaMatricul_prof;

class NovaMatrProf {
    JPanel novaMatricProf;
    private JButton cadastraButton;
    private JTextField nomeProfTextField;
    private JTextField nomeTurmaTextField;
    private JLabel validaCadastraLabel;

    public NovaMatrProf() {
        cadastraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cadastraMatrProf(nomeProfTextField.getText(), nomeTurmaTextField.getText());
                    validaCadastraLabel.setText("Cadastro com sucesso.");
                    cadastraButton.setEnabled(false);

                    novoLogProf("INSERT",
                            "cadastraMatrProf: " +
                                    nomeProfTextField.getText() + ", " +
                                    nomeTurmaTextField.getText()
                    );

                    Conexao c = new Conexao();
                    listaCompletaMatricul_prof(c);
                    c.close();
                } catch (SQLException | IOException throwables) {
                    throwables.printStackTrace();
                } catch (ErroExisteProf erroExisteProf) {
                    validaCadastraLabel.setText(erroExisteProf.getMessage());
                } catch (ErroExisteTurma erroExisteTurma) {
                    validaCadastraLabel.setText(erroExisteTurma.getMessage());
                }
            }
        });
    }
}
