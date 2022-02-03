package br.com.infoX.telas;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class TelaClientes extends JFrame {

	private JFrame frame;
	private JButton bnbVisualizar;
	
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaClientes window = new TelaClientes();
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
	public TelaClientes() {
		
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(440, 200, 1023, 601);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\guhen\\Downloads\\40web-development_102061 (1).png"));
		lblNewLabel.setBounds(802, 421, 129, 117);
		getContentPane().add(lblNewLabel);
		
		JButton bnbVisualizar = new JButton("Visualizar");
		bnbVisualizar.setBounds(698, 319, 299, 39);
		getContentPane().add(bnbVisualizar);
		
		JButton btnVisualizar = new JButton("Visualizar todos");
		btnVisualizar.setBounds(698, 369, 299, 39);
		getContentPane().add(btnVisualizar);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(698, 11, 299, 297);
		getContentPane().add(desktopPane);
		
		JButton btnExclui = new JButton("Excluir");
		btnExclui.setBounds(10, 499, 219, 39);
		getContentPane().add(btnExclui);
		
		JButton btnNewButton_1_1 = new JButton("Alterar");
		btnNewButton_1_1.setBounds(239, 499, 219, 39);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Adicionar");
		btnNewButton_1_1_1.setBounds(468, 499, 219, 39);
		getContentPane().add(btnNewButton_1_1_1);
		
		table = new JTable();
		table.setBounds(10, 11, 678, 477);
		getContentPane().add(table);
		initialize();
	}
	
	public void visualizar() {
		String sql = "select * from tbusuarios";
		try {
			// As linhas abaixo preparam a consulta ao banco em função do que foi digitado
			// na tela
			pst = conexao.prepareStatement(sql);
			// A linha abaixo executa a query
			rs = pst.executeQuery();
			// Se existir usuário e senha correspondente
			if (rs.next()) {
					TelaPrincipal principal = new TelaPrincipal();
					principal.setVisible(true);
					this.dispose();
				conexao.close();
			} else {
				JOptionPane.showMessageDialog(null, "Problema na conexão!");

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(240, 35, 1500, 940);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
