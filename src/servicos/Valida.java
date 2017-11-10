package servicos;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JOptionPane;

import execoes.MatricuaBarra;
import execoes.MatriculaTamanho;
import execoes.ValorNulo;

//Classe de validações
public class Valida {
	
	//matodo para validar uma matricula de Aluno
	public static String validaMatricula() {
		
		//"texto" recebe uma String do metodo Leituras.lerString(), para ser a matricula
		String texto = Leituras.lerString("Digite a Matricula do Aluno, no formato ii/i");
		
		//condicoes de exeções
		try {
			
			/*condição de comparação para ver se a matricula tem todos
			 * os dígitos necessarios*/
			if (texto.length() != 4) {
				
				//se a condição for satisfeita, dispara a exeção MatriculaTamanho
				throw new MatriculaTamanho();
			}
			
			//"barra" recebe o char que esta na posição 2 da String texto
			char barra = texto.charAt(2);
			
			/*condição de comparação para ver se a matricula contem a barra("/") 
			 * no lugar certo*/
			if (barra != '/') {
				
				//se a condição for satisfeita, dispara a exeção MatricuaBarra
				throw new MatricuaBarra();
			}
			
		//tratamento das exeções
			
		//se a exeção MatriculaTamanho for disparada
		} catch (MatriculaTamanho e) {
			
			//janela com mensagem do erro
			JOptionPane.showMessageDialog(null, "matricula com tamanho errado");
			
			//chamando esse metodo de novo, para validar uma nova matricula
			validaMatricula();
			
		} catch (MatricuaBarra e) {
			
			//janela com mensagem do erro
			JOptionPane.showMessageDialog(null, "matricula sem a /");
			
			//chamando esse metodo de novo, para validar uma nova matricula
			validaMatricula();
			
		}
		
		//o retorno da matricula(texto) depois de ser validada
		return texto;
	}
	
	public static float validaValor(String tipo) {
		
		//"texto" recebe uma String do metodo Leituras.lerString(), para ser o valor
		String texto = Leituras.lerString("Digite o "+tipo+" desta avaliação");
		
		Float valor = 0f;
		
		
		//condicoes de exeções
		try {
			
			//tranformado a string text em um numero float
			valor = Float.parseFloat(texto);
			
			/*condição de comparação para ver se valor é nulo
			 * ou negativo*/
			if (valor <= 0) {
				
				//se a condição for satisfeita, dispara a exeção ValorNulo
				throw new ValorNulo();
			}
			
			
		//tratamento das exeções
			
		//se a exeção ValorNulo for disparada
		} catch (ValorNulo e) {
			
			//janela com mensagem do erro
			JOptionPane.showMessageDialog(null, "Valor digitado é nulo ou negativo ");
			
			//chamando esse metodo de novo, para validar uma nova valor
			validaValor(tipo);
			
		} catch (Throwable e) {
			//janela com mensagem do erro
			JOptionPane.showMessageDialog(null, "Valor nao é valido ");
			
			//chamando esse metodo de novo, para validar uma nova valor
			validaValor(tipo);
		}
		
		//o retorno da valor depois de ser validada
		return valor;

	}
}
