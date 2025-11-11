import java.util.Scanner;
import java.util.HashMap;

public class CRUD {
    static Scanner LER = new Scanner(System.in);

    public static Exercicio adicionarMusculoSecundario(Exercicio exercicio) {
        CRUD.limparTela();
        try {
            System.out.printf("qual é o nome do músculo?:");
            LER.nextLine();
            exercicio.addMusculoSecundario(LER.nextLine());
            CRUD.limparTela();
            System.out.println("Musculo adicionado com sucesso :)");
        } catch (Exception e) {
            limparTela();
            System.out.println("esta ação não pode ser concluida!");
        }

        return exercicio;
    }

    public static Exercicio removerMusculoPrincipal(Exercicio exercicio) {
        CRUD.limparTela();
        try {
            System.out.printf("qual músculo deseja remover?:");
            LER.nextLine();
            exercicio.removeMusculoPrincipal(LER.nextLine());
            CRUD.limparTela();
            System.out.println("Musculo removido com sucesso :)");
        } catch (Exception e) {
            System.out.println("esta ação não pode ser concluida!");
        }
        return exercicio;
    }

    public static Exercicio adicionarMusculoPrincipal(Exercicio exercicio) {
        CRUD.limparTela();
        try {
            System.out.printf("qual é o nome do músculo?:");
            LER.nextLine();
            exercicio.addMusculoPrincipal(LER.nextLine());
            CRUD.limparTela();
            System.out.println("Musculo adicionado com sucesso :)");
        } catch (Exception e) {
            System.out.println("Esta ação não pode ser concluida!");
        }
        return exercicio;
    }

    public static Exercicio alterarNivelDeDificuldade(Exercicio exercicio) {
        CRUD.limparTela();
        try {
            System.out.printf("qual o novo nível de dificuldade?:");
            LER.nextLine();
            exercicio.setNivelDedificuldade(LER.nextLine());
            limparTela();
        } catch (Exception e) {
            limparTela();
            System.out.println("esta ação não pode ser concluida!");
        }
        return exercicio;
    }

    public static Exercicio alterarConjuntoMuscularAlvo(Exercicio exercicio) {
        CRUD.limparTela();
        try {
            System.out.printf("qual o novo conjunto muscular alvo?:");
            LER.nextLine();
            exercicio.setConjuntoMuscularAlvo(LER.nextLine());
            limparTela();
        } catch (Exception e) {
            limparTela();
            System.out.println("esta ação não pode ser concluida!");
        }
        return exercicio;
    }

    public static Exercicio alterarNome(Exercicio exercicio) {
        CRUD.limparTela();
        System.out.printf("qual o novo nome do exercício?:");
        try {
            LER.nextLine();
            exercicio.setNome(LER.nextLine());
        } catch (Exception e) {
            System.out.println("esta ação não pode ser concluida!");
        }
        return exercicio;
    }

    public static Area removerExercicio(Area area) {
        CRUD.limparTela();
        System.out.printf("qual exercício deseja remover?:");
        try {
            String nome = LER.nextLine();
            area.removeExercicios(area.procurarExercicioPorNome(nome));
        } catch (Exception e) {
            System.out.println("essa ação não pode ser concluida!");
        }
        return area;
    }

    public static Area adicionarExercicio(Area area) {
        CRUD.limparTela();
        System.out.printf("nome do exercício:");
        LER.nextLine();
        String nome = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("conjunto muscular alvo:");
        String conjuntoMuscularAlvo = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("nível de dificuldade do exercício:");
        String nivelDeDificuldade = LER.nextLine();
        CRUD.limparTela();
        area.addExercicio(new Exercicio(nome, conjuntoMuscularAlvo, null, null, nivelDeDificuldade));
        System.out.println("exercício adicionado com sucesso :)");
        return area;
    }

    public static Area gerenciarNome(Area area) {
        CRUD.limparTela();
        System.out.printf("novo nome:");
        try {
            LER.nextLine();
            area.setNome(LER.nextLine());
        } catch (Exception e) {
            System.out.println("essa ação não pode ser concluida!");
        }
        return area;
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

    public static Funcionario removerAdvertencia(Funcionario funcionario) {
        System.out.printf("Qual advertência você deseja remover?(id):");
        try {
            funcionario.removeAdvertencias(LER.nextInt());
        } catch (Exception e) {
            System.out.println("não foi possivel realizar esta ação!");
        }
        return funcionario;
    }

    public static Funcionario adicionarAdvertencia(Funcionario funcionario) {
        CRUD.limparTela();
        System.out.printf("id da advertência:");
        int id = LER.nextInt();
        CRUD.limparTela();
        System.out.printf("motivo da advertência:");
        LER.nextLine();
        String motivo = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("penalidade da advertência:");
        String penalidade = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("data da advertência:");
        String data = LER.nextLine();
        CRUD.limparTela();
        funcionario.addAdvertencia(new Advertencia(id, motivo, penalidade, data));
        System.out.println("advertência adicionada com sucesso :)");
        return funcionario;
    }

    public static Aluno removerAdvertencia(Aluno aluno) {
        System.out.printf("Qual advertência você deseja remover?(id):");
        try {
            aluno.removeAdvertencias(LER.nextInt());
        } catch (Exception e) {
            System.out.print("não é possivel concluir esta operação!\n");
        }
        return aluno;
    }

    public static Aluno adicionarAdvertencia(Aluno aluno) {
        CRUD.limparTela();
        System.out.printf("id da advertência:");
        int id = LER.nextInt();
        CRUD.limparTela();
        System.out.printf("motivo da advertência:");
        LER.nextLine();
        String motivo = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("penalidade da advertência:");
        String penalidade = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("data da advertência:");
        String data = LER.nextLine();
        CRUD.limparTela();
        aluno.addAdvertencia(new Advertencia(id, motivo, penalidade, data));
        System.out.println("advertência adicionada com sucesso :(");
        return aluno;
    }

    public static Aluno editarAtributos(Aluno aluno) {
        CRUD.limparTela();
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
        System.out.printf("Data de nascimento atual: %s\nNova data (ou Enter para manter): ",
                aluno.getDataDeNascimento());
        String data = LER.nextLine();
        if (!data.isEmpty()) {
            aluno.setDataDeNascimento(data);
        }
        System.out.printf("Necessidade especial atual: %s\nNova necessidade (ou Enter para manter): ",
                aluno.getNecessidadeEspecial());
        String necessidade = LER.nextLine();
        if (!necessidade.isEmpty()) {
            aluno.setNecessidadeEspecial(necessidade);
        }
        System.out.printf("Objetivo atual: %s\nNovo objetivo (ou Enter para manter): ", aluno.getObjetivo());
        String objetivo = LER.nextLine();
        if (!objetivo.isEmpty()) {
            aluno.setObjetivo(objetivo);
        }
        CRUD.limparTela();
        System.out.println("Atributos atualizados!");
        return aluno;
    }

    public static Funcionario editarAtributos(Funcionario funcionario) {
        CRUD.limparTela();
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
        System.out.printf("Data de nascimento atual: %s\nNova data (ou Enter para manter): ",
                funcionario.getDataDeNascimento());
        String data = LER.nextLine();
        if (!data.isEmpty()) {
            funcionario.setDataDeNascimento(data);
        }
        System.out.printf("Necessidade especial atual: %s\nNova necessidade (ou Enter para manter): ",
                funcionario.getNecessidadeEspecial());
        String necessidade = LER.nextLine();
        if (!necessidade.isEmpty()) {
            funcionario.setNecessidadeEspecial(necessidade);
        }
        System.out.printf("Área de atuação atual: %s\nNova área (ou Enter para manter): ",
                funcionario.getAreaAtuacao());
        String area = LER.nextLine();
        if (!area.isEmpty()) {
            funcionario.setAreaAtuacao(area);
        }
        System.out.printf("Salário atual: %s\nNovo salário (ou Enter para manter): ", funcionario.getSalario());
        String salario = LER.nextLine();
        if (!salario.isEmpty()) {
            funcionario.setSalario(salario);
        }
        CRUD.limparTela();
        System.out.println("Atributos atualizados!");
        return funcionario;
    }

    public static Area editarAtributos(Area area) {
        CRUD.limparTela();
        System.out.println("Editar atributos da área:");
        System.out.printf("Nome atual: %s\nNovo nome (ou Enter para manter): ", area.getNome());
        LER.nextLine();
        String nome = LER.nextLine();
        if (!nome.isEmpty()) {
            area.setNome(nome);
        }
        CRUD.limparTela();
        System.out.println("Atributos atualizados!");
        return area;
    }

    public static Exercicio editarAtributos(Exercicio exercicio) {
        CRUD.limparTela();
        System.out.println("Editar atributos do exercício:");
        System.out.printf("Nome atual: %s\nNovo nome (ou Enter para manter): ", exercicio.getNome());
        LER.nextLine();
        String nome = LER.nextLine();
        if (!nome.isEmpty()) {
            exercicio.setNome(nome);
        }
        System.out.printf("Conjunto muscular alvo atual: %s\nNovo conjunto (ou Enter para manter): ",
                exercicio.getConjuntoMuscularAlvo());
        String conjunto = LER.nextLine();
        if (!conjunto.isEmpty()) {
            exercicio.setConjuntoMuscularAlvo(conjunto);
        }
        System.out.printf("Nível de dificuldade atual: %s\nNovo nível (ou Enter para manter): ",
                exercicio.getNivelDedificuldade());
        String nivel = LER.nextLine();
        if (!nivel.isEmpty()) {
            exercicio.setNivelDedificuldade(nivel);
        }
        CRUD.limparTela();
        System.out.println("Atributos atualizados!");
        return exercicio;
    }

    public static Aluno removerAvaliacaoFisica(Aluno aluno) {
        System.out.printf("qual avaliação física você deseja remover?(id):");
        aluno.removeAvaliacaoFisica(LER.nextInt());
        return aluno;
    }

    public static Aluno adicionarAvaliacaoFisica(Aluno aluno) {
        CRUD.limparTela();
        System.out.printf("id da avaliação física:");
        int id = LER.nextInt();
        CRUD.limparTela();
        System.out.printf("braço esquerdo do aluno(cm):");
        LER.nextLine();
        String bracoEsquerdo = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("braço direito do aluno(cm):");
        String bracoDireito = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("perna esquerda do aluno(cm):");
        String pernaEsquerda = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("perna direita do aluno(cm):");
        String pernaDireito = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("cintura do aluno(cm):");
        String cintura = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("abdomen do aluno(Cm):");
        String abdomen = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("busto do aluno(cm):");
        String busto = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("pescoço do aluno(cm):");
        String pescoco = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("gordura gorporal(%%):");
        String gorduraCorporal = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("banco de wells(cm):");
        String bancoDeWells = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("altura do aluno(cm):");
        String altura = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("peso do aluno(kg):");
        String peso = LER.nextLine();
        CRUD.limparTela();
        aluno.addAvaliacaoFisica(new AvaliacaoFisica(bracoEsquerdo, bracoDireito, pernaEsquerda, pernaDireito, cintura,
                abdomen, busto, pescoco, gorduraCorporal, bancoDeWells, altura, peso, id));
        System.out.println("avaliação física adicionada com sucesso :)");
        return aluno;
    }

    public static Academia editarAtributos(Academia academia) {
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
        System.out.printf("Horário atual: %s\nNovo horário (ou Enter para manter): ",
                academia.getHorarioDeFuncionamento());
        String horario = LER.nextLine();
        if (!horario.isEmpty()) {
            academia.setHorarioDeFuncionamento(horario);
        }
        limparTela();
        System.out.println("Atributos atualizados!");
        return academia;
    }

    public static Academia cadastrarArea(Academia academia) {
        CRUD.limparTela();
        System.out.printf("qual o nome da área?:");
        LER.nextLine();
        String nome = LER.nextLine();
        CRUD.limparTela();
        academia.addArea(new Area(nome, null));
        System.out.println("área adicionada com sucesso:)");
        return academia;
    }

    public static Academia cadastrarFuncionario(Academia academia) {
        CRUD.limparTela();
        System.out.print("nome do funcionário:");
        LER.nextLine();
        String nome = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("CPF do funcionário:");
        String cpf = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("RG do funcionário:");
        String rg = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("email do funcionário:");
        String email = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("telefone do funcionário:");
        String telefone = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("data de nascimento do funcionário:");
        String dataDeNascimento = LER.nextLine();
        CRUD.limparTela();
        String necessidadeEspecial = verificarNecessidadeEspecial("funcionário");
        CRUD.limparTela();
        System.out.printf("area de atuação do funcionário:");
        String areaAtuacao = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("salário do funcionário:");
        String salario = LER.nextLine();
        CRUD.limparTela();
        academia.addFuncionario(new Funcionario(nome, cpf, rg, email, telefone, dataDeNascimento, areaAtuacao,
                salario, necessidadeEspecial, null));
        System.out.println("funcionário adicionado com sucesso :)");
        return academia;
    }

    public static Academia cadastrarAluno(Academia academia) {
        CRUD.limparTela();
        System.out.print("nome do aluno:");
        LER.nextLine();
        String nome = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("CPF do aluno:");
        String cpf = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("RG do aluno:");
        String rg = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("email do aluno:");
        String email = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("telefone do aluno:");
        String telefone = LER.nextLine();
        CRUD.limparTela();
        System.out.printf("data de nascimento do aluno:");
        String dataDeNascimento = LER.nextLine();
        CRUD.limparTela();
        String necessidadeEspecial = verificarNecessidadeEspecial("aluno");
        CRUD.limparTela();
        System.out.printf("objetivo do aluno:");
        String objetivo = LER.nextLine();
        CRUD.limparTela();
        academia.addAluno(new Aluno(nome, cpf, rg, email, telefone, dataDeNascimento, objetivo, necessidadeEspecial));
        System.out.println("aluno adicionado com sucesso :)");
        return academia;
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
            System.out.printf("necessidade especial do %:", pessoa);
            LER.nextLine();
            necessidadeEspecial = LER.nextLine();
        } else {
            necessidadeEspecial = null;
            LER.nextLine();
        }
        return necessidadeEspecial;
    }

    public static void mostrarAcademiasExistentes(HashMap<Integer, Academia> academias) {
        if (academias.isEmpty()) {
            System.out.println("Cadastre uma academia antes!");
            return;
        }
        for (Integer chave : academias.keySet()) {
            System.out.printf("id: %d | nome: %s\n", chave, academias.get(chave).getNome());
        }
        LER.nextLine();
        LER.nextLine();
        limparTela();
    }

    public static HashMap<Integer, Academia> criarAcademia(HashMap<Integer, Academia> academias) {
        System.out.printf("id único da academia:");
        int id = LER.nextInt();
        LER.nextLine();
        String nome = lerCampoObrigatorio("Nome da academia:");
        limparTela();
        String endereco = lerCampoObrigatorio("endereço da academia:");
        limparTela();
        String horarioDeFuncionamento = lerCampoObrigatorio("horário de funcionamento da academia:");
        limparTela();
        academias.put(id, new Academia(nome, endereco, horarioDeFuncionamento, null, null, null));
        System.out.printf("academia criada com sucesso:)\n");
        return academias;
    }

    public static String lerCampoObrigatorio(String mensagem) {
        String valor = "";
        do {
            System.out.print(mensagem);
            valor = LER.nextLine();
            if (valor.isBlank()) {
                System.out.println("Campo obrigatório! Digite novamente.");
            }
        } while (valor.isBlank());
        return valor;
    }

    public static void limparTela() {
        for (int i = 0; i < 40; ++i) {
            System.out.println();
        }
        System.out.print("\033\143");
    }
}