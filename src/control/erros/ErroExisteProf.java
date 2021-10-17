package control.erros;

public class ErroExisteProf extends Exception{
    @Override
    public String getMessage() {
        return "Erro: Esse Prof não é cadastrado no sistema ou está desativado";
    }
}
