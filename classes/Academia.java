package classes;

import java.util.LinkedList;

public class Academia {

    private String nome;
    private String endereco;
    private String horarioDeFuncionamento;
    private LinkedList<Aluno> alunos;
    private LinkedList<Funcionario> funcionarios;
    private LinkedList<Aparelho> aparelhos;

    public Academia(String nome, String endereco, String horarioDeFuncionamento, LinkedList<Aluno> alunos, LinkedList<Funcionario> funcionarios, LinkedList<Aparelho> aparelhos) {
        this.nome = nome;
        this.endereco = endereco;
        this.horarioDeFuncionamento = horarioDeFuncionamento;
        this.alunos = alunos;
        this.funcionarios = funcionarios;
        this.aparelhos = aparelhos;
    }

    public LinkedList<Aparelho> getAparelhos() {
        return aparelhos;
    }

    public void setAparelhos(LinkedList<Aparelho> aparelhos) {
        this.aparelhos = aparelhos;
    }

    public LinkedList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(LinkedList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public LinkedList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(LinkedList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String local) {
        this.endereco = local;
    }

    public String getHorarioDeFuncionamento() {
        return horarioDeFuncionamento;
    }

    public void setHorarioDeFuncionamento(String horarioDeFuncionamento) {
        this.horarioDeFuncionamento = horarioDeFuncionamento;
    }

}
