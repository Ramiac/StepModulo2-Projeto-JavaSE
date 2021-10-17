package control.servicos;

import java.io.File;

public class DeletaDat {

    public static void deletaDat(String tipoUsuario){
        if(tipoUsuario.equals("root")) {
            new File("arquivos\\" + tipoUsuario + ".dat").delete();
            new File("arquivos\\listas\\lista_alunos.dat").delete();
            new File("arquivos\\listas\\lista_prof.dat").delete();
            new File("arquivos\\listas\\lista_turmas.dat").delete();
            new File("arquivos\\listas\\lista_matricul_aluno.dat").delete();
            new File("arquivos\\listas\\lista_matricul_prof.dat").delete();
        }else if(tipoUsuario.equals("prof")){
            new File("arquivos\\" + tipoUsuario + ".dat").delete();
            new File("arquivos\\listas\\lista_prof.dat").delete();
            new File("arquivos\\listas\\lista_matricul_aluno.dat").delete();
            new File("arquivos\\listas\\lista_matricul_prof.dat").delete();
        }else {
            new File("arquivos\\" + tipoUsuario + ".dat").delete();
            new File("arquivos\\listas\\lista_matricul_aluno.dat").delete();
            new File("arquivos\\listas\\lista_matricul_prof.dat").delete();
        }
    }

    public static void deletaDatOnExit(){
        new File("arquivos\\root.dat").deleteOnExit();
        new File("arquivos\\prof.dat").deleteOnExit();
        new File("arquivos\\aluno.dat").deleteOnExit();
        new File("arquivos\\listas\\lista_alunos.dat").deleteOnExit();
        new File("arquivos\\listas\\lista_prof.dat").deleteOnExit();
        new File("arquivos\\listas\\lista_turmas.dat").deleteOnExit();
        new File("arquivos\\listas\\lista_matricul_aluno.dat").deleteOnExit();
        new File("arquivos\\listas\\lista_matricul_prof.dat").deleteOnExit();
    }
}
