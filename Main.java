//!LER.nextLine() solto no meio do código é para limpar o buffer do teclado.
//deve ser adicionado uma forma de mudar os atributos de todas as classes
//deve ser adicionado uma forma de adicionar e remover musculos principais e secundarios dos exercicios

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
            System.out.printf("4-fechar\n");
            int caso = LER.nextInt();
            limparTela();
            switch (caso) {
                case 1 ->
                    criarAcademia();
                case 2 ->
                    gerenciarAcademia();
                case 3 ->
                    consultarAcademia();
                case 4 -> {
                    return;
                }
            }
        }
    }

    public static void consultarAcademia() {
        limparTela();
        Academia academia = academias.get(lerId("consultar"));
        limparTela();
        while (true) {
            System.out.printf("o que deseja consultar?\n1-atributos da academia\n2-alunos\n3-funcionários\n4-áreas\n5-fechar\n");
            int caso = LER.nextInt();
            switch (caso) {
                case 1 ->
                    consultarAtributos(academia);
                case 2 ->
                    consultarAluno(academia);
                // case 3 -> consultarFuncionarios();
                // case 4 -> consultarAreas();
                case 5 -> {
                    limparTela();
                    return;
                }
            }
        }
    }

    public static void consultarAluno(Academia academia) {
        limparTela();
        Aluno aluno = buscarAluno(academia);
        limparTela();
        while (true) {
            System.out.printf("o que você deseja fazer?\n1-consultar atributos\n2-consultar avaliações físicas\n3-consultar advertências\n4-fechar\n");
            int caso = LER.nextInt();
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

    public static void consultarAvaliacaoFisica(Aluno aluno) {
        limparTela();
        AvaliacaoFisica avaliacao = buscarAvaliacaoFisica(aluno);
        limparTela();
        System.out.printf("avaliação física de %s\nbraço esquerdo: %s\nbraço direito: %s\nperna esquerda: %s\nperna direita: %s\ncintura: %s\nabdômen: %s\nbusto: %s\npescoço: %s\ngordura corporal: %s\nbanco de wells: %s\naltura: %s\npeso: %s\n",
                aluno.getNome(), avaliacao.getBracoEsquerdo(), avaliacao.getBracoDireito(), avaliacao.getPernaEsquerda(), avaliacao.getPernaDireito(), avaliacao.getCintura(), avaliacao.getAbdomen(), avaliacao.getBusto(), avaliacao.getPescoco(), avaliacao.getGorduraCorporal(), avaliacao.getBancoDeWells(), avaliacao.getAltura(), avaliacao.getPeso());
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
        System.out.printf("dados do aluno\nnome:%s\nCPF:%s\nRG:%s\nemail:%s\ntelefone:%s\ndata de nascimento:%s\n", aluno.getNome(), aluno.getCpf(), aluno.getRg(), aluno.getEmail(), aluno.getTelefone(), aluno.getDataDeNascimento());
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
        System.out.printf("nome da academia: %s\nendereço da academia: %s\nhorario de funcionamento da academia: %s\nalunos: ", academia.getNome(), academia.getEndereco(), academia.getHorarioDeFuncionamento());
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
                System.out.printf("%s", alunos.get(i).getNome());
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
        int id = lerId("gerenciar");
        while (true) {
            System.out.printf("O que você deseja fazer na academia %s?\n1-cadastrar aluno\n2-cadastrar funcionario\n3-cadastrar Area da academia\n4-Gerenciar Aluno\n5-gerenciar funcionário\n6-gerenciar área da academia\n", academias.get(id).getNome());
            int caso = LER.nextInt();
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
                case 7 -> {
                    limparTela();
                    return;
                }
            }
        }

    }

    public static void gerenciarArea(int id) {
        limparTela();
        Area area = buscarArea(id);
        limparTela();
        while (true) {
            System.out.printf("o que você deseja gerenciar na área %s\n1-nome\n2-exercícios\n3-fechar\n", area.getNome());
            int caso = LER.nextInt();
            limparTela();
            switch (caso) {
                case 1 ->
                    gerenciarNome(area);
                case 2 ->
                    gerenciarExercicios(area);
                case 3 -> {
                    limparTela();
                    return;
                }
            }
        }

    }

    public static void gerenciarExercicio(Area area) {
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
                    "o que deseja fazer?\n1-alterar nome do exercício\n2-alterar conjunto muscular alvo\n3-gerenciar musculos principais\n4-gerenciar musculos secundários\n5-alterar nivel de dificuldade\n6-fechar\n");
            int caso = LER.nextInt();
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
                case 6 -> {
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
            int caso = LER.nextInt();
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
            int caso = LER.nextInt();
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
            int caso = LER.nextInt();
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

    public static Area buscarArea(int id) {
        System.out.printf("qual área você deseja gerenciar:");
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
        } while (academias.get(id).buscarAreaPorNome(nome) == null);
        return academias.get(id).buscarAreaPorNome(nome);
    }

    public static void gerenciarFuncionario(int id) {
        limparTela();
        Funcionario funcionario = buscarFuncionario(id);
        limparTela();
        while (true) {
            limparTela();
            System.out.printf("O que você deseja gerenciar?\n1-área de atuação\n2-salário\n3-advertências\n4-fechar");
            int caso = LER.nextInt();
            limparTela();
            switch (caso) {
                case 1 ->
                    gerenciarAreaAtuacao(funcionario);
                case 2 ->
                    gerenciarSalario(funcionario);
                case 3 ->
                    gerenciarAdvertencias(funcionario);
                case 4 -> {
                    limparTela();
                    return;
                }
            }
        }

    }

    public static Funcionario buscarFuncionario(int id) {
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
        } while (academias.get(id).buscarFuncionarioPorNome(nome) == null);
        return academias.get(id).buscarFuncionarioPorNome(nome);
    }

    public static void gerenciarSalario(Funcionario funcionario) {
        while (true) {
            limparTela();
            System.out.printf("O que você deseja fazer?\n1-remover salário\n2-alterar salário\n3-fechar");
            int caso = LER.nextInt();
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
            System.out
                    .printf("O que você deseja fazer?\n1-remover área de atuação\n2-alterar área de atuação\n3-fechar");
            int caso = LER.nextInt();
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
        limparTela();
        Aluno aluno = buscarAluno(academias.get(id));
        limparTela();
        while (true) {
            limparTela();
            System.out.printf(
                    "O que você deseja gerenciar?\n1-objetivos\n2-avaliações físicas\n3-advertências\n4-fechar\n");
            int caso = LER.nextInt();
            switch (caso) {
                case 1 ->
                    gerenciarObjetivos(aluno);
                case 2 ->
                    gerenciarAvaliacoesFisicas(aluno);
                case 3 ->
                    gerenciarAdvertencias(aluno);
                case 4 -> {
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
            int caso = LER.nextInt();
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
                    "O que você deseja fazer?\n1-adicionar advertências\n2-remover advertências\n3-editar advertência\n4-fechar\n");
            int caso = LER.nextInt();
            switch (caso) {
                case 1 ->
                    adicionarAdvertencia(funcionario);
                case 2 ->
                    removerAdvertencia(funcionario);
                // case 3 -> editarAdvertencia(aluno);
                case 4 -> {
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

    public static void limparTela() {
        for (int i = 0; i < 40; ++i) {
            System.out.println();
        }
        System.out.print("\033\143");
    }
}
