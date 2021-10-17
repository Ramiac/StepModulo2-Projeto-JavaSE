package model;

public class Log {
    private int id;
    private String tipoUsuario;
    private int idProf, idAluno;
    private boolean root;
    private String tipoQuery, dataHorario, string_query;

    public int getId() {
        return id;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getIdProf() {
        return idProf;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public boolean isRoot() {
        return root;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }

    public String getTipoQuery() {
        return tipoQuery;
    }

    public void setTipoQuery(String tipoQuery) {
        this.tipoQuery = tipoQuery;
    }

    public String getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(String dataHorario) {
        this.dataHorario = dataHorario;
    }

    public String getString_query() {
        return string_query;
    }

    public void setString_query(String string_query) {
        this.string_query = string_query;
    }
}
