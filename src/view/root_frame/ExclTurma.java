package view.root_frame;

import control.servicos.Conexao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import static control.CriaLogs.novoLogRoot;
import static control.Exclusoes.excluiTurma;
import static control.servicos.CriaDat.listaCompletaTurmas;
import static control.servicos.Exista.isTurmaExisteOuAtiva;

public class ExclTurma {
    JPanel exclTurma;
    private JTextField nomeTurmaField;
    private JButton button2;
    private JButton excluiButton;
    private JLabel validaExluisaoLabel;

    public ExclTurma() {
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (isTurmaExisteOuAtiva(nomeTurmaField.getText())){
                        validaExluisaoLabel.setText("<html>Deseja mesmo excluir <b>" + nomeTurmaField.getText() +
                                "</b> da lista de turmas?</html>");
                        excluiButton.setEnabled(true);
                        nomeTurmaField.setEnabled(false);
                    }else{
                        validaExluisaoLabel.setText("<html>A turma <b>" + nomeTurmaField.getText() +
                                "</b> não foi achada na lista de turmas?</html>");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        excluiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeTurma =  nomeTurmaField.getText().toLowerCase();
                try {
                    excluiTurma(nomeTurma);
                    validaExluisaoLabel.setText("<html>A turma <b>" + nomeTurmaField.getText() +
                            "</b> excluída da lista de turmas com sucesso</html>");
                    novoLogRoot("UPDATE", "excluiTurma: " + nomeTurma);
                    Conexao c = new Conexao();
                    listaCompletaTurmas(c);
                    c.close();
                } catch (SQLException | IOException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
}
