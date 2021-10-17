package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import static control.servicos.CriaDat.*;
import static control.servicos.LoginValida.*;
import static view.aluno_frame.MainFrameAluno.mainFrameAluno;
import static view.prof_frame.MainFrameProf.mainFrameProf;
import static view.root_frame.MainFrameRoot.mainFrameRoot;

public class Login {
    private static JFrame frame;
    private JPanel loginPanel;
    private JLabel tituloLabel;
    private JLabel tipoUsuarioLabel;
    private JComboBox tipoUsuarioCombobox;
    private JButton validaButton;
    private JTextField usuarioField;
    private JPasswordField senhaField;
    private JLabel usuarioLabel;
    private JLabel senhaLebal;
    private JLabel validaLabel;

    public Login() {
        validaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoUsuario = (String) tipoUsuarioCombobox.getSelectedItem();
                String usuario = usuarioField.getText();
                String passText = new String(senhaField.getPassword());

                if (tipoUsuario.equals("Root")) {
                    if (usuario.equals("root") && passText.equals("pass123")) {
                        frame.setVisible(false);
                        try {
                            criaDat(tipoUsuario, "root", "pass123");
                        } catch (IOException | SQLException eRoot) {
                            eRoot.printStackTrace();
                        }
                        mainFrameRoot();
                    }
                    else {
                        validaLabel.setText("Usuário ou senha invalidá.");
                        senhaField.setText("");
                        usuarioField.setText("");
                    }

                }
                else if (tipoUsuario.equals("Professor")) {
                    if (isProfLoginValido(usuario, passText)) {
                        frame.setVisible(false);
                        try {
                            criaDat(tipoUsuario, usuario, passText);
                        } catch (IOException | SQLException eProf) {
                            eProf.printStackTrace();
                        }
                        mainFrameProf();
                    }
                    else {
                        validaLabel.setText("Usuário ou senha invalidá.");
                        senhaField.setText("");
                        usuarioField.setText("");
                    }
                }
                else {
                    if (isAlunoLoginValido(usuarioField.getText(), passText)) {
                        frame.setVisible(false);
                        try {
                            criaDat(tipoUsuario, usuario, passText);
                        } catch (IOException | SQLException eAluno) {
                            eAluno.printStackTrace();
                        }
                        mainFrameAluno();
                    }
                    else {
                        validaLabel.setText("Usuário ou senha invalidá.");
                        senhaField.setText("");
                        usuarioField.setText("");
                    }
                }

            }
        });
    }

    public static void login(){
        frame = new JFrame("Login - Sistema de gestão escolar");

        frame.setContentPane(new Login().loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
