package control;

import control.servicos.Conexao;
import model.Log;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CriaLogs {

    public static void novoLogProf(String tipoQuery, String stringQuery) throws SQLException, IOException {
        Log l = new Log();
        Conexao c = new Conexao();

        String usuarioProf;
        int idProf;
        String timeStamp;

        DataInputStream di = new DataInputStream(
                new FileInputStream("arquivos\\prof.dat")
        );
        di.readUTF();
        usuarioProf = di.readUTF();
        di.close();

        ResultSet findId = c.querySelectIdUsuario(usuarioProf, "professores");
        findId.next();
        idProf = findId.getInt("id");
        findId.close();

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter paraPostGres = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        timeStamp = agora.format(paraPostGres);

        l.setTipoUsuario("professor");
        l.setIdProf(idProf);
        l.setTipoQuery(tipoQuery);
        l.setDataHorario(timeStamp);
        l.setString_query(stringQuery);

        c.update("INSERT INTO logs(tipo_usuario, id_prof, tipo_query, string_query, data_horario)" +
                " VALUES(" +
                "'" + l.getTipoUsuario() +
                "', '" + l.getIdProf() +
                "', '" + l.getTipoQuery() +
                "', '" + l.getString_query() +
                "', '" + l.getDataHorario() + "');"
        );


        c.close();

    }

    public static void novoLogAluno(String tipoQuery, String stringQuery) throws SQLException, IOException {
        Log l = new Log();
        Conexao c = new Conexao();

        String usuarioAluno;
        int idAluno;
        String timeStamp;

        DataInputStream di = new DataInputStream(
                new FileInputStream("arquivos\\aluno.dat")
        );
        di.readUTF();
        usuarioAluno = di.readUTF();
        di.close();

        ResultSet findId = c.querySelectIdUsuario(usuarioAluno, "alunos");
        findId.next();
        idAluno = findId.getInt("id");
        findId.close();

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter paraPostGres = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        timeStamp = agora.format(paraPostGres);

        l.setTipoUsuario("aluno");
        l.setIdAluno(idAluno);
        l.setTipoQuery(tipoQuery);
        l.setDataHorario(timeStamp);
        l.setString_query(stringQuery);

        c.update("INSERT INTO logs(tipo_usuario, id_aluno, tipo_query, string_query, data_horario)" +
                " VALUES(" +
                "'" + l.getTipoUsuario() +
                "', '" + l.getIdAluno() +
                "', '" + l.getTipoQuery() +
                "', '" + l.getString_query() +
                "', '" + l.getDataHorario() + "');"
        );

        c.close();

    }

    public static void novoLogRoot(String tipoQuery, String stringQuery) throws SQLException {
        Log l = new Log();
        Conexao c = new Conexao();
        String timeStamp;

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter paraPostGres = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        timeStamp = agora.format(paraPostGres);

        l.setTipoUsuario("root");
        l.setRoot(true);
        l.setTipoQuery(tipoQuery);
        l.setDataHorario(timeStamp);
        l.setString_query(stringQuery);

        c.update("INSERT INTO logs(tipo_usuario, root, tipo_query, string_query, data_horario)" +
                " VALUES(" +
                "'" + l.getTipoUsuario() +
                "', '" + l.isRoot() +
                "', '" + l.getTipoQuery() +
                "', '" + l.getString_query() +
                "', '" + l.getDataHorario() + "');"
        );

        c.close();

    }
}
