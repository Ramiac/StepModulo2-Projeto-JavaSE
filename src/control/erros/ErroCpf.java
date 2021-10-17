package control.erros;

public class ErroCpf extends Exception{
    @Override
    public String getMessage(){
        return "Erro CPF: somente 11 números";
    }
}
