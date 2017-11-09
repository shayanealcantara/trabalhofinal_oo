package dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import execoes.AlunoNull;
import execoes.AvaliacaoNull;
import servicos.Leituras;
import servicos.Valida;

//classe Avaliacoes
public class Avaliacoes {
	
	//atributos
	private String nome;
	private float valor;
	private float peso;
	private static ArrayList<Avaliacoes> avaliacoes = new ArrayList<>();
	
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
		//adicionando o aluno ao array
		avaliacoes.add(avaliacao);
	}
	
	//metodo para pesquisar uma avaliação dentro do array "avaliacoes" de Avaliacoes que ja foi papulado
	public Avaliacoes pesquisarAvaliacao() {

		/*cria uma janela para pegar a matricula para ser pesquisada, "busca" recebe
		 * um metodo da classe Leitura q sempre me retorna uma String(matricula)*/
		String busca = Leituras.lerString("Digite a avaliacao pra pesquisa");
		
		
		//crinado uma avaliação auxiliar para receber a avaliação encontrada
		Avaliacoes aux = new Avaliacoes();
		
		//condicoes de exeções
		try {
			
			/*Uma laço de repetição foreach, para percorrer todas as avaliacoes
			 *do array "avaliacoes" de Avaliacoes*/
			for (Avaliacoes av : avaliacoes) {
				
				//condição de comparação entre o nome da avaliação com a "busca"
				if (av.getNome().equals(busca)) {
					
					//se a condição for satisfeita, aux recebe av
					aux = av;

				}
			}
			
			/*condição de comparação, se a avaliação não for encontrado no laço, então,
			 *o nome da avaliação auxiliar sera null, pois não recebeu nada ainda,
			 *entao ele nao exite no array*/
			if(aux.getNome() == null) {
				
				//se a condição for satisfeita, dispara a exeção AvaliacaoNull
				throw new AvaliacaoNull();
			}
		
		//tratamento das exeções
			
		//se a exeção AvaliacaoNull for disparada
		} catch (AvaliacaoNull e) {
			
			//janela com mensagem do erro
			JOptionPane.showMessageDialog(null, "Acaliacao nao existe \n Tente Novamente");
			
			//chamando esse metodo de novo
			pesquisarAvaliacao();
		}
		return aux;
	}
		
	//metodo para excluir um Avaliacao, do array "avaliacoes" de Avaliacao
	public void excluirAvaliacao() {
		
		//"excluir" recebe um aluno com a matricula igual a que se quer excluir
		Avaliacoes excluir = pesquisarAvaliacao();
		
		try {
			
			//condição de comparação para ver se consegue remover essa avaliacao(excluir)
			if(!avaliacoes.remove(excluir)) {
				
				//se a condição for satisfeita, dispara a exeção AvaliacaoNull
				throw new AvaliacaoNull();
				
			}else {
				
				//janela com a mensagem de confirmação de exclusao da avaliacao(excluir)
				JOptionPane.showMessageDialog(null, excluir.toString()+" \n Foi excluido");
				
			}
		
		//tratamento das exeções
		
		//se a exeção AvaliacaoNull for disparada	
		} catch (AvaliacaoNull e) {
			
			//janela com mensagem do erro
			JOptionPane.showMessageDialog(null, "Acaliacao nao existe \n Tente Novamente");
			
			//chamando esse metodo de novo
			excluirAvaliacao();
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Avaliacoes: " + this.getNome() + ", valor = " + this.getValor() + ", peso = " + this.getPeso() + "]";
	}
}
