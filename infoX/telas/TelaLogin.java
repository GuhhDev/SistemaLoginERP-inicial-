package br.com.infoX.telas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.infoX.dal.ModeloDAO;

public class TelaLogin extends JFrame {

	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	private JPanel contentPane;
	private final JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private JLabel lblIcone;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setAlwaysOnTop(true);

		this.setLocationRelativeTo(null);

		conexao = ModeloDAO.conector();
		setTitle("SystemX - Tela de Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(740, 380, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario.setBounds(10, 78, 51, 31);
		contentPane.add(lblUsuario);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLogin.setBounds(10, 147, 40, 14);
		contentPane.add(lblLogin);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		btnLogin.setBounds(315, 209, 109, 29);
		contentPane.add(btnLogin);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(74, 79, 350, 31);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(74, 141, 350, 31);
		contentPane.add(txtSenha);

		lblIcone = new JLabel("");
		lblIcone.setVerticalAlignment(SwingConstants.TOP);
		try {
			if (conexao != null) {
				lblIcone.setIcon(new ImageIcon(TelaLogin.class.getResource("/br/com/infoX/iconess/dbcon.png")));
			} else {
				lblIcone.setIcon(new ImageIcon(TelaLogin.class.getResource("/br/com/infoX/iconess/dberror.png")));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		lblIcone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIcone.setBounds(15, 191, 51, 59);
		contentPane.add(lblIcone);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(74, 209, 109, 29);
		contentPane.add(btnCancelar);

	}

	public void logar() {
		String sql = "select * from tbusuarios where login=? and senha=?";
		try {
			// As linhas abaixo preparam a consulta ao banco em função do que foi digitado
			// na tela
			pst = conexao.prepareStatement(sql);
			pst.setString(1, txtUsuario.getText());
			pst.setString(2, txtSenha.getText());
			// A linha abaixo executa a query
			rs = pst.executeQuery();
			// Se existir usuário e senha correspondente
			if (rs.next()) {
				String perfil = rs.getString(6);
				if (perfil.equals("user")) {
					TelaPrincipal principal = new TelaPrincipal();
					principal.setVisible(true);
					this.dispose();
				} else {
					TelaPrincipal principal = new TelaPrincipal();
					principal.setVisible(true);
					this.dispose();
				}
				conexao.close();
			} else {
				JOptionPane.showMessageDialog(null, "Usuário e/ou Senha inválido(s)!");

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
