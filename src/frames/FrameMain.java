package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class FrameMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMain window = new FrameMain();
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
	public FrameMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JButton btnTurma = new JButton("Turmas");
		btnTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().setLayout(new MigLayout("", "[100px][225px]", "[68px][68px][68px][68px]"));
		frame.getContentPane().add(btnTurma, "cell 1 0,grow");
		
		JLabel label_1 = new JLabel("");
		frame.getContentPane().add(label_1, "cell 0 1,grow");
		
		JButton btnAlunos = new JButton("Alunos");
		btnAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		frame.getContentPane().add(btnAlunos, "cell 1 1,grow");
		
		JLabel label_2 = new JLabel("");
		frame.getContentPane().add(label_2, "cell 0 2,grow");
		
		JButton btnAvaliacao = new JButton("Avaliações");
		frame.getContentPane().add(btnAvaliacao, "cell 1 2,grow");
		
		JLabel label_3 = new JLabel("");
		frame.getContentPane().add(label_3, "cell 0 3,grow");
		
		JButton btnSair = new JButton("Sair");
		frame.getContentPane().add(btnSair, "cell 1 3,grow");
	}

}
