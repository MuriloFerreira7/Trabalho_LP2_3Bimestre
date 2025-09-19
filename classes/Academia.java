package classes;

import java.util.ArrayList;

public class Academia {

    private String nome;
    private String endereco;
    private String horarioDeFuncionamento;
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<Area> Areas = new ArrayList<>();

    public Academia(String nome, String endereco, String horarioDeFuncionamento, ArrayList<Aluno> alunos, ArrayList<Funcionario> funcionarios, ArrayList<Area> areas) {
        this.nome = nome;
        this.endereco = endereco;
        this.horarioDeFuncionamento = horarioDeFuncionamento;
        this.alunos = alunos;
        this.funcionarios = funcionarios;
        this.Areas = areas;
    }

    public ArrayList<Area> getAparelhos() {
        return Areas;
    }

    public void setAparelhos(ArrayList<Area> aparelhos) {
        this.Areas = aparelhos;
    }

    public void addArea(Area aparelho) {
        this.Areas.add(aparelho);
    }

    public void removeArea(Area area) {
        for (int i = 0; i < this.Areas.size(); i++) {
            if (this.Areas.get(i) == area) {
                this.Areas.remove(i);
                break;
            }
        }
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void addFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public void removeFuncionario(Funcionario funcionario) {
        for (int i = 0; i < this.funcionarios.size(); i++) {
            if (this.funcionarios.get(i) == funcionario) {
                this.funcionarios.remove(i);
                break;
            }
        }
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void removeAluno(Aluno aluno) {
        for (int i = 0; i < this.alunos.size(); i++) {
            if (this.alunos.get(i) == aluno) {
                this.alunos.remove(i);
                break;
            }
        }
    }

    public Funcionario buscarFuncionarioPorNome(String nome) {
        for (int i = 0; i < this.funcionarios.size(); i++) {
            if (this.funcionarios.get(i).getNome().equals(nome)) return this.funcionarios.get(i);
        }
        return null;
    }

    public Aluno buscarAlunoPorNome(String nome) {
        for (int i = 0; i < this.alunos.size(); i++) {
            if(this.funcionarios.get(i).getNome().equals(nome)) return this.alunos.get(i);
        }
        return null;
    }

    public Area buscarAreaPorNome(String nome) {
        for (int i = 0; i < this.Areas.size(); i++) {
            if (this.Areas.get(i).getNome().equals(nome)) return this.Areas.get(i); 
        }
        return null;
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
