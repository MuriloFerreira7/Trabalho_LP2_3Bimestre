package classes;

import java.util.ArrayList;

public class Aparelho {

    private String nome;
    private ArrayList<String> musculosPrincipais;
    private ArrayList<String> musculosSecundarios;
    private String nivelDeDificuldade;

    public Aparelho(String nome, ArrayList<String> musculosPrincipais, ArrayList<String> musculosSecundarios, String nivelDeDificuldade) {
        this.nome = nome;
        this.musculosPrincipais = musculosPrincipais;
        this.musculosSecundarios = musculosSecundarios;
        this.nivelDeDificuldade = nivelDeDificuldade;
    }

    public String getNivelDedificuldade() {
        return nivelDeDificuldade;
    }

    public void setNivelDedificuldade(String nivelDedificuldade) {
        this.nivelDeDificuldade = nivelDedificuldade;
    }

    public String getNome() {
        return nome;
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

    public ArrayList<String> getMusculosSegundarios() {
        return musculosSecundarios;
    }

    public void setMusculosSegundarios(ArrayList<String> musculosSegundarios) {
        this.musculosSecundarios = musculosSegundarios;
    }
}
