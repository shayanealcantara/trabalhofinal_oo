package frames;

import javax.swing.JOptionPane;

import execoes.TextoBranco;

public class ValidaFrameAluno {
	//metodo para ler e retornar uma String
	public static boolean lerString(String tipo) {
		
		//condicoes de exeções
		try {
			
			/*condição de comparação para ver se a string esta em branco,
			 * ou se tem apenas espaço*/
			if (tipo.isEmpty() || tipo.equals(" ")) {
				
				//se a condição for satisfeita, dispara a exeção TextoBranco
				throw new TextoBranco();
			}else {
				//o retorno da String depois de ser validada
				return true;
			}
		
		//tratamento das exeções
			
			//se a exeção TextoBranco for disparada
		} catch (TextoBranco e) {
			
			//janela com mensagem do erro
			JOptionPane.showMessageDialog(null, "Texto Vazio");
			
			return false;
			
		} catch (NullPointerException e) {
			//janela com mensagem do erro
			JOptionPane.showMessageDialog(null, "Texto Vazio");
			
			return false;
		}
	}
}
