package view.root_frame;

import control.servicos.Conexao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

import static control.CriaLogs.novoLogRoot;
import static control.Exclusoes.excluiAluno;
import static control.Exclusoes.excluiProf;
import static control.servicos.CriaDat.listaCompletaAlunos;
import static control.servicos.Exista.isAlunoExisteOuAtivo;
import static control.servicos.Exista.isProfExisteOuAtivo;

public class ExclAluno {
    JPanel exclAluno;
    private JTextField nomeAlunoField;
    private JButton button2;
    private JButton excluiButton;
    private JLabel validaExluisaoLabel;

    public ExclAluno() {
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (isAlunoExisteOuAtivo(nomeAlunoField.getText())){
                        validaExluisaoLabel.setText("<html>Deseja mesmo excluir <b>" + nomeAlunoField.getText() +
                                "</b> da lista de alunos?</html>");
                        excluiButton.setEnabled(true);
                        nomeAlunoField.setEnabled(false);
                    }else{
                        validaExluisaoLabel.setText("<html>O aluno <b>" + nomeAlunoField.getText() +
                                "</b> não foi achado na lista de alunos?</html>");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        excluiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeAluno = nomeAlunoField.getText();
                try {
                    excluiAluno(nomeAluno.toLowerCase());
                    validaExluisaoLabel.setText("<html>O aluno <b>" + nomeAlunoField.getText() +
                            "</b> excluído da lista de alunos com sucesso</html>");
                    novoLogRoot("UPDATE", "excluiAluno: " + nomeAluno.toLowerCase());
                    Conexao c = new Conexao();
                    listaCompletaAlunos(c);
                    c.close();
                } catch (SQLException | IOException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
}
