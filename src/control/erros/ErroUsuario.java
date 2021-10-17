package control.erros;

public class ErroUsuario extends Exception{
    @Override
    public String getMessage() {
        return "Erro Usuário: Máximo 40 caráteres";
    }
}
