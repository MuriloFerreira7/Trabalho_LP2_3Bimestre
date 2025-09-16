import java.util.ArrayList;

public class Aparelho {
    private String nome;
    private ArrayList<Musculo> musculosPrincipais;
    private ArrayList<Musculo> musculosSegundarios;
    private String nivelDedificuldade;

    public String getNivelDedificuldade() {
        return nivelDedificuldade;
    }
    public void setNivelDedificuldade(String nivelDedificuldade) {
        this.nivelDedificuldade = nivelDedificuldade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public ArrayList<Musculo> getMusculosPrincipais() {
        return musculosPrincipais;
    }
    public void setMusculosPrincipais(ArrayList<Musculo> musculosPrincipais) {
        this.musculosPrincipais = musculosPrincipais;
    }
    public ArrayList<Musculo> getMusculosSegundarios() {
        return musculosSegundarios;
    }
    public void setMusculosSegundarios(ArrayList<Musculo> musculosSegundarios) {
        this.musculosSegundarios = musculosSegundarios;
    }
}
