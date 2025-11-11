
import java.util.ArrayList;

public class Aluno extends Pessoa {

    private String objetivo;
    private ArrayList<AvaliacaoFisica> avaliacoesFisicas = new ArrayList<>();
    private ArrayList<Advertencia> advertencias = new ArrayList<>();

    public Aluno(String nome, String cpf, String rg, String email, String telefone, String dataDeNascimento, String objetivo, String necessidadeEspecial) {
        super(nome, cpf, rg, email, telefone, dataDeNascimento, necessidadeEspecial);
        this.objetivo = objetivo;
    }

    public void addAdvertencia(Advertencia advertencia) {
        this.advertencias.add(advertencia);
    }

    public void removeAdvertencias(int id) {
        for (int i = 0; i < this.advertencias.size(); i++) {
            if (this.advertencias.get(i).getId() == id) {
                this.advertencias.remove(i);
                break;
            }
        }
    }

    public Advertencia buscarAdvertenciaPorId(int id) {
        for(int i = 0; i < advertencias.size(); i++) {
            if (this.advertencias.get(i).getId() == id) return this.advertencias.get(i);
        }
        return null;
    }

    public void addAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
        this.avaliacoesFisicas.add(avaliacaoFisica);
    }

    public void removeAvaliacaoFisica(int id) {
        for (int i = 0; i < this.advertencias.size(); i++) {
            if (this.avaliacoesFisicas.get(i).getId() == id) {
                this.avaliacoesFisicas.remove(i);
                break;
            }
        }
    }

    public AvaliacaoFisica buscarAvaliacaoFisicaPorId(int id) {
        for(int i = 0; i < avaliacoesFisicas.size(); i++) {
            if (avaliacoesFisicas.get(i).getId() == id) return avaliacoesFisicas.get(i);
        }
        return null;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
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
