package control.erros;

public class ErroSenha extends Exception{
    @Override
    public String getMessage() {
        return "Erro Senha: Máximo 20 caráteres";
    }
}
