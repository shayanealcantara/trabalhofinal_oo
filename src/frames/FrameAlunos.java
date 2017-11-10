package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import dados.Alunos;
import servicos.Leituras;

import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;

public class FrameAlunos {

	private JFrame frame;
	private JTextField txtNomeAluno;
	private JLabel lblMatriculaDoAluno;
	private JTextField txtMatriculaAluno;
	private JButton btnOk;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAlunos window = new FrameAlunos();
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
	public FrameAlunos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[149px][225px]", "[45px][45px][][45px]"));
		
		JLabel lblNomeDoAluno = new JLabel("Nome Do Aluno :");
		frame.getContentPane().add(lblNomeDoAluno, "cell 0 0,alignx right,growy");
		
		txtNomeAluno = new JTextField();
		frame.getContentPane().add(txtNomeAluno, "cell 1 0,grow");
		txtNomeAluno.setColumns(10);
		
		lblMatriculaDoAluno = new JLabel("  Matricula do Aluno :");
		frame.getContentPane().add(lblMatriculaDoAluno, "cell 0 1,alignx right,growy");
		
		txtMatriculaAluno = new JTextField();
		frame.getContentPane().add(txtMatriculaAluno, "cell 1 1,grow");
		txtMatriculaAluno.setColumns(10);
		
		btnOk = new JButton("OK ");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!ValidaFrameAluno.lerString(txtNomeAluno.getText()) || !ValidaFrameAluno.lerString(txtMatriculaAluno.getText())) {
					FrameAlunos.main(null);
				}
			}
		});
		
		lblNewLabel = new JLabel("");
		frame.getContentPane().add(lblNewLabel, "cell 1 2");
		frame.getContentPane().add(btnOk, "cell 1 3,alignx left,growy");
	}

}
