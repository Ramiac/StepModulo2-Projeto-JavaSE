package view.root_frame;

import control.erros.*;
import control.servicos.Conexao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import static control.Cadastros.cadastraAluno;
import static control.CriaLogs.novoLogRoot;
import static control.servicos.CriaDat.listaCompletaAlunos;
import static control.servicos.Exista.isAlunoExisteOuAtivo;

class NovoAluno {
    JPanel novoAluno;
    private JTextField nomeTextField;
    private JTextField usuarioTextField;
    private JTextField cpfTextField;
    private JTextField telefoneTextField;
    private JTextField senhaTextField;
    private JTextField emailTextField;
    private JButton cadastraButton;
    private JLabel validaCadastLabel;

    public NovoAluno() {
        cadastraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!isAlunoExisteOuAtivo(nomeTextField.getText())) {
                        cadastraAluno(
                                nomeTextField.getText(),
                                usuarioTextField.getText(),
                                senhaTextField.getText(),
                                cpfTextField.getText(),
                                telefoneTextField.getText(),
                                emailTextField.getText()
                        );
                        validaCadastLabel.setText("Sucesso de cadastro");
                        cadastraButton.setEnabled(false);

                        novoLogRoot("INSERT, ",
                                "cadastraAluno: " +
                                        nomeTextField.getText()
                                );

                        Conexao c = new Conexao();
                        listaCompletaAlunos(c);
                        c.close();
                    }else validaCadastLabel.setText("Esse aluno já existe no cadastro.");

                } catch (SQLException | IOException throwables) {
                    throwables.printStackTrace();
                } catch (ErroNome erroNome) {
                    validaCadastLabel.setText(
                            erroNome.getMessage()
                    );
                } catch (ErroUsuario erroUsuario) {
                    validaCadastLabel.setText(
                            erroUsuario.getMessage()
                    );
                } catch (ErroSenha erroSenha) {
                    validaCadastLabel.setText(
                            erroSenha.getMessage()
                    );
                } catch (ErroCpf erroCpf) {
                    validaCadastLabel.setText(
                            erroCpf.getMessage()
                    );
                } catch (ErroTelefone erroTelefone) {
                    validaCadastLabel.setText(
                            erroTelefone.getMessage()
                    );
                } catch (ErroEmail erroEmail) {
                    validaCadastLabel.setText(
                            erroEmail.getMessage()
                    );
                }
            }
        });
    }
}
