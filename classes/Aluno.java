package classes;

import java.util.ArrayList;

public class Aluno extends Pessoa {

    private String objetivo;
    private String necessidadeEspecial;
    private ArrayList<AvaliacaoFisica> avaliacoesFisicas;
    private ArrayList<Advertencia> advertencias;

    public Aluno(String nome, String cpf, String rg, String email, String telefone, String dataDeNascimento, String objetivo, String necessidadeEspecial, ArrayList<AvaliacaoFisica> avaliacoesFisicas, ArrayList<Advertencia> advertencias) {
        super(nome, cpf, rg, email, telefone, dataDeNascimento);
        this.objetivo = objetivo;
        this.necessidadeEspecial = necessidadeEspecial;
        this.advertencias = advertencias;
    }

    public void addAdvertencias(Advertencia advertencia) {
        this.advertencias.add(advertencia);
    }

    public void removeAdvertencias(Advertencia advertencia) {
        for (int i = 0; i < this.advertencias.size(); i++) {
            if (this.advertencias.get(i) == advertencia) {
                this.advertencias.remove(i);
                break;
            }
        }
    }

    public void addAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
        this.avaliacoesFisicas.add(avaliacaoFisica);
    }

    public void removeAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
        for (int i = 0; i < this.advertencias.size(); i++) {
            if (this.avaliacoesFisicas.get(i) == avaliacaoFisica) {
                this.avaliacoesFisicas.remove(i);
                break;
            }
        }
    }

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

    public ArrayList<AvaliacaoFisica> getAvaliacoesFisicas() {
        return avaliacoesFisicas;
    }

    public void setAvaliacoesFisicas(ArrayList<AvaliacaoFisica> avaliacoesFisicas) {
        this.avaliacoesFisicas = avaliacoesFisicas;
    }

    public ArrayList<Advertencia> getAdvertencias() {
        return advertencias;
    }

    public void setAdvertencias(ArrayList<Advertencia> advertencias) {
        this.advertencias = advertencias;
    }
}
