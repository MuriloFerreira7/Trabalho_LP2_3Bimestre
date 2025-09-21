//!LER.nextLine() solto no meio do código é para limpar o buffer do teclado.
import classes.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    final static Scanner LER = new Scanner(System.in);
    static HashMap<Integer, Academia> academias = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.printf("o que você deseja fazer?\n");
            System.out.printf("1-criar uma academia\n");
            System.out.printf("2-gerenciar academia existente\n");
            System.out.printf("3-fechar\n");
            int caso = LER.nextInt();
            limparTela();
            switch (caso) {
                case 1 ->
                    criarAcademia();
                case 2 ->
                    gerenciarAcademia();
                case 3 -> {
                    return;
                }
            }
        }
    }

    public static void criarAcademia() {
        int id;
        boolean primeiraVez = true;
        do {
            if (primeiraVez) {
                primeiraVez = false;
                System.out.printf("para criar sua academia precisamos de um ID único para ela:");
            } else {
                System.out.println("este id já existe, tente novamente!");
            }
            id = LER.nextInt();
            limparTela();
        } while (academias.containsKey(id));
        System.out.printf("agora precisamos dos dados da sua academia.\nNome da academia:");
        LER.nextLine();
        String nome = LER.nextLine();
        limparTela();
        System.out.printf("endereço da academia:");
        String endereco = LER.nextLine();
        limparTela();
        System.out.printf("horário de funcionamento da academia:");
        String horarioDeFuncionamento = LER.nextLine();
        limparTela();
        academias.put(id, new Academia(nome, endereco, horarioDeFuncionamento, null, null, null));
    }

    public static void gerenciarAcademia() {
        int id = lerId();
        System.out.println("O que você deseja fazer?\n1-cadastrar aluno\n2-cadastrar funcionario\n3-cadastrar Area da academia\n4-Registrar exercicio\n5-Gerenciar Aluno\n6-gerenciar funcionário\n7-gerenciar área da academia\n8-gerenciar exercicio");
        int caso = LER.nextInt();
        switch (caso) {
            case 1 -> cadastrarAluno(id);
            case 2 -> cadastrarFuncionario(id);
            // case 3 -> cadastrarArea();
            // case 4 -> registrarExercicio();
            // case 5 -> gerenciarAluno();
            // case 6 -> gerenciarFuncionario();
            // case 7 -> gerenciarArea();
            // case 8 -> gerenciarExercicio();
            }
    }

    public static int lerId() {
        int id;
        boolean primeiraVez = true;
        do {
            if (primeiraVez) {
                primeiraVez = false;
                System.out.printf("qual academia você deseja gerenciar?(id):");
            } else {
                System.out.printf("essa academia não existe! tente novamente:");
            }
            id = LER.nextInt();
        } while (!academias.containsKey(id));
        return id;
    }

    public static void cadastrarFuncionario(int id) {
        limparTela();
        System.out.print("nome do funcionário:");
        LER.nextLine();
        String nome = LER.nextLine();
        limparTela();
        System.out.printf("CPF do funcionário:");
        String cpf = LER.nextLine();
        limparTela();
        System.out.printf("RG do funcionário:");
        String rg = LER.nextLine();
        limparTela();
        System.out.printf("email do funcionário:");
        String email = LER.nextLine();
        limparTela();
        System.out.printf("telefone do funcionário:");
        String telefone = LER.nextLine();
        limparTela();
        System.out.printf("data de nascimento do funcionário:");
        String dataDeNascimento = LER.nextLine();
        limparTela();
        String necessidadeEspecial = verificarNecessidadeEspecial("funcionário");
        limparTela();
        System.out.printf("area de atuação do funcionário:");
        LER.nextLine();
        String areaAtuacao = LER.nextLine();
        limparTela();
        System.out.printf("salário do funcionário:");
        String salario = LER.nextLine();
        limparTela();
        academias.get(id).addFuncionario(new Funcionario(nome, cpf, rg, email, telefone, dataDeNascimento, areaAtuacao, salario, necessidadeEspecial, null));
        System.out.println("funcionário adicionado com sucesso :)");
    }

    public static void cadastrarAluno(int id) {
        limparTela();
        System.out.print("nome do aluno:");
        LER.nextLine();
        String nome = LER.nextLine();
        limparTela();
        System.out.printf("CPF do aluno:");
        String cpf = LER.nextLine();
        limparTela();
        System.out.printf("RG do aluno:");
        String rg = LER.nextLine();
        limparTela();
        System.out.printf("email do aluno:");
        String email = LER.nextLine();
        limparTela();
        System.out.printf("telefone do aluno:");
        String telefone = LER.nextLine();
        limparTela();
        System.out.printf("data de nascimento do aluno:");
        String dataDeNascimento = LER.nextLine();
        limparTela();
        String necessidadeEspecial = verificarNecessidadeEspecial("aluno");
        limparTela();
        System.out.println("objetivo do aluno:");
        String objetivo = LER.nextLine();
        limparTela();
        academias.get(id).addAluno(new Aluno(nome, cpf, rg, email, telefone, dataDeNascimento, objetivo, necessidadeEspecial));
        System.out.println("aluno adicionado com sucesso :)");
    }

    public static String verificarNecessidadeEspecial(String pessoa) {
        boolean deuCerto = false;
        boolean temNecessidade = true;
        boolean primeiraVez = true;//limpar o buffer do teclado
        System.out.printf("o %s tem alguma necessidade especial?(true ou false):", pessoa);
        while (!deuCerto) {
            deuCerto = true;
            if (primeiraVez) {
                primeiraVez = false;
            } else {
                LER.nextLine();
            }
            try {
                temNecessidade = LER.nextBoolean();
            } catch (Exception e) {
                System.out.println("TRUE OU FALSE(minusculo)");
                deuCerto = false;
            }
        }
        String necessidadeEspecial;
        if (temNecessidade) {
            System.out.println("necessidade especial do aluno:");
            LER.nextLine();
            necessidadeEspecial = LER.nextLine();
        } else {
            necessidadeEspecial = null;
        }
        return necessidadeEspecial;
    }

    public static void limparTela() {
        for (int i = 0; i < 40; ++i) {
            System.out.println();
        }
        System.out.print("\033\143");

    }
}
