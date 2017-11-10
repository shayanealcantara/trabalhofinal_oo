package servicos;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import execoes.ListaVazia;
import execoes.NaoEncontrado;
import main.Crud;

public class Servicos {
	
	public static void imprimir(ArrayList<Crud> a) {
		
		try {
			if(a.isEmpty()) {
				throw new ListaVazia();
			}else {
				for (Crud interface1 : a) {
					System.out.println(interface1.toString());
				}
			}
		} catch (ListaVazia e) {
			JOptionPane.showMessageDialog(null, "Lista Vazia!");
		}

	}
	
	public static Crud pesquisar(ArrayList<Crud> a, String tipo, Crud i) {
		
		String nome = Leituras.lerString(tipo);
		i = null;
		
		try {
			
			if(a.isEmpty()) {
				throw new ListaVazia();
			}
			
			for (Crud interface1 : a) {
				if(interface1.pesquisar().equals(nome)) {
					i = interface1;
				}
			}
			
			if (i == null) {
				throw new NaoEncontrado();
			}
			
		} catch (ListaVazia e) {
			
			JOptionPane.showMessageDialog(null, "Lista Vazia!");
			
		} catch (NaoEncontrado e) {
			
			JOptionPane.showMessageDialog(null, "Nao foi encontrado \n tente novamente");
			
			pesquisar(a, tipo, i);
		}
		
		return i;
	}
	
	public static void excluir(ArrayList<Crud> a, String tipo) {
		
		String nome = Leituras.lerString(tipo);
		
		for (Crud interface1 : a) {
			if(interface1.pesquisar().equals(nome)) {
				a.remove(interface1);
			}
		}
	}
}
