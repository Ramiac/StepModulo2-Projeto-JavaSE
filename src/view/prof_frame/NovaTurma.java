package view.prof_frame;

import control.erros.ErroNome;
import control.servicos.Conexao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import static control.Cadastros.cadastraTurmas;
import static control.CriaLogs.novoLogProf;
import static control.servicos.CriaDat.listaCompletaTurmas;
import static control.servicos.Exista.isTurmaExisteOuAtiva;

class NovaTurma {
    JPanel novaTurma;
    private JTextField nomeTextField;
    private JButton cadastraButton;
    private JComboBox diaSemaComboBox;
    private JComboBox horarioComboBox;
    private JLabel validaCadastLabel;

    public NovaTurma() {
        cadastraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!isTurmaExisteOuAtiva(nomeTextField.getText())) {
                        cadastraTurmas(
                                nomeTextField.getText(),
                                (String) diaSemaComboBox.getSelectedItem(),
                                (String) horarioComboBox.getSelectedItem()

                        );
                        validaCadastLabel.setText("Sucesso de cadastro");
                        cadastraButton.setEnabled(false);

                        novoLogProf("INSERT",
                                "cadastraTurmas: " +
                                        nomeTextField.getText() + ", " +
                                        diaSemaComboBox.getSelectedItem() + ", " +
                                        horarioComboBox.getSelectedItem()
                        );

                        Conexao c = new Conexao();
                        listaCompletaTurmas(c);
                        c.close();
                    } else validaCadastLabel.setText("Essa turma já existe no cadastro.");
                } catch (SQLException | IOException throwables) {
                    throwables.printStackTrace();
                } catch (ErroNome erroNome) {
                    validaCadastLabel.setText(
                            erroNome.getMessage()
                    );
                }
            }
        });
    }
}
