package com.loiane.cursojava.aula36.labs02refactor;
import java.util.Scanner;
public class Teste {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Professor wagner = new Professor();
        wagner.setNome("Wagner");
        wagner.setDepartamento("TI");
        wagner.setEmail("email@email.com");

        Curso ads = new Curso();
        ads.setNome("Análise e Desenvolvimento de Sistemas");
        ads.setHorario("Noturno");
        ads.setProfessor(wagner);

        Aluno[] alunos = new Aluno[5];
        String nome;
        int matricula;

        for (int i = 0; i < alunos.length; i++) {
            System.out.println("Entre com as informações do aluno: " + (i + 1));
            System.out.print("Digite o nome: ");
            nome = scan.nextLine();

            System.out.print("Digite a matrícula: ");
            matricula = scan.nextInt();

            double[] notas = new double[4];
            for (int j = 0; j < notas.length; j++) {
                System.out.print("Digite a nota " + (j + 1) + " : ");
                notas[j] = scan.nextDouble();
            }

            Aluno a = new Aluno();
            a.setNome(nome);
            a.setMatricula(matricula);
            a.setNotas(notas);

            alunos[i] = a;
        }

        ads.setAlunos(alunos);

        int contador = 1;
        double mediaTurma = 0;
        for(Aluno a: alunos){
            double media = 0;
            double[] notas = a.getNotas();
            for (int i = 0; i < notas.length; i++) {
                media += notas[i];
            }
            System.out.printf("A média do aluno %d é: %.2f%n%s", contador, media, media >= 7 ? "Aprovado" : "Reprovado");
            contador++;
            mediaTurma += media;
        }
        System.out.println("Média da turma é igual a: " + (mediaTurma / contador));
    }
}