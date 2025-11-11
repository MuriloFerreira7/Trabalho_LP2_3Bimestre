
import java.util.ArrayList;

public class Area {
    private String nome;
    private ArrayList<Exercicio> exercicios = new ArrayList<>();
    
    public Area(String nome, ArrayList<Exercicio> exercicios) {
        this.nome = nome; 
        if(exercicios != null) this.exercicios = exercicios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(ArrayList<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    public void addExercicio(Exercicio exercicio) {
        this.exercicios.add(exercicio);
    }

    public void removeExercicios(Exercicio exercicio) {
        for (int i = 0; i < this.exercicios.size(); i++) {
            if (exercicio == this.exercicios.get(i)) {
                this.exercicios.remove(i);
            }
        }
    }

    public Exercicio procurarExercicioPorNome(String nome) {
        for (int i = 0; i < this.exercicios.size(); i++) {
            if (this.exercicios.get(i).getNome().equals(nome)) {
                return exercicios.get(i);
            }
        }
        return null;
    }
}
