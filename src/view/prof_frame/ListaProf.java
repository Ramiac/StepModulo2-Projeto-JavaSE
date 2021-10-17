package view.prof_frame;

import control.erros.ErroCpf;
import control.erros.ErroEmail;
import control.erros.ErroNome;
import control.erros.ErroTelefone;

import javax.swing.*;
import java.io.IOException;

import static control.ExibirListas.exibirListaProfCompletaProf;

class ListaProf {
    JPanel listaProf;
    private JLabel listaProfLabel;

    public ListaProf(){
        try {
            listaProfLabel.setText("<html>" + exibirListaProfCompletaProf()+ "</html>");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ErroNome erroNome) {
            erroNome.printStackTrace();
        } catch (ErroCpf erroCpf) {
            erroCpf.printStackTrace();
        } catch (ErroTelefone erroTelefone) {
            erroTelefone.printStackTrace();
        } catch (ErroEmail erroEmail) {
            erroEmail.printStackTrace();
        }
    }
}
