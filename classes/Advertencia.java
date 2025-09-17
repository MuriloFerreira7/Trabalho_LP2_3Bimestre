package classes;

public class Advertencia {

    private String motivo;
    private String penalidade;

    public Advertencia(String motivo, String penalidade) {
        this.motivo = motivo;
        this.penalidade = penalidade;
    }

    public String getPenalidade() {
        return penalidade;
    }

    public void setPenalidade(String penalidade) {
        this.penalidade = penalidade;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
