import java.util.ArrayList;

public class Funcionario extends Pessoa{
    private String areaAtuacao;
    private String salario;
    private ArrayList<Advertencia> advertencias;

    public ArrayList<Advertencia> getAdvertencias() {
        return advertencias;
    }
    public void setAdvertencias(ArrayList<Advertencia> advertencias) {
        this.advertencias = advertencias;
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
}
