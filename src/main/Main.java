package main;

import dados.Alunos;
import dados.Avaliacoes;
import servicos.Leituras;

public class Main {
	public static void main(String[] args) {
		Alunos a = new Alunos();
		if(a.getNome()==null) {
			System.out.println("nome = "+a.getNome());
		}
			
	}
}
