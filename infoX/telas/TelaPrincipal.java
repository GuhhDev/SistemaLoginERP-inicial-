package br.com.infoX.telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaPrincipal extends JFrame {

	public JPanel contentPane;
	public final JLabel lblNewLabel = new JLabel("");
	public static JMenu menRel;
	public static JMenuItem menCadUsu;
	public static JLabel lblUsuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		
		setTitle("SystemX - Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(240, 35, 1500, 940);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cadastro");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cliente");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("OS");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem menCadUsu = new JMenuItem("Usu\u00E1rios");
		mnNewMenu.add(menCadUsu);
		
		menRel = new JMenu("Relat\u00F3rio");
		menuBar.add(menRel);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Serviços");
		menRel.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Sobre");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Chamando a tela sobre
				TelaSobre sobre = new TelaSobre();
				sobre.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Sair");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?","Atenção!",JOptionPane.YES_NO_OPTION);
				if (sair == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1484, 879);
		contentPane.add(desktopPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 850, 1485, 29);
		desktopPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("New label");
		lblUsuario.setBounds(10, 0, 154, 29);
		panel.add(lblUsuario);
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblData = new JLabel("New label");
		lblData.setBounds(1321, 0, 154, 28);
		panel.add(lblData);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblData.setForeground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\guhen\\Downloads\\3409297.jpg"));
		lblNewLabel.setBounds(0, 0, 1485, 878);
		desktopPane.add(lblNewLabel);
	
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
				lblData.setText(formatador.format(data));
			}
		});
	}
	
	public void Clientes() {
		TelaClientes ativarTelaCliente = new TelaClientes();
		ativarTelaCliente.setVisible(true);
	}
}