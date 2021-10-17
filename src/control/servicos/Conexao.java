package control.servicos;

import java.sql.*;

public class Conexao {
    private final Connection CONEXAO;

    public Conexao() throws SQLException{
        this.CONEXAO = DriverManager.getConnection(
                "jdbc:postgresql:PROJETO_UNIFICADO-SGE",
                "postgres",
                "admin"
        );
    }

    public void close() throws SQLException{
        CONEXAO.close();
    }

    public void update(String comando) throws SQLException{
        Statement st = CONEXAO.createStatement();
        st.executeUpdate(comando);
    }

    public void query(String comando) throws SQLException{
        Statement st = CONEXAO.createStatement();
        st.executeQuery(comando);
    }
    
    public void updateAtivoFalse (String table, String nome) throws SQLException {
        Statement st = CONEXAO.createStatement();

        String sql = "UPDATE " + table + " SET ativo = false WHERE nome = '" + nome + "';";

        st.executeUpdate(sql);
    }

    public int querySelectCount(String table) throws SQLException {
        int id;

        Statement st = CONEXAO.createStatement();

        String sql = "select COUNT (*) FROM " + table + ";";

        ResultSet resultado = st.executeQuery(sql);
        resultado.next();

        id = resultado.getInt("count");

        resultado.close();

        return id;
    }

    public ResultSet querySelectAll (String table) throws SQLException{
        Statement st = CONEXAO.createStatement();

        String sql = "select * from " + table + ";";

        return st.executeQuery(sql);
    }

    public ResultSet querySelectIdUsuario (String usuario, String table) throws SQLException{
        Statement st = CONEXAO.createStatement();

        String sql = "select id from " + table + " where usuario = '" + usuario + "';";

        return st.executeQuery(sql);

    }

    public ResultSet querySelectAllAtivos (String table) throws SQLException{
        Statement st = CONEXAO.createStatement();

        String sql = "Select * from " + table + " where ativo = true;";

        return st.executeQuery(sql);
    }

    public ResultSet queryUsuarioSenha (String table) throws SQLException{
        Statement st = CONEXAO.createStatement();

        String sql = "select usuario, senha, ativo from " + table + ";";

        return st.executeQuery(sql);
    }

    public ResultSet querySelectJoinMatricul_aluno () throws SQLException{
        Statement st = CONEXAO.createStatement();

        String sql = "select alunos.nome, turmas.nome, alunos.cpf, alunos.telefone, alunos.email, " +
                "turmas.nome, turmas.dia_semana, turmas.ativo, turmas.horario" +
                " from matricul_aluno" +
                " join alunos" +
                " on id_aluno = alunos.id" +
                " join turmas" +
                " on id_turma = turmas.id;";

        return st.executeQuery(sql);
    }

    public ResultSet querySelectJoinMatricul_prof () throws SQLException{
        Statement st = CONEXAO.createStatement();

        String sql = "select professores.nome, turmas.nome, turmas.dia_semana, turmas.ativo, turmas.horario," +
                "professores.cpf, professores.telefone, professores.email" +
                " from matricul_prof" +
                " join professores" +
                " on id_prof = professores.id" +
                " join turmas" +
                " on id_turma = turmas.id;";

        return st.executeQuery(sql);
    }
}
