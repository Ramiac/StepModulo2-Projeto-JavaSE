package view.root_frame;

import control.servicos.Conexao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import static control.CriaLogs.novoLogRoot;
import static control.Exclusoes.excluiProf;
import static control.servicos.CriaDat.listaCompletaProf;
import static control.servicos.Exista.isProfExisteOuAtivo;

public class ExclProf {
    JPanel exclProfPanel;
    private JTextField nomeProfField;
    private JButton excluiButton;
    private JButton button2;
    private JLabel validaExluisaoLabel;


    public ExclProf() {

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (isProfExisteOuAtivo(nomeProfField.getText())){
                        validaExluisaoLabel.setText("<html>Deseja mesmo excluir <b>" + nomeProfField.getText() +
                                "</b> da lista de professores?</html>");
                        excluiButton.setEnabled(true);
                        nomeProfField.setEnabled(false);
                    }else{
                        validaExluisaoLabel.setText("<html>O professor <b>" + nomeProfField.getText() +
                                "</b> não foi achado na lista de professores?</html>");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        excluiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeProf =  nomeProfField.getText().toLowerCase();
                try {
                    excluiProf(nomeProf);
                    validaExluisaoLabel.setText("<html>O professor <b>" + nomeProfField.getText() +
                            "</b> excluído da lista de professores com sucesso</html>");
                    novoLogRoot("UPDATE", "excluiProf: " + nomeProf);
                    Conexao c = new Conexao();
                    listaCompletaProf(c);
                    c.close();
                } catch (SQLException | IOException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
}
