package model;

import control.erros.*;
import control.servicos.Valida;

public abstract class Pessoa {
    public int id;
    String usuario, senha, nome, cpf, telefone, email;
    boolean ativo = true;

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) throws ErroUsuario {
        if(Valida.usuarioIsValid(usuario))
        this.usuario = usuario;
        else throw new ErroUsuario();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws ErroSenha {
        if (Valida.senhaIsValid(senha))
        this.senha = senha;
        else throw new ErroSenha();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ErroNome {
        if (Valida.nomeIsValid(nome))
        this.nome = nome;
        else throw new ErroNome();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws ErroCpf {
        if (Valida.cpfIsValid(cpf))
        this.cpf = cpf;
        else throw new ErroCpf();
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws ErroTelefone {
        if(Valida.telefoneIsValid(telefone))
        this.telefone = telefone;
        else throw new ErroTelefone();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws ErroEmail {
        if (Valida.emailIsValid(email))
        this.email = email;
        else throw new ErroEmail();
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
