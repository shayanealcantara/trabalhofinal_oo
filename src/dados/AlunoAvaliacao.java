package dados;

import java.util.ArrayList;

import main.Crud;
import servicos.Servicos;
import servicos.Valida;

public abstract class AlunoAvaliacao{
	
	private static ArrayList<Crud> notas = new ArrayList<>();
	
	public static void impimirAlunosAvs() {
		populaNotas();
		Servicos.imprimir(notas);
	}
	
	public static void cadastrarNotas() {
		
		Alunos aluno = new Alunos();
		Avaliacoes avaliacao = new Avaliacoes();
		float nota = 0f;
		
		populaNotas();
		
		aluno = (Alunos) Servicos.pesquisar(notas, "Digite a matricula do aluno que \nrecebera essa nota", aluno);
		
		avaliacao = (Avaliacoes) Servicos.pesquisar(notas, "Digite o nome da avaliacao que o "+aluno.getNome()+" conseguiu", avaliacao);
		
		nota = Valida.validaValor("Digite a nota do aluno "+aluno.getNome()+" recebeu na avaliacao "+avaliacao.getNome());
		avaliacao.setNotaAluno(nota);
		
		aluno.cadastraNotas(avaliacao);
		
	}	
	
	private static void populaNotas() {
		notas.clear();
		Alunos aluno = new Alunos();
		Avaliacoes avaliacao = new Avaliacoes();
		notas.addAll(avaliacao.getList());
		notas.addAll(aluno.getList());
	}
}
