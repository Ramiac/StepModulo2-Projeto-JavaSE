package control.erros;

public class ErroEmail extends Exception{
    @Override
    public String getMessage() {
        return "Erro Email: Email inválido";
    }
}
