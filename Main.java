//!LER.nextLine() solto no meio do código é para limpar o buffer do teclado.

import java.util.ArrayList;
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
            System.out.printf("3-consultar academia existente\n");
            System.out.printf("4-mostrar academias existentes\n");
            System.out.printf("5-fechar\n");
            int caso = lerOpcaoMenu(1, 5);
            CRUD.limparTela();
            switch (caso) {
                case 1 ->
                    academias = CRUD.criarAcademia(academias);
                case 2 ->
                    gerenciarAcademia();
                case 3 ->
                    consultarAcademia();
                case 4 ->
                    CRUD.mostrarAcademiasExistentes(academias);
                case 5 -> {
                    return;
                }
            }
        }
    }

    public static int lerOpcaoMenu(int min, int max) {
        int opcao = -1;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Digite a opção desejada: ");
                opcao = LER.nextInt();
                if (opcao >= min && opcao <= max) {
                    valido = true;
                } else {
                    System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Digite um número válido!");
                LER.nextLine(); // Limpa buffer
            }
        }
        return opcao;
    }

    public static void consultarAcademia() {
        if (academias.isEmpty()) {
            System.out.println("Cadastre uma academia antes!");
            return;
        }
        CRUD.limparTela();
        Academia academia = academias.get(lerId("consultar"));
        CRUD.limparTela();
        while (true) {
            System.out.printf(
                    "o que deseja consultar?\n1-atributos da academia\n2-alunos\n3-funcionários\n4-áreas\n5-fechar\n");
            int caso = lerOpcaoMenu(1, 5);
            switch (caso) {
                case 1 ->
                    consultarAtributos(academia);
                case 2 ->
                    consultarAluno(academia);
                case 3 ->
                    consultarFuncionario(academia);
                case 4 ->
                    consultarArea(academia);
                case 5 -> {
                    CRUD.limparTela();
                    return;
                }
            }
        }
    }

    public static void consultarArea(Academia academia) {
        if (academia.getAreas().isEmpty()) {
            CRUD.limparTela();
            System.out.println("cadastre uma área primeiro!");
            return;
        }
        CRUD.limparTela();
        Area area = CRUD.buscarArea(academia, "consultar");
        CRUD.limparTela();
        while (true) {
            System.out.printf("o que você deseja consultar?\n1-atributos\n2-exercicios\n3-fechar\n");
            int caso = lerOpcaoMenu(1, 3);
            switch (caso) {
                case 1 ->
                    consultarAtributos(area);
                case 2 ->
                    consultarExercicios(area);
                case 3 -> {
                    CRUD.limparTela();
                    return;
                }
            }
        }
    }

    public static void consultarExercicios(Area area) {
        if (area.getExercicios().isEmpty()) {
            CRUD.limparTela();
            System.out.println("essa área não contem exercícios");
            return;
        }
        CRUD.limparTela();
        Exercicio exercicio = buscarExercicio(area);
        CRUD.limparTela();
        System.out.printf("nome: %s\nconjunto muscular alvo: %s\nnível de dificuldade: %s\nmusculos principais: ",
                exercicio.getNome(), exercicio.getConjuntoMuscularAlvo(), exercicio.getNivelDedificuldade());
        ArrayList<String> musculosPrincipais = exercicio.getMusculosPrincipais();
        ArrayList<String> musculosSecundarios = exercicio.getMusculosSegundarios();
        for (int i = 0; i < musculosPrincipais.size(); i++) {
            if (i != musculosPrincipais.size() - 1) {
                System.out.printf("%s, ", musculosPrincipais.get(i));
            } else {
                System.out.printf("%s\n", musculosPrincipais.get(i));
            }
        }
        System.out.print("musculos secundários: ");
        for (int i = 0; i < musculosSecundarios.size(); i++) {
            if (i != musculosSecundarios.size() - 1) {
                System.out.printf("%s, ", musculosSecundarios.get(i));
            } else {
                System.out.printf("%s\n", musculosSecundarios.get(i));
            }
        }
        LER.nextLine();
        LER.nextLine();
        CRUD.limparTela();
    }

    public static Exercicio buscarExercicio(Area area) {
        System.out.printf("qual o nome do exercicio?:");
        LER.nextLine();
        String nome;
        boolean primeiraVez = true;
        do {
            if (primeiraVez) {
                primeiraVez = false;
            } else {
                System.out.printf("exercício não existe, tente novamente:");
            }
            nome = LER.nextLine();
        } while (area.procurarExercicioPorNome(nome) == null);
        return area.procurarExercicioPorNome(nome);
    }

    public static void consultarAtributos(Area area) {
        CRUD.limparTela();
        ArrayList<Exercicio> exercicios = area.getExercicios();
        System.out.printf("informações\nnome da área: %s\nexercícios: ", area.getNome());
        for (int i = 0; i < exercicios.size(); i++) {
            if (i != exercicios.size() - 1) {
                System.out.printf("%s, ", exercicios.get(i).getNome());
            } else {
                System.out.printf("%s", exercicios.get(i).getNome());
            }
        }
        LER.nextLine();
        LER.nextLine();
        CRUD.limparTela();
    }

    public static void consultarFuncionario(Academia academia) {
        if (academia.getFuncionarios().isEmpty()) {
            CRUD.limparTela();
            System.out.println("cadastre um funcionário primeiro!");
            return;
        }
        CRUD.limparTela();
        Funcionario funcionario = CRUD.buscarFuncionario(academia);
        CRUD.limparTela();
        while (true) {
            System.out.printf("o que você deseja consultar?\n1-consultar Atributos\n2-advertências\n3-fechar\n");
            int caso = lerOpcaoMenu(1, 3);
            switch (caso) {
                case 1 ->
                    consultarAtributos(funcionario);
                case 2 ->
                    consultarAdvertencia(funcionario);
                case 3 -> {
                    CRUD.limparTela();
                    return;
                }
            }
        }

    }

    public static void consultarAtributos(Funcionario funcionario) {
        CRUD.limparTela();
        System.out.printf(
                "dados do funcionário\nnome:%s\nCPF:%s\nRG:%s\nemail:%s\ntelefone:%s\ndata de nascimento:%s\n",
                funcionario.getNome(), funcionario.getCpf(), funcionario.getRg(), funcionario.getEmail(),
                funcionario.getTelefone(),
                funcionario.getDataDeNascimento());
        if (funcionario.getNecessidadeEspecial() != null) {
            System.out.printf("necessidade especial:%s\n", funcionario.getNecessidadeEspecial());
        }
        System.out.printf("area de atuação: %s\nsalário: %s", funcionario.getAreaAtuacao(), funcionario.getSalario());
        LER.nextLine();
        LER.nextLine();
        CRUD.limparTela();
    }

    public static void consultarAluno(Academia academia) {
        if (academia.getAlunos().isEmpty()) {
            CRUD.limparTela();
            System.out.println("cadastre um aluno primeiro!");
            return;
        }
        CRUD.limparTela();
        Aluno aluno = CRUD.buscarAluno(academia);
        CRUD.limparTela();
        while (true) {
            System.out.printf(
                    "o que você deseja fazer?\n1-consultar atributos\n2-consultar avaliações físicas\n3-consultar advertências\n4-fechar\n");
            int caso = lerOpcaoMenu(1, 4);
            switch (caso) {
                case 1 ->
                    consultarAtributos(aluno);
                case 2 ->
                    consultarAvaliacaoFisica(aluno);
                case 3 ->
                    consultarAdvertencia(aluno);
                case 4 -> {
                   CRUD.limparTela();
                    return;
                }
            }
        }
    }

    public static void consultarAdvertencia(Funcionario funcionario) {
        if (funcionario.getAdvertencias().isEmpty()) {
            CRUD.limparTela();
            System.out.println("cadastre uma advertência primeiro!");
            return;
        }
        CRUD.limparTela();
        Advertencia advertencia = buscarAdvertencia(funcionario);
        CRUD.limparTela();
        System.out.printf("informações da advertência de %s\nmotivo: %s\npenalidade: %s\ndata: %s\n",
                funcionario.getNome(), advertencia.getMotivo(), advertencia.getPenalidade(), advertencia.getData());
        LER.nextLine();
        LER.nextLine();
        CRUD.limparTela();
    }

    public static void consultarAdvertencia(Aluno aluno) {
        if(aluno.getAdvertencias().isEmpty()) {
            CRUD.limparTela();
            System.out.println("cadastre uma advertência primeiro!");
            return;
        }
        CRUD.limparTela();
        Advertencia advertencia = buscarAdvertencia(aluno);
        CRUD.limparTela();
        System.out.printf("informações da advertência de %s\nmotivo: %s\npenalidade: %s\ndata: %s\n",
                aluno.getNome(), advertencia.getMotivo(), advertencia.getPenalidade(), advertencia.getData());
        LER.nextLine();
        LER.nextLine();
        CRUD.limparTela();
    }

    public static Advertencia buscarAdvertencia(Aluno aluno) {
        System.out.printf("qual o id da advertência?:");
        LER.nextLine();
        int id;
        boolean primeiraVez = true;
        do {
            if (primeiraVez) {
                primeiraVez = false;
            } else {
                System.out.printf("advertência não existe, tente novamente:");
            }
            id = LER.nextInt();
        } while (aluno.buscarAdvertenciaPorId(id) == null);
        return aluno.buscarAdvertenciaPorId(id);
    }

    public static Advertencia buscarAdvertencia(Funcionario funcionario) {
        System.out.printf("qual o id da advertência?:");
        LER.nextLine();
        int id;
        boolean primeiraVez = true;
        do {
            if (primeiraVez) {
                primeiraVez = false;
            } else {
                System.out.printf("advertência não existe, tente novamente:");
            }
            id = LER.nextInt();
        } while (funcionario.buscarAdvertenciaPorId(id) == null);
        return funcionario.buscarAdvertenciaPorId(id);
    }

    public static void consultarAvaliacaoFisica(Aluno aluno) {
        if (aluno.getAvaliacoesFisicas().isEmpty()) {
            CRUD.limparTela();
            System.out.println("cadastre uma avaliação física primeiro!");
            return;
        }
        CRUD.limparTela();
        AvaliacaoFisica avaliacao = buscarAvaliacaoFisica(aluno);
        CRUD.limparTela();
        System.out.printf(
                "avaliação física de %s\nbraço esquerdo: %s\nbraço direito: %s\nperna esquerda: %s\nperna direita: %s\ncintura: %s\nabdômen: %s\nbusto: %s\npescoço: %s\ngordura corporal: %s\nbanco de wells: %s\naltura: %s\npeso: %s\n",
                aluno.getNome(), avaliacao.getBracoEsquerdo(), avaliacao.getBracoDireito(),
                avaliacao.getPernaEsquerda(), avaliacao.getPernaDireito(), avaliacao.getCintura(),
                avaliacao.getAbdomen(), avaliacao.getBusto(), avaliacao.getPescoco(), avaliacao.getGorduraCorporal(),
                avaliacao.getBancoDeWells(), avaliacao.getAltura(), avaliacao.getPeso());
        LER.nextLine();
        LER.nextLine();
        CRUD.limparTela();
    }

    public static AvaliacaoFisica buscarAvaliacaoFisica(Aluno aluno) {
        System.out.printf("qual o id da avaliação física?:");
        LER.nextLine();
        int id;
        boolean primeiraVez = true;
        do {
            if (primeiraVez) {
                primeiraVez = false;
            } else {
                System.out.printf("avaliação física não existe, tente novamente:");
            }
            id = LER.nextInt();
        } while (aluno.buscarAvaliacaoFisicaPorId(id) == null);
        return aluno.buscarAvaliacaoFisicaPorId(id);
    }

    public static void consultarAtributos(Aluno aluno) {
        CRUD.limparTela();
        System.out.printf("dados do aluno\nnome:%s\nCPF:%s\nRG:%s\nemail:%s\ntelefone:%s\ndata de nascimento:%s\n",
                aluno.getNome(), aluno.getCpf(), aluno.getRg(), aluno.getEmail(), aluno.getTelefone(),
                aluno.getDataDeNascimento());
        if (aluno.getNecessidadeEspecial() != null) {
            System.out.printf("necessidade especial:%s\n", aluno.getNecessidadeEspecial());
        }
        System.out.printf("objetivo:%s\n", aluno.getObjetivo());
        LER.nextLine();
        LER.nextLine();
        CRUD.limparTela();
    }

    public static void consultarAtributos(Academia academia) {
        CRUD.limparTela();
        ArrayList<Aluno> alunos = academia.getAlunos();
        ArrayList<Funcionario> funcionarios = academia.getFuncionarios();
        ArrayList<Area> areas = academia.getAreas();
        System.out.printf(
                "nome da academia: %s\nendereço da academia: %s\nhorario de funcionamento da academia: %s\nalunos: ",
                academia.getNome(), academia.getEndereco(), academia.getHorarioDeFuncionamento());
        for (int i = 0; i < alunos.size(); i++) {
            if (i != alunos.size() - 1) {
                System.out.printf("%s, ", alunos.get(i).getNome());
            } else {
                System.out.printf("%s", alunos.get(i).getNome());
            }
        }
        System.out.printf("\nfuncionários: ");
        for (int i = 0; i < funcionarios.size(); i++) {
            if (i != funcionarios.size() - 1) {
                System.out.printf("%s, ", funcionarios.get(i).getNome());
            } else {
                System.out.printf("%s", funcionarios.get(i).getNome());
            }
        }
        System.out.printf("\nÁreas: ");
        for (int i = 0; i < areas.size(); i++) {
            if (i != areas.size() - 1) {
                System.out.printf("%s, ", areas.get(i).getNome());
            } else {
                System.out.printf("%s", areas.get(i).getNome());
            }
        }
        LER.nextLine();
        LER.nextLine();
        CRUD.limparTela();
    }

    public static void gerenciarAcademia() {
        if (academias.isEmpty()) {
            CRUD.limparTela();
            System.out.println("Cadastre uma academia antes!");
            return;
        }
        int id = lerId("gerenciar");
        Academia academia = academias.get(id);
        while (true) {
            System.out.printf(
                    "O que você deseja fazer na academia %s?\n1-cadastrar aluno\n2-cadastrar funcionario\n3-cadastrar Area da academia\n4-Gerenciar Aluno\n5-gerenciar funcionário\n6-gerenciar área da academia\n7-editar atributos\n8-fechar\n",
                    academia.getNome());
            int caso = lerOpcaoMenu(1, 8);
            switch (caso) {
                case 1 ->
                    academia = CRUD.cadastrarAluno(academia);
                case 2 ->
                    academia = CRUD.cadastrarFuncionario(academia);
                case 3 ->
                    academia = CRUD.cadastrarArea(academia);
                case 4 ->
                    gerenciarAluno(id);
                case 5 ->
                    gerenciarFuncionario(id);
                case 6 ->
                    gerenciarArea(id);
                case 7 ->
                    academia = CRUD.editarAtributos(academia);
                case 8 -> {
                    CRUD.limparTela();
                    return;
                }
            }
        }

    }

    public static void gerenciarArea(int id) {
        if (academias.get(id).getAreas().isEmpty()) {
            CRUD.limparTela();
            System.out.println("cadastre uma área primeiro!");
            return;
        }
        CRUD.limparTela();
        Area area = CRUD.buscarArea(academias.get(id), "gerenciar");
        CRUD.limparTela();
        while (true) {
            System.out.printf("o que você deseja gerenciar na área %s\n1-exercícios\n2-gerenciar atributos\n3-fechar\n",
                    area.getNome());
            int caso = lerOpcaoMenu(1, 3);
            CRUD.limparTela();
            switch (caso) {
                case 1 ->
                    gerenciarExercicios(area);
                case 2 ->
                    area = CRUD.editarAtributos(area);
                case 3 -> {
                    CRUD.limparTela();
                    return;
                }
            }
        }

    }

    public static void gerenciarExercicio(Area area) {
        if (area.getExercicios().isEmpty()) {
            CRUD.limparTela();
            System.out.println("essa área não contem exercícios");
            return;
        }
        CRUD.limparTela();
        System.out.printf("qual exercício você deseja gerenciar?:");
        LER.nextLine();
        String nome = LER.nextLine();
        Exercicio exercicio;
        if (area.procurarExercicioPorNome(nome) != null) {
            exercicio = area.procurarExercicioPorNome(nome);
        } else {
            System.out.println("exercicio inexistente!");
            return;
        }
        while (true) {
            CRUD.limparTela();
            System.out.printf(
                    "o que deseja fazer?\n1-gerenciar musculos principais\n2-gerenciar musculos secundários\n3-gerenciar atributos\n4-fechar\n");
            int caso = lerOpcaoMenu(1, 4);
            CRUD.limparTela();
            switch (caso) {
                case 1 ->
                    gerenciarMusculosPrincipais(exercicio);
                case 2 ->
                    gerenciarMusculosSecundarios(exercicio);
                case 3 ->
                    exercicio = CRUD.editarAtributos(exercicio);
                case 4 -> {
                    CRUD.limparTela();
                    return;
                }
            }
        }

    }

    public static void gerenciarMusculosSecundarios(Exercicio exercicio) {
        while (true) {
            CRUD.limparTela();
            System.out.printf("o que você deseja fazer?\n1-adicionar músculo\n2-remover músculo\n3-fechar\n");
            int caso = lerOpcaoMenu(1, 3);
            switch (caso) {
                case 1 ->
                    exercicio = CRUD.adicionarMusculoSecundario(exercicio);
                case 2 ->
                    exercicio = CRUD.removerMusculoPrincipal(exercicio);
                case 3 -> {
                    CRUD.limparTela();
                    return;
                }
            }
        }

    }

    public static void removerMusculoSecundario(Exercicio exercicio) {
        CRUD.limparTela();
        System.out.printf("qual músculo deseja remover?:");
        LER.nextLine();
        exercicio.removeMusculoSecundario(LER.nextLine());
        CRUD.limparTela();
        System.out.println("Musculo removido com sucesso :)");
    }

    public static void gerenciarMusculosPrincipais(Exercicio exercicio) {
        while (true) {
            System.out.printf("o que você deseja fazer?\n1-adicionar músculo\n2-remover músculo\n3-fechar\n");
            int caso = lerOpcaoMenu(1, 3);
            CRUD.limparTela();
            switch (caso) {
                case 1 ->
                    exercicio = CRUD.adicionarMusculoPrincipal(exercicio);
                case 2 ->
                    exercicio = CRUD.removerMusculoPrincipal(exercicio);
                case 3 -> {
                    CRUD.limparTela();
                    return;
                }
            }
        }

    }

    public static void gerenciarExercicios(Area area) {
        while (true) {
            System.out.printf(
                    "o que deseja fazer?\n1-adicionar exercício\n2-remover exercício\n3-gerenciar exercício\n4-fechar\n");
            int caso = lerOpcaoMenu(1, 7);
            CRUD.limparTela();
            switch (caso) {
                case 1 ->
                    area = CRUD.adicionarExercicio(area);
                case 2 ->
                    area = CRUD.removerExercicio(area);
                case 3 ->
                    gerenciarExercicio(area);
                case 4 -> {
                    CRUD.limparTela();
                    return;
                }
            }
        }
    }

    public static void gerenciarFuncionario(int id) {
        if (academias.get(id).getFuncionarios().isEmpty()) {
            CRUD.limparTela();
            System.out.println("cadastre um funcionário antes!");
            return;
        }
        CRUD.limparTela();
        Funcionario funcionario = CRUD.buscarFuncionario(academias.get(id));
        CRUD.limparTela();
        while (true) {
            System.out.printf("O que você deseja gerenciar?\n1-advertências\n2-gerenciar atributos\n3-fechar\n");
            int caso = lerOpcaoMenu(1, 3);
            CRUD.limparTela();
            switch (caso) {
                case 1 ->
                    gerenciarAdvertencias(funcionario);
                case 2 ->
                    funcionario = CRUD.editarAtributos(funcionario);
                case 3 -> {
                    CRUD.limparTela();
                    return;
                }
            }
        }

    }

    public static int lerId(String oq) {
        int id;
        boolean primeiraVez = true;
        do {
            if (primeiraVez) {
                primeiraVez = false;
                System.out.printf("qual academia você deseja %s?(id):", oq);
            } else {
                System.out.printf("essa academia não existe! tente novamente:");
            }
            id = LER.nextInt();
        } while (!academias.containsKey(id));
        return id;
    }

    public static void gerenciarAluno(int id) {
        if (academias.get(id).getAlunos().isEmpty()) {
            CRUD.limparTela();
            System.out.println("cadastre um aluno primeiro!");
            return;
        }
        CRUD.limparTela();
        Aluno aluno = CRUD.buscarAluno(academias.get(id));
        CRUD.limparTela();
        while (true) {
            CRUD.limparTela();
            System.out.printf(
                    "O que você deseja gerenciar?\n1-avaliações físicas\n2-advertências\n3-editar atributos\n4-fechar\n");
            int caso = lerOpcaoMenu(1, 4);
            switch (caso) {
                case 1 ->
                    gerenciarAvaliacoesFisicas(aluno);
                case 2 ->
                    gerenciarAdvertencias(aluno);
                case 3 ->
                    aluno = CRUD.editarAtributos(aluno);
                case 4 -> {
                    CRUD.limparTela();
                    return;
                }
            }
        }

    }

    public static void gerenciarAvaliacoesFisicas(Aluno aluno) {
        while (true) {
            System.out.printf(
                    "O que você deseja fazer?\n1-adicionar avaliação física\n2-remover avaliação física\n3-editar avaliação física\n4-fechar\n");
            int caso = lerOpcaoMenu(1, 4);
            switch (caso) {
                case 1 ->
                    aluno = CRUD.adicionarAvaliacaoFisica(aluno);
                case 2 ->
                    aluno = CRUD.removerAvaliacaoFisica(aluno);
                // case 3 -> editarAdvertencia(aluno);
                case 4 -> {
                    CRUD.limparTela();
                    return;
                }
            }
        }

    }

    public static void gerenciarAdvertencias(Funcionario funcionario) {
        while (true) {
            CRUD.limparTela();
            System.out.printf(
                    "O que você deseja fazer?\n1-adicionar advertências\n2-remover advertências\n3-fechar\n");
            int caso = LER.nextInt();
            switch (caso) {
                case 1 ->
                    funcionario = CRUD.adicionarAdvertencia(funcionario);
                case 2 ->
                    funcionario = CRUD.removerAdvertencia(funcionario);
                // case 3 -> editarAdvertencia(aluno);
                case 3 -> {
                    CRUD.limparTela();
                    return;
                }
            }
        }

    }

    public static void gerenciarAdvertencias(Aluno aluno) {
        while (true) {
            CRUD.limparTela();
            System.out.printf(
                    "O que você deseja fazer?\n1-adicionar advertências\n2-remover advertências\n3-editar advertência\n4-fechar\n");
            int caso = LER.nextInt();
            switch (caso) {
                case 1 ->
                    aluno = CRUD.adicionarAdvertencia(aluno);
                case 2 ->
                    aluno = CRUD.removerAdvertencia(aluno);
                // case 3 -> editarAdvertencia(aluno);
                case 4 -> {
                    CRUD.limparTela();
                    return;
                }
            }
        }

    }
}