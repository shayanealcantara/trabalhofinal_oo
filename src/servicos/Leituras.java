package servicos;

import javax.swing.JOptionPane;

import execoes.TextoBranco;

//Classe para fazer leituras de 
public class Leituras {
	
	//metodo para ler e retornar uma String
	public static String lerString(String tipo) {
		
		//janela para receber uma String
		String texto = JOptionPane.showInputDialog(tipo);
		
		//condicoes de exeções
		try {
			
			/*condição de comparação para ver se a string esta em branco,
			 * ou se tem apenas espaço*/
			if (texto.isEmpty() || texto.equals(" ")) {
				
				//se a condição for satisfeita, dispara a exeção TextoBranco
				throw new TextoBranco();
			}
		
		//tratamento das exeções
			
			//se a exeção TextoBranco for disparada
		} catch (TextoBranco e) {
			
			//janela com mensagem do erro
			JOptionPane.showMessageDialog(null, "Texto Vazio");
			
			//chamando esse metodo de novo, para validar a string novamente
			lerString(tipo);
		}

		//o retorno da String depois de ser validada
		return texto;
	}

}
