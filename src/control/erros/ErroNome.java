package control.erros;

public class ErroNome extends Exception{
    @Override
    public String getMessage() {
        return "Erro Nome: Máximo 40 caráteres";
    }
}
