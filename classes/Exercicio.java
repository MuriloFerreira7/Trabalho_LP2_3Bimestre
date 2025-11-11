import java.util.ArrayList;

public class Exercicio {

    private String nome;
    private String conjuntoMuscularAlvo;
    private ArrayList<String> musculosPrincipais = new ArrayList<>();
    private ArrayList<String> musculosSecundarios = new ArrayList<>();
    private String nivelDeDificuldade;

    public Exercicio(String nome, String conjuntoMuscularAlvo, ArrayList<String> musculosPrincipais, ArrayList<String> musculosSecundarios, String nivelDeDificuldade) {
        this.nome = nome;
        this.conjuntoMuscularAlvo = conjuntoMuscularAlvo;
        if(musculosPrincipais != null)this.musculosPrincipais = musculosPrincipais;
        if(musculosSecundarios != null) this.musculosSecundarios = musculosSecundarios;
        this.nivelDeDificuldade = nivelDeDificuldade;
    }

    public String getNivelDedificuldade() {
        return nivelDeDificuldade;
    }

    public void setNivelDedificuldade(String nivelDedificuldade) {
        this.nivelDeDificuldade = nivelDedificuldade;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<String> getMusculosPrincipais() {
        return musculosPrincipais;
    }

    public void setMusculosPrincipais(ArrayList<String> musculosPrincipais) {
        this.musculosPrincipais = musculosPrincipais;
    }

    public void addMusculoPrincipal(String musculo) {
        this.musculosPrincipais.add(musculo);
    }

    public void removeMusculoPrincipal(String musculo) {
        for (int i = 0; i < this.musculosPrincipais.size(); i++) {
            if (this.musculosPrincipais.get(i).equals(musculo)) {
                this.musculosPrincipais.remove(i);
                break;
            }
        }
    }

    public ArrayList<String> getMusculosSegundarios() {
        return musculosSecundarios;
    }

    public void setMusculosSecundarios(ArrayList<String> musculosSegundarios) {
        this.musculosSecundarios = musculosSegundarios;
    }

    public void addMusculoSecundario(String musculo) {
        this.musculosSecundarios.add(musculo);
    }

    public void removeMusculoSecundario(String musculo) {
        for (int i = 0; i < this.musculosSecundarios.size(); i++) {
            if(this.musculosSecundarios.get(i).equals(musculo)) {
                this.musculosSecundarios.remove(i);
                break;
            }
        }
    }

    public String getConjuntoMuscularAlvo() {
        return conjuntoMuscularAlvo;
    }

    public void setConjuntoMuscularAlvo(String conjuntoMuscularAlvo) {
        this.conjuntoMuscularAlvo = conjuntoMuscularAlvo;
    }
}
