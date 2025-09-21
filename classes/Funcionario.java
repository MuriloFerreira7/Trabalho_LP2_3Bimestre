package classes;

import java.util.ArrayList;

public class Funcionario extends Pessoa {

    private String areaAtuacao;
    private String salario;
    private ArrayList<Advertencia> advertencias = new ArrayList<>();

    public Funcionario(String nome, String cpf, String rg, String email, String telefone, String dataDeNascimento, String areaAtuacao, String salario, String necessidadeEspecial, ArrayList<Advertencia> advertencias) {
        super(nome, cpf, rg, email, telefone, dataDeNascimento, necessidadeEspecial);
        this.areaAtuacao = areaAtuacao;
        this.salario = salario;
        if(advertencias != null) this.advertencias = advertencias;
    }

    public ArrayList<Advertencia> getAdvertencias() {
        return advertencias;
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

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public void setAdvertencias(ArrayList<Advertencia> advertencias) {
        this.advertencias = advertencias;
    }
}
