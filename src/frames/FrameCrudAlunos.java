package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameCrudAlunos {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCrudAlunos window = new FrameCrudAlunos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameCrudAlunos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[450px]", "[45px][45px][45px][45px][45px][45px]"));
		
		JButton btnNewButton = new JButton("Cadastrar Aluno");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameAlunos.main(null);
			}
		});
		frame.getContentPane().add(btnNewButton, "cell 0 0,grow");
		
		JButton btnNewButton_1 = new JButton("Excluir Aluno");
		frame.getContentPane().add(btnNewButton_1, "cell 0 1,grow");
		
		JButton btnNewButton_2 = new JButton("Adicionar Avaliação");
		frame.getContentPane().add(btnNewButton_2, "cell 0 2,grow");
		
		JButton btnNewButton_3 = new JButton("Editar Aluno");
		frame.getContentPane().add(btnNewButton_3, "cell 0 3,grow");
		
		JButton btnNewButton_4 = new JButton("Pesquisar Aluno");
		frame.getContentPane().add(btnNewButton_4, "cell 0 4,grow");
		
		JButton btnNewButton_5 = new JButton("Sair");
		frame.getContentPane().add(btnNewButton_5, "cell 0 5,grow");
	}

}
