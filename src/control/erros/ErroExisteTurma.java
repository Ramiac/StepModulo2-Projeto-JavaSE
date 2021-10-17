package control.erros;

public class ErroExisteTurma extends Exception{
    @Override
    public String getMessage() {
        return "Erro: Essa turma não está cadastrada no sistema ou ta desativada";
    }
}
