import java.util.ArrayList;

public class Aluno extends Pessoa{
    private String objetivo;
    private String necessidadeEspecial;
    private String dataDeNascimento;
    private ArrayList<AvaliacaoFisica> avaliacoesFisicas;

    public String getObjetivo() {
        return objetivo;
    }
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    public String getNecessidadeEspecial() {
        return necessidadeEspecial;
    }
    public void setNecessidadeEspecial(String necessidadeEspecial) {
        this.necessidadeEspecial = necessidadeEspecial;
    }
    public String getDataDeNascimento() {
        return dataDeNascimento;
    }
    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
    public ArrayList<AvaliacaoFisica> getAvaliacoesFisicas() {
        return avaliacoesFisicas;
    }
    public void setAvaliacoesFisicas(ArrayList<AvaliacaoFisica> avaliacoesFisicas) {
        this.avaliacoesFisicas = avaliacoesFisicas;
    }
}
