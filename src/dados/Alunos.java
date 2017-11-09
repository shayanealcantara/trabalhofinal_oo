package dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import execoes.AlunoNull;
import execoes.MatricuaBarra;
import servicos.Leituras;
import servicos.Valida;

//classe Alunos
public class Alunos {
	
	//atributos
	private String nome;
	private String matricula;
	private Turma turma;
	private static ArrayList<Alunos> a = new ArrayList<>();
	
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
		a.add(aluno);
	}
	
	//metodo para pesquisar um aluno dentro do array "a" de Alunos que ja foi papulado
	public static Alunos pesquisarAlunos() {
		
		/*cria uma janela para pegar a matricula para ser pesquisada, "busca" recebe
		 * um metodo da classe Leitura q sempre me retorna uma String(matricula)*/
		String busca = Valida.validaMatricula();
		
		//crinado um aluno auxiliar para receber o aluno encontrado
		Alunos aux = new Alunos();
		
		//condicoes de exeções
		try {
			
			/*uma laço de repetição foreach, para comparar entro todos os alunos do array "a" de Alunos,
			 * qual que tem a matricula == "busca"*/
			for (Alunos alunos : a) {
				
				//condição de comparação entre a matricula(alunos.getMatricula()) do aluno com a "busca"
				if (alunos.getMatricula().equals(busca)) {
					
					//se a condição for satisfeita, aux recebe aluno
					aux = alunos;

				}
			}
			
			/*condição de comparação, se o aluno não for encontrado no laço, então,
			 *o nome do aluno auxiliar sera null, pois não recebeu nada ainda,
			 *entao ele nao exite no array*/
			if(aux.getNome() == null) {
				
				//se a condição for satisfeita, dispara a exeção AlunoNull
				throw new AlunoNull();
			}
		
		//tratamento das exeções
			
		//se a exeção MatriculaTamanho for disparada
		} catch (AlunoNull e) {
			
			//janela com mensagem do erro
			JOptionPane.showMessageDialog(null, "Aluno nao existe \n Tente Novamente");
			
			//chamando esse metodo de novo
			pesquisarAlunos();
		}
		return aux;
	}
	
	//metodo para excluir um aluno, do array "a" de Alunos
	public static void excluirAlunos() {
		
		//"excluir" recebe um aluno com a matricula igual a que se quer excluir
		Alunos excluir = pesquisarAlunos();
		
		try {
			if(excluir.getNome() == null) {
				throw new AlunoNull();
			}else {
				//removendo esse aluno(excluir)
				a.remove(excluir);
				
				//janela com a mensagem de confirmação de exclusao do aluno(excluir)
				JOptionPane.showMessageDialog(null, excluir.toString()+" \n Foi excluido");
			}
		} catch (AlunoNull e) {
			JOptionPane.showMessageDialog(null, "Aluno nao existe \n Tente Novamente");
			excluirAlunos();
		}
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
		return "Aluno:" + this.getNome() + ", matricula = " + this.getMatricula();
	}
}
