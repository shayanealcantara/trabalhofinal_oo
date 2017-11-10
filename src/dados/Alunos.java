package dados;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JOptionPane;

import execoes.AlunoNull;
import execoes.MatricuaBarra;
import main.Crud;
import servicos.Leituras;
import servicos.Servicos;
import servicos.Valida;

//classe Alunos
public class Alunos implements Crud{
	
	//atributos
	private String nome;
	private String matricula;
	private Turma turma;
	private ArrayList<Avaliacoes> avaliacoes = new ArrayList<>();
	private static ArrayList<Crud> listAlunos = new ArrayList<>();
	
	//construtor padrão
	public Alunos() {
	}
	
	//metodo para cadastrar um aluno no array "a" de Alunos
	public static void cadastrar() {
		//criando o aluno para cadastrar no array "a" de Alunos
		Alunos aluno = new Alunos();
		
		/*Usando o setNome para colocar o nome no aluno, como parametro eu passo
		 * um metodo da classe Leitura q sempre me retorna uma String(nome)*/
		aluno.setNome(Leituras.lerString("Digite o Nome do Aluno"));
		
		/*Usando o setMatricula para colocar o matricula no aluno, como parametro eu passo
		 * um metodo da classe Leitura q sempre me retorna uma String(matricula)*/
		aluno.setMatricula(Valida.validaMatricula());
		
		//adicionando o aluno ao array
		listAlunos.add(aluno);
	}
	
	//metodo para pesquisar um aluno dentro do array "a" de Alunos que ja foi papulado
	public static Alunos pesquisarAlunos() {
		Alunos aluno = new Alunos();
		return (Alunos) Servicos.pesquisar(listAlunos, "Digite o nome do Aluno", aluno);
	}
	
	//metodo para excluir um aluno, do array "a" de Alunos
	public static void excluirAlunos() {
		Servicos.excluir(listAlunos, "Digite o nome do aluno para ser excluido");
	}
	
	//metodo para excluir um aluno, do array "a" de Alunos
	public static void imprimirAlunos() {
		Servicos.imprimir(listAlunos);
	}
	
	public void cadastraNotas(Avaliacoes av) {
		avaliacoes.add(av);
		System.out.println(avaliacoes.toString());
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
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}
	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	/**
	 * @return the turma
	 */
	public Turma getTurma() {
		return turma;
	}
	/**
	 * @param turma the turma to set
	 */
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 *
	 *Metodo que retorna uma String com as informaçoes do aluno, para serem printadas
	 *sobrescrita do metodo toString()*/
	@Override
	public String toString() {
		return "Aluno = " + nome + ", matricula = " + matricula + ", avaliacoes = " + avaliacoes;
	}	

	@Override
	public String pesquisar() {
		return this.getMatricula();
	}

	public ArrayList<Crud> getList() {
		return listAlunos;
	}	
}
