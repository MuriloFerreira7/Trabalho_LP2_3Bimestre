public class AvaliacaoFisica {

    
    //medidas (cm)
    private String bracoEsquerdo;
    private String bracoDireito;
    private String pernaEsquerda;
    private String pernaDireito;
    private String cintura;
    private String abdomen;
    private String busto;
    private String pescoco;
    
    private String gorduraCorporal;//porcentagem
    private String bancoDeWells;//mobilidade(cm)
    
    private String altura;
    private String peso;
    
    private int id;
    
    public AvaliacaoFisica(String bracoEsquerdo, String bracoDireito, String pernaEsquerda, String pernaDireito, String cintura, String abdomen, String busto, String pescoco, String gorduraCorporal, String bancoDeWells, String altura, String peso, int id) {
        this.bracoEsquerdo = bracoEsquerdo;
        this.bracoDireito = bracoDireito;
        this.pernaEsquerda = pernaEsquerda;
        this.pernaDireito = pernaDireito;
        this.cintura = cintura;
        this.abdomen = abdomen;
        this.busto = busto;
        this.pescoco = pescoco;
        this.gorduraCorporal = gorduraCorporal;
        this.bancoDeWells = bancoDeWells;
        this.altura = altura;
        this.peso = peso;
        this.id = id;
    }

    public String getBracoEsquerdo() {
        return bracoEsquerdo;
    }

    public void setBracoEsquerdo(String bracoEsquerdo) {
        this.bracoEsquerdo = bracoEsquerdo;
    }

    public String getBracoDireito() {
        return bracoDireito;
    }

    public void setBracoDireito(String bracoDireito) {
        this.bracoDireito = bracoDireito;
    }

    public String getPernaEsquerda() {
        return pernaEsquerda;
    }

    public void setPernaEsquerda(String pernaEsquerda) {
        this.pernaEsquerda = pernaEsquerda;
    }

    public String getPernaDireito() {
        return pernaDireito;
    }

    public void setPernaDireito(String pernaDireito) {
        this.pernaDireito = pernaDireito;
    }

    public String getCintura() {
        return cintura;
    }

    public void setCintura(String cintura) {
        this.cintura = cintura;
    }

    public String getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(String abdomen) {
        this.abdomen = abdomen;
    }

    public String getBusto() {
        return busto;
    }

    public void setBusto(String busto) {
        this.busto = busto;
    }

    public String getPescoco() {
        return pescoco;
    }

    public void setPescoco(String pescoco) {
        this.pescoco = pescoco;
    }

    public String getGorduraCorporal() {
        return gorduraCorporal;
    }

    public void setGorduraCorporal(String gorduraCorporal) {
        this.gorduraCorporal = gorduraCorporal;
    }

    public String getBancoDeWells() {
        return bancoDeWells;
    }

    public void setBancoDeWells(String bancoDeWells) {
        this.bancoDeWells = bancoDeWells;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
