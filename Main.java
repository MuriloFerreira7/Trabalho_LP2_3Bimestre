import classes.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    final static Scanner LER = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.printf("o que você deseja fazer?\n");
        System.out.println("1- criar uma academia");
        System.out.println("2- fechar");
        if (LER.nextInt() == 2) {
            return;
        }
        System.out.print("Nome da academia: ");
        String nome = LER.next();
        System.out.print("\nendereço da academia: ");
        String endereco = LER.next();
        System.out.print("\nhorario de funcionamento: ");
        String horarioDeFuncionamento = LER.next();
        System.out.println();
        Academia academia = criarAcademia(nome, endereco, horarioDeFuncionamento, null, null, null);
        System.out.println("O que você deseja fazer?\n1-cadastrar aluno\n2-cadastrar funcionario\n3-cadastrar Area da academia\n4-Registrar exercicio\n");

        /* 
        academia.addAluno(new Aluno("Murilo Ferreira", "162.364.939-01", "29.011.789-6", "muriloferreira1410@gmail.com", "+55(45)99959-3757", "14/10/2009", "hipertrofia", null));
        academia.addFuncionario(new Funcionario("supinalda", "556.011.490-11", "33.913.647-9", "Ester.rodrigues@gmail.com", "+55(45)99721-66526", "08/09/1976", "personal treiner", "10.000R$", null, null));
        academia.addArea(new Area("musculação", null));

        Area musculacao = academia.buscarAreaPorNome("musculação");
        musculacao.addExercicio(new Exercicio("supino inclinado com alteres", "peitoral", null, null, "muito difícil"));
        
        Exercicio supinoInclinadoComAlteres = musculacao.procurarExercicioPorNome("supino inclinado com alteres");
        supinoInclinadoComAlteres.addMusculoPrincipal("peitoral maior");
        supinoInclinadoComAlteres.addMusculoPrincipal("peitoral menor");
        supinoInclinadoComAlteres.addMusculoPrincipal("subclávio");
        supinoInclinadoComAlteres.addMusculoPrincipal("serrátil anterior");
        supinoInclinadoComAlteres.addMusculoSecundario("tríceps braquial");
        supinoInclinadoComAlteres.addMusculoSecundario("deltóide Anterior");

        Aluno murilo = academia.buscarAlunoPorNome("Murilo Ferreira");
        murilo.addAdvertencia(new Advertencia("defecar no mictório", "suspensão de 1 semana"));//dando uma advertência para o aluno "Murilo Ferreira"
        murilo.addAvaliacaoFisica(new AvaliacaoFisica("38cm", "39cm", "67cm", "66cm", "79cm", "80cm", "102cm", "39cm", "12%", "78cm", "176cm", "82kg"));//adicionando uma avaliação física para o aluno Murilo Ferreira
        */
    }

    public static Academia criarAcademia(String nome, String endereco, String horarioDeFuncionamento, ArrayList<Aluno> alunos, ArrayList<Funcionario> funcionarios, ArrayList<Area> areas) {
        Academia academia = new Academia(nome, endereco, horarioDeFuncionamento, alunos, funcionarios, areas);
        return academia;
    }
}
