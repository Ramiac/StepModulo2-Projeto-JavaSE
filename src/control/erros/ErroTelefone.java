package control.erros;

public class ErroTelefone extends Exception{
    @Override
    public String getMessage() {
        return "Erro Telefone: Máximo 13 números";
    }
}