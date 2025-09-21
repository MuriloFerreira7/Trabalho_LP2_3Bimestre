package classes;

public class Advertencia {

    private int id;
    private String motivo;
    private String penalidade;
    private String data;

    public Advertencia(int id, String motivo, String penalidade, String data) {
        this.id = id;
        this.motivo = motivo;
        this.penalidade = penalidade;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
