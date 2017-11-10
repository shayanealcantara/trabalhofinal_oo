package dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import execoes.AlunoNull;
import execoes.AvaliacaoNull;
import main.Crud;
import servicos.Leituras;
import servicos.Servicos;
import servicos.Valida;

//classe Avaliacoes
public class Avaliacoes implements Crud {
	
	//atributos
	private String nome;
	private float valor;
	private float peso;
	private float notaAluno;
	private static ArrayList<Crud> avaliacoes = new ArrayList<>();
	
	public Avaliacoes() {
		// TODO Auto-generated constructor stub
	}

	//metodo para cadastrar um aluno no array "a" de Alunos
	public static void cadastrarAvaliacao() {
		//criando o avaliacao para cadastrar no array "a" de Alunos
		Avaliacoes avaliacao = new Avaliacoes();
		
		/*Usando o setNome para colocar o nome no aluno, como parametro eu passo
		 * um metodo da classe Leitura q sempre me retorna uma String(nome)*/
		avaliacao.setNome(Leituras.lerString("Digite o Nome da Avaliação"));
		
		/*Usando o setMatricula para colocar o matricula no aluno, como parametro eu passo
		 * um metodo da classe Leitura q sempre me retorna uma String(matricula)*/
		avaliacao.setValor(Valida.validaValor("valor"));
		
		
		avaliacao.setPeso(Valida.validaValor("peso"));
		
		//adicionando a avaliacao ao array
		avaliacoes.add(avaliacao);
	}
	
	//metodo para pesquisar uma avaliação dentro do array "avaliacoes" de Avaliacoes que ja foi papulado
	public Avaliacoes pesquisarAvaliacao() {
		Avaliacoes av = new Avaliacoes();
		return (Avaliacoes) Servicos.pesquisar(avaliacoes, "Digite a avaliação", av);
	}
	
		
	//metodo para excluir um Avaliacao, do array "avaliacoes" de Avaliacao
	public void excluirAvaliacao() {
		Servicos.excluir(avaliacoes, "Nome da avaliacao, para ser excluida");
	}

	//metodo para imprimir um Avaliacao, do array "avaliacoes" de Avaliacao
	public static void imprimirAvaliacao() {
		Servicos.imprimir(avaliacoes);
	}

	
	//metodos get's e set's
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the valor
	 */
	public float getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}
	/**
	 * @return the peso
	 */
	public float getPeso() {
		return peso;
	}
	/**
	 * @param peso the peso to set
	 */
	public void setPeso(float peso) {
		this.peso = peso;
	}
	/**
	 * @return the notaAluno
	 */
	public float getNotaAluno() {
		return notaAluno;
	}

	/**
	 * @param notaAluno the notaAluno to set
	 */
	public void setNotaAluno(float notaAluno) {
		this.notaAluno = notaAluno;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Avaliacoes: " + this.getNome() + ", valor = " + this.getValor() + ", peso = " + this.getPeso() + "]";
	}
	
	//colocando o metodo pesquisar, vindo da interface
	@Override
	public String pesquisar() {
		return this.getNome();
	}

	@Override
	public ArrayList<Crud> getList() {
		return avaliacoes;
	}
}
