//!LER.nextLine() solto no meio do código é para limpar o buffer do teclado.
//deve ser adicionado uma forma de mudar os atributos de todas as classes

import classes.*;
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
            limparTela();
            switch (caso) {
                case 1 ->
                    criarAcademia();
                case 2 ->
                    gerenciarAcademia();
                case 3 ->
                    consultarAcademia();
                case 4 ->
                    mostrarAcademiasExistentes();
                case 5 -> {
                    return;
                }
            }
        }
    }

    // Função utilitária para ler opções de menu com verificação
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

    public static void mostrarAcademiasExistentes() {
        if (academias.isEmpty()) {
            System.out.println("Cadastre uma academia antes!");
            return;
        }
        for (Integer chave : academias.keySet()) {
            System.out.printf("id: %d nome: %s\n", chave, academias.get(chave).getNome());
        }
        LER.nextLine();
        LER.nextLine();
        limparTela();
    }

    public static void consultarAcademia() {
        if (academias.isEmpty()) {
            System.out.println("Cadastre uma academia antes!");
            return;
        }
        limparTela();
        Academia academia = academias.get(lerId("consultar"));
        limparTela();
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
                    limparTela();
                    return;
                }
            }
        }
    }

    public static void consultarArea(Academia academia) {
        limparTela();
        Area area = buscarArea(academia, "consultar");
        limparTela();
        while (true) {
            System.out.printf("o que você deseja consultar?\n1-atributos\n2-exercicios\n3-fechar\n");
            int caso = lerOpcaoMenu(1, 3);
            switch (caso) {
                case 1 ->
                    consultarAtributos(area);
                case 2 ->
                    consultarExercicios(area);
                case 3 -> {
                    limparTela();
                    return;
                }
            }
        }
    }

    public static void consultarExercicios(Area area) {
        limparTela();
        Exercicio exercicio = buscarExercicio(area);
        limparTela();
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
        limparTela();
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
        limparTela();
        ArrayList<Exercicio> exercicios = area.getExercicios();
        System.out.printf("informações\nnome da área: %s\nexercícios: ", area.getNome());
        for (int i = 0; i < exercicios.size(); i++) {
            if (i != exercicios.size() - 1) {
                System.out.printf("%s, ", exercicios.get(i).getNome());
            } else {
                System.out.printf("%s", exercicios.get(i).getNome());
            }
        }

    }

    public static void consultarFuncionario(Academia academia) {
        limparTela();
        Funcionario funcionario = buscarFuncionario(academia);
        limparTela();
        while (true) {
            System.out.printf("o que você deseja consultar?\n1-consultar Atributos\n2-advertências\n3-fechar\n");
            int caso = lerOpcaoMenu(1, 3);
            switch (caso) {
                case 1 ->
                    consultarAtributos(funcionario);
                case 2 ->
                    consultarAdvertencia(funcionario);
                case 3 -> {
                    limparTela();
                    return;
                }
            }
        }

    }

    public static void consultarAtributos(Funcionario funcionario) {
        limparTela();
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
        limparTela();
    }

    public static void consultarAluno(Academia academia) {
        limparTela();
        Aluno aluno = buscarAluno(academia);
        limparTela();
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
                    limparTela();
                    return;
                }
            }
        }
    }

    public static void consultarAdvertencia(Funcionario funcionario) {
        limparTela();
        Advertencia advertencia = buscarAdvertencia(funcionario);
        limparTela();
        System.out.printf("informações da advertência de %s\nmotivo: %s\npenalidade: %s\ndata: %s\n",
                funcionario.getNome(), advertencia.getMotivo(), advertencia.getPenalidade(), advertencia.getData());
        LER.nextLine();
        LER.nextLine();
        limparTela();
    }

    public static void consultarAdvertencia(Aluno aluno) {
        limparTela();
        Advertencia advertencia = buscarAdvertencia(aluno);
        limparTela();
        System.out.printf("informações da advertência de %s\nmotivo: %s\npenalidade: %s\ndata: %s\n",
                aluno.getNome(), advertencia.getMotivo(), advertencia.getPenalidade(), advertencia.getData());
        LER.nextLine();
        LER.nextLine();
        limparTela();
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
        limparTela();
        AvaliacaoFisica avaliacao = buscarAvaliacaoFisica(aluno);
        limparTela();
        System.out.printf(
                "avaliação física de %s\nbraço esquerdo: %s\nbraço direito: %s\nperna esquerda: %s\nperna direita: %s\ncintura: %s\nabdômen: %s\nbusto: %s\npescoço: %s\ngordura corporal: %s\nbanco de wells: %s\naltura: %s\npeso: %s\n",
                aluno.getNome(), avaliacao.getBracoEsquerdo(), avaliacao.getBracoDireito(),
                avaliacao.getPernaEsquerda(), avaliacao.getPernaDireito(), avaliacao.getCintura(),
                avaliacao.getAbdomen(), avaliacao.getBusto(), avaliacao.getPescoco(), avaliacao.getGorduraCorporal(),
                avaliacao.getBancoDeWells(), avaliacao.getAltura(), avaliacao.getPeso());
        LER.nextLine();
        LER.nextLine();
        limparTela();
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
        limparTela();
        System.out.printf("dados do aluno\nnome:%s\nCPF:%s\nRG:%s\nemail:%s\ntelefone:%s\ndata de nascimento:%s\n",
                aluno.getNome(), aluno.getCpf(), aluno.getRg(), aluno.getEmail(), aluno.getTelefone(),
                aluno.getDataDeNascimento());
        if (aluno.getNecessidadeEspecial() != null) {
            System.out.printf("necessidade especial:%s\n", aluno.getNecessidadeEspecial());
        }
        System.out.printf("objetivo:%s\n", aluno.getObjetivo());
        LER.nextLine();
        LER.nextLine();
        limparTela();
    }

    public static void consultarAtributos(Academia academia) {
        limparTela();
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
        limparTela();
    }

    public static void criarAcademia() {
        int id = lerId("criar");
        String nome = lerCampoObrigatorio("Nome da academia:");
        limparTela();
        String endereco = lerCampoObrigatorio("endereço da academia:");
        limparTela();
        String horarioDeFuncionamento = lerCampoObrigatorio("horário de funcionamento da academia:");
        limparTela();
        academias.put(id, new Academia(nome, endereco, horarioDeFuncionamento, null, null, null));
    }

    public static String lerCampoObrigatorio(String mensagem) {
        String valor = "";
        LER.nextLine();
        do {
            System.out.print(mensagem);
            valor = LER.nextLine();
            if (valor.isBlank()) {
                System.out.println("Campo obrigatório! Digite novamente.");
            }
        } while (valor.isBlank());
        return valor;
    }

    public static void gerenciarAcademia() {
        if (academias.isEmpty()) {
            limparTela();
            System.out.println("Cadastre uma academia antes!");
            return;
        }
        int id = lerId("gerenciar");
        while (true) {
            System.out.printf(
                    "O que você deseja fazer na academia %s?\n1-cadastrar aluno\n2-cadastrar funcionario\n3-cadastrar Area da academia\n4-Gerenciar Aluno\n5-gerenciar funcionário\n6-gerenciar área da academia\n7-editar atributos\n8-fechar\n",
                    academias.get(id).getNome());
            int caso = lerOpcaoMenu(1, 8);
            switch (caso) {
                case 1 ->
                    cadastrarAluno(id);
                case 2 ->
                    cadastrarFuncionario(id);
                case 3 ->
                    cadastrarArea(id);
                case 4 ->
                    gerenciarAluno(id);
                case 5 ->
                    gerenciarFuncionario(id);
                case 6 ->
                    gerenciarArea(id);
                case 7 ->
                    editarAtributos(academias.get(id));
                case 8 -> {
                    limparTela();
                    return;
                }
            }
        }

    }

    public static void gerenciarArea(int id) {
        if (academias.get(id).getAreas().isEmpty()) {
            limparTela();
            System.out.println("cadastre uma área primeiro!");
            return;
        }
        limparTela();
        Area area = buscarArea(academias.get(id), "gerenciar");
        limparTela();
        while (true) {
            System.out.printf("o que você deseja gerenciar na área %s\n1-nome\n2-exercícios\n3-gerenciar atributos\n4-fechar\n",
                    area.getNome());
            int caso = lerOpcaoMenu(1, 4);
            limparTela();
            switch (caso) {
                case 1 ->
                    gerenciarNome(area);
                case 2 ->
                    gerenciarExercicios(area);
                case 3 ->
                    editarAtributos(area);
                case 4 -> {
                    limparTela();
                    return;
                }
            }
        }

    }

    public static void gerenciarExercicio(Area area) {
        if (area.getExercicios().isEmpty()) {
            limparTela();
            System.out.println("essa área não contem exercícios");
            return;
        }
        limparTela();
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
            limparTela();
            System.out.printf(
                    "o que deseja fazer?\n1-alterar nome do exercício\n2-alterar conjunto muscular alvo\n3-gerenciar musculos principais\n4-gerenciar musculos secundários\n5-alterar nivel de dificuldade\n6-gerenciar atributos\n7-fechar\n");
            int caso = lerOpcaoMenu(1, 6);
            switch (caso) {
                case 1 ->
                    alterarNome(exercicio);
                case 2 ->
                    alterarConjuntoMuscularAlvo(exercicio);
                case 3 ->
                    gerenciarMusculosPrincipais(exercicio);
                case 4 ->
                    gerenciarMusculosSecundarios(exercicio);
                case 5 ->
                    alterarNivelDeDificuldade(exercicio);
                case 6 ->
                    editarAtributos(exercicio);
                case 7 -> {
                    limparTela();
                    return;
                }
            }
        }

    }

    public static void gerenciarMusculosSecundarios(Exercicio exercicio) {
        while (true) {
            limparTela();
            System.out.printf("o que você deseja fazer?\n1-adicionar músculo\n2-remover músculo\n3-fechar\n");
            int caso = lerOpcaoMenu(1, 3);
            switch (caso) {
                case 1 ->
                    adicionarMusculoSecundario(exercicio);
                case 2 ->
                    removerMusculoPrincipal(exercicio);
                case 3 -> {
                    limparTela();
                    return;
                }
            }
        }

    }

    public static void removerMusculoSecundario(Exercicio exercicio) {
        limparTela();
        System.out.printf("qual músculo deseja remover?:");
        LER.nextLine();
        exercicio.removeMusculoSecundario(LER.nextLine());
        limparTela();
        System.out.println("Musculo removido com sucesso :)");
    }

    public static void adicionarMusculoSecundario(Exercicio exercicio) {
        limparTela();
        System.out.printf("qual é o nome do músculo?:");
        LER.nextLine();
        exercicio.addMusculoSecundario(LER.nextLine());
        limparTela();
        System.out.println("Musculo adicionado com sucesso :)");
    }

    public static void gerenciarMusculosPrincipais(Exercicio exercicio) {
        while (true) {
            limparTela();
            System.out.printf("o que você deseja fazer?\n1-adicionar músculo\n2-remover músculo\n3-fechar\n");
            int caso = lerOpcaoMenu(1, 3);
            switch (caso) {
                case 1 ->
                    adicionarMusculoPrincipal(exercicio);
                case 2 ->
                    removerMusculoPrincipal(exercicio);
                case 3 -> {
                    limparTela();
                    return;
                }
            }
        }

    }

    public static void removerMusculoPrincipal(Exercicio exercicio) {
        limparTela();
        System.out.printf("qual músculo deseja remover?:");
        LER.nextLine();
        exercicio.removeMusculoPrincipal(LER.nextLine());
        limparTela();
        System.out.println("Musculo removido com sucesso :)");
    }

    public static void adicionarMusculoPrincipal(Exercicio exercicio) {
        limparTela();
        System.out.printf("qual é o nome do músculo?:");
        LER.nextLine();
        exercicio.addMusculoPrincipal(LER.nextLine());
        limparTela();
        System.out.println("Musculo adicionado com sucesso :)");
    }

    public static void alterarNivelDeDificuldade(Exercicio exercicio) {
        limparTela();
        System.out.printf("qual o novo nível de dificuldade?:");
        LER.nextLine();
        exercicio.setNivelDedificuldade(LER.nextLine());
    }

    public static void alterarConjuntoMuscularAlvo(Exercicio exercicio) {
        limparTela();
        System.out.printf("qual o novo conjunto muscular alvo?:");
        LER.nextLine();
        exercicio.setConjuntoMuscularAlvo(LER.nextLine());
    }

    public static void alterarNome(Exercicio exercicio) {
        limparTela();
        System.out.printf("qual o novo nome do exercício?:");
        LER.nextLine();
        exercicio.setNome(LER.nextLine());
    }

    public static void gerenciarExercicios(Area area) {
        while (true) {
            limparTela();
            System.out.printf(
                    "o que deseja fazer?\n1-adicionar exercício\n2-remover exercício\n3-gerenciar exercício\n4-fechar\n");
            int caso = lerOpcaoMenu(1, 4);
            switch (caso) {
                case 1 ->
                    adicionarExercicio(area);
                case 2 ->
                    removerExercicio(area);
                case 3 ->
                    gerenciarExercicio(area);
                case 4 -> {
                    limparTela();
                    return;
                }
            }
        }

    }

    public static void removerExercicio(Area area) {
        limparTela();
        System.out.printf("qual exercício deseja remover?:");
        String nome = LER.nextLine();
        area.removeExercicios(area.procurarExercicioPorNome(nome));
    }

    public static void adicionarExercicio(Area area) {
        limparTela();
        System.out.printf("nome do exercício:");
        LER.nextLine();
        String nome = LER.nextLine();
        limparTela();
        System.out.printf("conjunto muscular alvo:");
        String conjuntoMuscularAlvo = LER.nextLine();
        limparTela();
        System.out.printf("nível de dificuldade do exercício:");
        String nivelDeDificuldade = LER.nextLine();
        limparTela();
        area.addExercicio(new Exercicio(nome, conjuntoMuscularAlvo, null, null, nivelDeDificuldade));
        System.out.println("exercício adicionado com sucesso :)");
    }

    public static void gerenciarNome(Area area) {
        limparTela();
        System.out.printf("novo nome:");
        LER.nextLine();
        area.setNome(LER.nextLine());
    }

    public static Area buscarArea(Academia academia, String oq) {
        System.out.printf("qual área você deseja %s:", oq);
        LER.nextLine();
        String nome;
        boolean primeiraVez = true;
        do {
            if (primeiraVez) {
                primeiraVez = false;
            } else {
                System.out.printf("área não existe, tente novamente:");
            }
            nome = LER.nextLine();
        } while (academia.buscarAreaPorNome(nome) == null);
        return academia.buscarAreaPorNome(nome);
    }

    public static void gerenciarFuncionario(int id) {
        if (academias.get(id).getFuncionarios().isEmpty()) {
            limparTela();
            System.out.println("cadastre um funcionário antes!");
            return;
        }
        limparTela();
        Funcionario funcionario = buscarFuncionario(academias.get(id));
        limparTela();
        while (true) {
            limparTela();
            System.out.printf("O que você deseja gerenciar?\n1-área de atuação\n2-salário\n3-advertências\n4-gerenciar atributos\n5-fechar\n");
            int caso = lerOpcaoMenu(1, 5);
            limparTela();
            switch (caso) {
                case 1 ->
                    gerenciarAreaAtuacao(funcionario);
                case 2 ->
                    gerenciarSalario(funcionario);
                case 3 ->
                    gerenciarAdvertencias(funcionario);
                case 4 ->
                    editarAtributos(funcionario);
                case 5 -> {
                    limparTela();
                    return;
                }
            }
        }

    }

    public static Funcionario buscarFuncionario(Academia academia) {
        System.out.printf("qual o nome do funcionário?:");
        LER.nextLine();
        String nome;
        boolean primeiraVez = true;
        do {
            if (primeiraVez) {
                primeiraVez = false;
            } else {
                System.out.printf("funcionário não existe, tente novamente:");
            }
            nome = LER.nextLine();
        } while (academia.buscarFuncionarioPorNome(nome) == null);
        return academia.buscarFuncionarioPorNome(nome);
    }

    public static void gerenciarSalario(Funcionario funcionario) {
        while (true) {
            limparTela();
            System.out.printf("O que você deseja fazer?\n1-remover salário\n2-alterar salário\n3-fechar");
            int caso = lerOpcaoMenu(1, 3);
            limparTela();
            switch (caso) {
                case 1 ->
                    funcionario.setSalario(null);
                case 2 -> {
                    System.out.printf("qual é o novo salário de %s:", funcionario.getNome());
                    LER.nextLine();
                    funcionario.setSalario(LER.nextLine());
                }
                case 3 -> {
                    limparTela();
                    return;
                }
            }
            limparTela();
        }

    }

    public static void gerenciarAreaAtuacao(Funcionario funcionario) {
        while (true) {
            limparTela();
            System.out.printf("O que você deseja fazer?\n1-remover área de atuação\n2-alterar área de atuação\n3-fechar");
            int caso = lerOpcaoMenu(1, 3);
            limparTela();
            switch (caso) {
                case 1 ->
                    funcionario.setAreaAtuacao(null);
                case 2 -> {
                    System.out.printf("qual é a nova área de %s:", funcionario.getNome());
                    LER.nextLine();
                    funcionario.setAreaAtuacao(LER.nextLine());
                }
                case 3 -> {
                    limparTela();
                    return;
                }
            }
            limparTela();
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
            limparTela();
            System.out.println("cadastre um aluno primeiro!");
            return;
        }
        limparTela();
        Aluno aluno = buscarAluno(academias.get(id));
        limparTela();
        while (true) {
            limparTela();
            System.out.printf(
                    "O que você deseja gerenciar?\n1-objetivos\n2-avaliações físicas\n3-advertências\n4-editar atributos\n5-fechar\n");
            int caso = lerOpcaoMenu(1, 5);
            switch (caso) {
                case 1 ->
                    gerenciarObjetivos(aluno);
                case 2 ->
                    gerenciarAvaliacoesFisicas(aluno);
                case 3 ->
                    gerenciarAdvertencias(aluno);
                case 4 ->
                    editarAtributos(aluno);
                case 5 -> {
                    limparTela();
                    return;
                }
            }
        }

    }

    public static Aluno buscarAluno(Academia academia) {
        System.out.printf("qual o nome do aluno?:");
        LER.nextLine();
        String nome;
        boolean primeiraVez = true;
        do {
            if (primeiraVez) {
                primeiraVez = false;
            } else {
                System.out.printf("aluno não existe, tente novamente:");
            }
            nome = LER.nextLine();
        } while (academia.buscarAlunoPorNome(nome) == null);
        return academia.buscarAlunoPorNome(nome);
    }

    public static void gerenciarAvaliacoesFisicas(Aluno aluno) {
        while (true) {
            limparTela();
            System.out.printf(
                    "O que você deseja fazer?\n1-adicionar avaliação física\n2-remover avaliação física\n3-editar avaliação física\n4-fechar\n");
            int caso = lerOpcaoMenu(1, 4);
            switch (caso) {
                case 1 ->
                    adicionarAvaliacaoFisica(aluno);
                case 2 ->
                    removerAvaliacaoFisica(aluno);
                // case 3 -> editarAdvertencia(aluno);
                case 4 -> {
                    limparTela();
                    return;
                }
            }
        }

    }

    public static void adicionarAvaliacaoFisica(Aluno aluno) {
        limparTela();
        System.out.printf("id da avaliação física:");
        int id = LER.nextInt();
        limparTela();
        System.out.printf("braço esquerdo do aluno(cm):");
        LER.nextLine();
        String bracoEsquerdo = LER.nextLine();
        limparTela();
        System.out.printf("braço direito do aluno(cm):");
        String bracoDireito = LER.nextLine();
        limparTela();
        System.out.printf("perna esquerda do aluno(cm):");
        String pernaEsquerda = LER.nextLine();
        limparTela();
        System.out.printf("perna direita do aluno(cm):");
        String pernaDireito = LER.nextLine();
        limparTela();
        System.out.printf("cintura do aluno(cm):");
        String cintura = LER.nextLine();
        limparTela();
        System.out.printf("abdomen do aluno(Cm):");
        String abdomen = LER.nextLine();
        limparTela();
        System.out.printf("busto do aluno(cm):");
        String busto = LER.nextLine();
        limparTela();
        System.out.printf("pescoço do aluno(cm):");
        String pescoco = LER.nextLine();
        limparTela();
        System.out.printf("gordura gorporal(%%):");
        String gorduraCorporal = LER.nextLine();
        limparTela();
        System.out.printf("banco de wells(cm):");
        String bancoDeWells = LER.nextLine();
        limparTela();
        System.out.printf("altura do aluno(cm):");
        String altura = LER.nextLine();
        limparTela();
        System.out.printf("peso do aluno(kg):");
        String peso = LER.nextLine();
        limparTela();
        aluno.addAvaliacaoFisica(new AvaliacaoFisica(bracoEsquerdo, bracoDireito, pernaEsquerda, pernaDireito, cintura,
                abdomen, busto, pescoco, gorduraCorporal, bancoDeWells, altura, peso, id));
        System.out.println("avaliação física adicionada com sucesso :)");
    }

    public static void removerAvaliacaoFisica(Aluno aluno) {
        System.out.printf("qual avaliação física você deseja remover?(id):");
        aluno.removeAvaliacaoFisica(LER.nextInt());
    }

    public static void gerenciarAdvertencias(Funcionario funcionario) {
        while (true) {
            limparTela();
            System.out.printf(
                    "O que você deseja fazer?\n1-adicionar advertências\n2-remover advertências\n3-fechar\n");
            int caso = LER.nextInt();
            switch (caso) {
                case 1 ->
                    adicionarAdvertencia(funcionario);
                case 2 ->
                    removerAdvertencia(funcionario);
                // case 3 -> editarAdvertencia(aluno);
                case 3 -> {
                    limparTela();
                    return;
                }
            }
        }

    }

    public static void removerAdvertencia(Funcionario funcionario) {
        System.out.printf("Qual advertência você deseja remover?(id):");
        funcionario.removeAdvertencias(LER.nextInt());
    }

    public static void adicionarAdvertencia(Funcionario funcionario) {
        limparTela();
        System.out.printf("id da advertência:");
        int id = LER.nextInt();
        limparTela();
        System.out.printf("motivo da advertência:");
        LER.nextLine();
        String motivo = LER.nextLine();
        limparTela();
        System.out.printf("penalidade da advertência:");
        String penalidade = LER.nextLine();
        limparTela();
        System.out.printf("data da advertência:");
        String data = LER.nextLine();
        limparTela();
        funcionario.addAdvertencia(new Advertencia(id, motivo, penalidade, data));
        System.out.println("advertência adicionada com sucesso :(");
    }

    public static void gerenciarAdvertencias(Aluno aluno) {
        while (true) {
            limparTela();
            System.out.printf(
                    "O que você deseja fazer?\n1-adicionar advertências\n2-remover advertências\n3-editar advertência\n4-fechar\n");
            int caso = LER.nextInt();
            switch (caso) {
                case 1 ->
                    adicionarAdvertencia(aluno);
                case 2 ->
                    removerAdvertencia(aluno);
                // case 3 -> editarAdvertencia(aluno);
                case 4 -> {
                    limparTela();
                    return;
                }
            }
        }

    }

    public static void removerAdvertencia(Aluno aluno) {
        System.out.printf("Qual advertência você deseja remover?(id):");
        aluno.removeAdvertencias(LER.nextInt());
    }

    public static void adicionarAdvertencia(Aluno aluno) {
        limparTela();
        System.out.printf("id da advertência:");
        int id = LER.nextInt();
        limparTela();
        System.out.printf("motivo da advertência:");
        LER.nextLine();
        String motivo = LER.nextLine();
        limparTela();
        System.out.printf("penalidade da advertência:");
        String penalidade = LER.nextLine();
        limparTela();
        System.out.printf("data da advertência:");
        String data = LER.nextLine();
        limparTela();
        aluno.addAdvertencia(new Advertencia(id, motivo, penalidade, data));
        System.out.println("advertência adicionada com sucesso :(");
    }

    public static void gerenciarObjetivos(Aluno aluno) {
        while (true) {
            limparTela();
            System.out.printf("O que você deseja fazer?\n1-remover objetivo\n2-alterar objetivo\n3-fechar");
            int caso = LER.nextInt();
            limparTela();
            switch (caso) {
                case 1 ->
                    aluno.setObjetivo(null);
                case 2 -> {
                    System.out.printf("qual é o novo objetivo de %s", aluno.getNome());
                    LER.nextLine();
                    aluno.setObjetivo(LER.nextLine());
                }
                case 3 -> {
                    limparTela();
                    return;
                }
            }
            limparTela();

        }

    }

    public static void cadastrarArea(int id) {
        limparTela();
        System.out.printf("qual o nome da área?:");
        LER.nextLine();
        String nome = LER.nextLine();
        limparTela();
        academias.get(id).addArea(new Area(nome, null));
        System.out.println("área adicionada com sucesso");
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
        String areaAtuacao = LER.nextLine();
        limparTela();
        System.out.printf("salário do funcionário:");
        String salario = LER.nextLine();
        limparTela();
        academias.get(id).addFuncionario(new Funcionario(nome, cpf, rg, email, telefone, dataDeNascimento, areaAtuacao,
                salario, necessidadeEspecial, null));
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
        System.out.printf("objetivo do aluno:");
        LER.nextLine();
        String objetivo = LER.nextLine();
        limparTela();
        academias.get(id)
                .addAluno(new Aluno(nome, cpf, rg, email, telefone, dataDeNascimento, objetivo, necessidadeEspecial));
        System.out.println("aluno adicionado com sucesso :)");
    }

    public static String verificarNecessidadeEspecial(String pessoa) {
        boolean deuCerto = false;
        boolean temNecessidade = true;
        boolean primeiraVez = true;// limpar o buffer do teclado
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

    public static void editarAtributos(Academia academia) {
        limparTela();
        System.out.println("Editar atributos da academia:");
        System.out.printf("Nome atual: %s\nNovo nome (ou Enter para manter): ", academia.getNome());
        LER.nextLine();
        String nome = LER.nextLine();
        if (!nome.isEmpty()) {
            academia.setNome(nome);
        }
        System.out.printf("Endereço atual: %s\nNovo endereço (ou Enter para manter): ", academia.getEndereco());
        String endereco = LER.nextLine();
        if (!endereco.isEmpty()) {
            academia.setEndereco(endereco);
        }
        System.out.printf("Horário atual: %s\nNovo horário (ou Enter para manter): ", academia.getHorarioDeFuncionamento());
        String horario = LER.nextLine();
        if (!horario.isEmpty()) {
            academia.setHorarioDeFuncionamento(horario);
        }
        limparTela();
        System.out.println("Atributos atualizados!");
    }

    public static void editarAtributos(Aluno aluno) {
        limparTela();
        System.out.println("Editar atributos do aluno:");
        System.out.printf("Nome atual: %s\nNovo nome (ou Enter para manter): ", aluno.getNome());
        LER.nextLine();
        String nome = LER.nextLine();
        if (!nome.isEmpty()) {
            aluno.setNome(nome);
        }
        System.out.printf("CPF atual: %s\nNovo CPF (ou Enter para manter): ", aluno.getCpf());
        String cpf = LER.nextLine();
        if (!cpf.isEmpty()) {
            aluno.setCpf(cpf);
        }
        System.out.printf("RG atual: %s\nNovo RG (ou Enter para manter): ", aluno.getRg());
        String rg = LER.nextLine();
        if (!rg.isEmpty()) {
            aluno.setRg(rg);
        }
        System.out.printf("Email atual: %s\nNovo email (ou Enter para manter): ", aluno.getEmail());
        String email = LER.nextLine();
        if (!email.isEmpty()) {
            aluno.setEmail(email);
        }
        System.out.printf("Telefone atual: %s\nNovo telefone (ou Enter para manter): ", aluno.getTelefone());
        String telefone = LER.nextLine();
        if (!telefone.isEmpty()) {
            aluno.setTelefone(telefone);
        }
        System.out.printf("Data de nascimento atual: %s\nNova data (ou Enter para manter): ", aluno.getDataDeNascimento());
        String data = LER.nextLine();
        if (!data.isEmpty()) {
            aluno.setDataDeNascimento(data);
        }
        System.out.printf("Necessidade especial atual: %s\nNova necessidade (ou Enter para manter): ", aluno.getNecessidadeEspecial());
        String necessidade = LER.nextLine();
        if (!necessidade.isEmpty()) {
            aluno.setNecessidadeEspecial(necessidade);
        }
        System.out.printf("Objetivo atual: %s\nNovo objetivo (ou Enter para manter): ", aluno.getObjetivo());
        String objetivo = LER.nextLine();
        if (!objetivo.isEmpty()) {
            aluno.setObjetivo(objetivo);
        }
        limparTela();
        System.out.println("Atributos atualizados!");
    }

    public static void editarAtributos(Funcionario funcionario) {
        limparTela();
        System.out.println("Editar atributos do funcionário:");
        System.out.printf("Nome atual: %s\nNovo nome (ou Enter para manter): ", funcionario.getNome());
        LER.nextLine();
        String nome = LER.nextLine();
        if (!nome.isEmpty()) {
            funcionario.setNome(nome);
        }
        System.out.printf("CPF atual: %s\nNovo CPF (ou Enter para manter): ", funcionario.getCpf());
        String cpf = LER.nextLine();
        if (!cpf.isEmpty()) {
            funcionario.setCpf(cpf);
        }
        System.out.printf("RG atual: %s\nNovo RG (ou Enter para manter): ", funcionario.getRg());
        String rg = LER.nextLine();
        if (!rg.isEmpty()) {
            funcionario.setRg(rg);
        }
        System.out.printf("Email atual: %s\nNovo email (ou Enter para manter): ", funcionario.getEmail());
        String email = LER.nextLine();
        if (!email.isEmpty()) {
            funcionario.setEmail(email);
        }
        System.out.printf("Telefone atual: %s\nNovo telefone (ou Enter para manter): ", funcionario.getTelefone());
        String telefone = LER.nextLine();
        if (!telefone.isEmpty()) {
            funcionario.setTelefone(telefone);
        }
        System.out.printf("Data de nascimento atual: %s\nNova data (ou Enter para manter): ", funcionario.getDataDeNascimento());
        String data = LER.nextLine();
        if (!data.isEmpty()) {
            funcionario.setDataDeNascimento(data);
        }
        System.out.printf("Necessidade especial atual: %s\nNova necessidade (ou Enter para manter): ", funcionario.getNecessidadeEspecial());
        String necessidade = LER.nextLine();
        if (!necessidade.isEmpty()) {
            funcionario.setNecessidadeEspecial(necessidade);
        }
        System.out.printf("Área de atuação atual: %s\nNova área (ou Enter para manter): ", funcionario.getAreaAtuacao());
        String area = LER.nextLine();
        if (!area.isEmpty()) {
            funcionario.setAreaAtuacao(area);
        }
        System.out.printf("Salário atual: %s\nNovo salário (ou Enter para manter): ", funcionario.getSalario());
        String salario = LER.nextLine();
        if (!salario.isEmpty()) {
            funcionario.setSalario(salario);
        }
        limparTela();
        System.out.println("Atributos atualizados!");
    }

    public static void editarAtributos(Area area) {
        limparTela();
        System.out.println("Editar atributos da área:");
        System.out.printf("Nome atual: %s\nNovo nome (ou Enter para manter): ", area.getNome());
        LER.nextLine();
        String nome = LER.nextLine();
        if (!nome.isEmpty()) {
            area.setNome(nome);
        }
        limparTela();
        System.out.println("Atributos atualizados!");
    }

    public static void editarAtributos(Exercicio exercicio) {
        limparTela();
        System.out.println("Editar atributos do exercício:");
        System.out.printf("Nome atual: %s\nNovo nome (ou Enter para manter): ", exercicio.getNome());
        LER.nextLine();
        String nome = LER.nextLine();
        if (!nome.isEmpty()) {
            exercicio.setNome(nome);
        }
        System.out.printf("Conjunto muscular alvo atual: %s\nNovo conjunto (ou Enter para manter): ", exercicio.getConjuntoMuscularAlvo());
        String conjunto = LER.nextLine();
        if (!conjunto.isEmpty()) {
            exercicio.setConjuntoMuscularAlvo(conjunto);
        }
        System.out.printf("Nível de dificuldade atual: %s\nNovo nível (ou Enter para manter): ", exercicio.getNivelDedificuldade());
        String nivel = LER.nextLine();
        if (!nivel.isEmpty()) {
            exercicio.setNivelDedificuldade(nivel);
        }
        limparTela();
        System.out.println("Atributos atualizados!");
    }

    public static void limparTela() {
        for (int i = 0; i < 40; ++i) {
            System.out.println();
        }
        System.out.print("\033\143");
    }
}
