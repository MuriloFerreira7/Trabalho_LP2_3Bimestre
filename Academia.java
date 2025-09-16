import java.util.LinkedList;

public class Academia {
    private String nome;
    private String endereco;
    private LinkedList<Aluno> alunos;
    private LinkedList<Funcionario> funcionarios;

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
    
}