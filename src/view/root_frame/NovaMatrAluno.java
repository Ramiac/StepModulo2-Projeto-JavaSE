package view.root_frame;

import control.erros.ErroExisteAluno;
import control.erros.ErroExisteTurma;
import control.servicos.Conexao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import static control.CriaLogs.novoLogRoot;
import static control.Matriculas.cadastraMatrAluno;
import static control.servicos.CriaDat.listaCompletaMatricul_aluno;

class NovaMatrAluno {
    JPanel novaMatrAluno;
    private JTextField nomeAlunoTextField1;
    private JTextField nomeTurmaTextField;
    private JButton cadastraButton;
    private JLabel validaCadastraLabel;

    public NovaMatrAluno() {
        cadastraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cadastraMatrAluno(nomeAlunoTextField1.getText(), nomeTurmaTextField.getText());
                    validaCadastraLabel.setText("Cadastro com sucesso.");
                    cadastraButton.setEnabled(false);

                    novoLogRoot("INSERT",
                            "cadastraMatrAluno: " +
                                    nomeAlunoTextField1.getText() + ", " +
                                    nomeTurmaTextField.getText()
                    );

                    Conexao c = new Conexao();
                    listaCompletaMatricul_aluno(c);
                    c.close();
                } catch (SQLException | IOException throwables) {
                    throwables.printStackTrace();
                } catch (ErroExisteAluno erroExisteAluno) {
                    validaCadastraLabel.setText(erroExisteAluno.getMessage());
                } catch (ErroExisteTurma erroExisteTurma) {
                    validaCadastraLabel.setText(erroExisteTurma.getMessage());
                }
            }
        });
    }
}
