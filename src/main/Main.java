package main;

import dados.AlunoAvaliacao;
import dados.Alunos;
import dados.Avaliacoes;

public class Main {
	public static void main(String[] args) {
		
		
		Alunos.cadastrar();
		Alunos.cadastrar();
		Alunos.cadastrar();
		
		Avaliacoes.cadastrarAvaliacao();
		Avaliacoes.cadastrarAvaliacao();
		
		AlunoAvaliacao.impimirAlunosAvs();
		
		AlunoAvaliacao.cadastrarNotas();
		
		AlunoAvaliacao.impimirAlunosAvs();
		
	}
}
