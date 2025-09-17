package classes;

import java.util.ArrayList;

public class Funcionario extends Pessoa {

    private String areaAtuacao;
    private String salario;
    private ArrayList<Advertencia> advertencias;

    public Funcionario(String nome, String cpf, String rg, String email, String telefone, String dataDeNascimento, String areaAtuacao, String salario) {
        super(nome, cpf, rg, email, telefone, dataDeNascimento);
        setAreaAtuacao(areaAtuacao);
        setSalario(salario);
    }

    public ArrayList<Advertencia> getAdvertencias() {
        return advertencias;
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

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    private void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getSalario() {
        return salario;
    }

    private void setSalario(String salario) {
        this.salario = salario;
    }
}
