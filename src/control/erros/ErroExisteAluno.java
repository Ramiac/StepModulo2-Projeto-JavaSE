package control.erros;

public class ErroExisteAluno extends Exception{
    @Override
    public String getMessage() {
        return "Esse Aluno não está cadastrado no sistema ou está desativado.";
    }
}
