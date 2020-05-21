package com.saojose.estudoapi.Model;

import java.util.Date;

public class Funcionario {

    public int funcionarioId;
    public String nome;
    public String cargo;
    public String nascimento;
    public String ativo;
    public String imagem;

    public Funcionario() {
        super();
    }

    public Funcionario(int funcionarioId, String nome, String cargo, String nascimento, String ativo, String imagem) {
        this.funcionarioId = funcionarioId;
        this.nome = nome;
        this.cargo = cargo;
        this.nascimento = nascimento;
        this.ativo = ativo;
        this.imagem = imagem;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
