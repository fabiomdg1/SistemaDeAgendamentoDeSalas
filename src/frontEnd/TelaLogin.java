package frontEnd;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout;
import javax.swing.SpringLayout;
import javax.swing.JDesktopPane;
import dao.ClasseDao;

public class TelaLogin extends JFrame {

		private JPanel contentPane;
		private JTextField txtSenha;
		private JTextField txtUsuario;
		
		ClasseDao dao = new ClasseDao();
		
		
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
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 775, 636);
			contentPane = new JPanel();
			contentPane.setBackground(Color.DARK_GRAY);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);

			JDesktopPane desktopPane = new JDesktopPane();
			desktopPane.setBackground(Color.DARK_GRAY);

			JPanel conteinerLogin = new JPanel();
			conteinerLogin.setBounds(75, 130, 587, 336);

			conteinerLogin.setBackground(Color.GRAY);

			JLabel lblUsuario = new JLabel("Usuário");
			lblUsuario.setBounds(98, 85, 314, 15);
			lblUsuario.setForeground(Color.WHITE);
			lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
			lblUsuario.setFont(new Font("Arial", Font.BOLD, 15));

			txtUsuario = new JTextField();
			txtUsuario.setBounds(98, 111, 315, 20);
			txtUsuario.setColumns(10);
			txtUsuario.setBackground(Color.LIGHT_GRAY);

			JLabel lblSenha = new JLabel("Senha");
			lblSenha.setBounds(98, 168, 314, 15);
			lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
			lblSenha.setForeground(Color.WHITE);
			lblSenha.setFont(new Font("Arial", Font.BOLD, 15));

			txtSenha = new JTextField();
			txtSenha.setBounds(98, 194, 314, 41);
			txtSenha.setBackground(Color.LIGHT_GRAY);
			txtSenha.setColumns(10);

			JButton btnAvancar = new JButton("Avançar");
			btnAvancar.setBounds(134, 241, 248, 29);
			btnAvancar.setForeground(Color.WHITE);
			btnAvancar.setBackground(Color.DARK_GRAY);
			
			//*************Botão Avançar*************//
			btnAvancar.addActionListener(e -> {
				dao.verificaLogin(txtUsuario.getText(), txtSenha.getText());
			});

			JLabel lblNãopossuíCadastro = new JLabel("não possuí um cadastro?");
			lblNãopossuíCadastro.setBounds(98, 276, 314, 16);
			lblNãopossuíCadastro.setHorizontalAlignment(SwingConstants.CENTER);
			lblNãopossuíCadastro.setForeground(Color.WHITE);
			lblNãopossuíCadastro.setFont(new Font("Arial", Font.BOLD, 15));

			JButton btnCadastrar = new JButton("Cadastrar!");
			btnCadastrar.setBounds(137, 306, 248, 19);
			btnCadastrar.setForeground(Color.WHITE);
			btnCadastrar.setBackground(Color.DARK_GRAY);
			
			
			//****************Botão Cadastrar****************//
			btnCadastrar.addActionListener(e -> {
			    dao.cadastrarTeste();
			});

			JLabel lblLogin = new JLabel("LOGIN");
			lblLogin.setBounds(98, 11, 314, 35);
			lblLogin.setForeground(Color.WHITE);
			lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogin.setFont(new Font("Arial Black", Font.BOLD, 20));
			conteinerLogin.setLayout(null);
			GroupLayout gl_conteinerLogin = new GroupLayout(conteinerLogin);
			gl_conteinerLogin.setHorizontalGroup(
				gl_conteinerLogin.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_conteinerLogin.createSequentialGroup()
						.addGap(98)
						.addComponent(lblLogin, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
						.addGap(98))
					.addGroup(gl_conteinerLogin.createSequentialGroup()
						.addGap(98)
						.addComponent(lblUsuario, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
						.addGap(98))
					.addGroup(gl_conteinerLogin.createSequentialGroup()
						.addGap(98)
						.addComponent(lblSenha, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
						.addGap(98))
					.addGroup(gl_conteinerLogin.createSequentialGroup()
						.addGap(134)
						.addComponent(btnAvancar, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
						.addGap(128))
					.addGroup(gl_conteinerLogin.createSequentialGroup()
						.addGap(98)
						.addComponent(lblNãopossuíCadastro, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
						.addGap(98))
					.addGroup(gl_conteinerLogin.createSequentialGroup()
						.addGap(137)
						.addComponent(btnCadastrar, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
						.addGap(125))
					.addGroup(gl_conteinerLogin.createSequentialGroup()
						.addGap(98)
						.addComponent(txtSenha, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
						.addGap(98))
					.addGroup(gl_conteinerLogin.createSequentialGroup()
						.addGap(98)
						.addComponent(txtUsuario, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
						.addGap(97))
			);
			gl_conteinerLogin.setVerticalGroup(
				gl_conteinerLogin.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_conteinerLogin.createSequentialGroup()
						.addGap(11)
						.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGap(39)
						.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addGap(11)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGap(26)
						.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 15, Short.MAX_VALUE)
						.addGap(11)
						.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnAvancar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGap(6)
						.addComponent(lblNãopossuíCadastro, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addGap(14)
						.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addGap(11))
			);
			conteinerLogin.setLayout(gl_conteinerLogin);

			JPanel backgroundSenai = new JPanel();
			backgroundSenai.setBounds(56, 11, 247, 49);
			backgroundSenai.setBackground(Color.RED);

			JLabel logoDoSenai = new JLabel("SENAI");
			logoDoSenai.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 50));
			logoDoSenai.setHorizontalAlignment(SwingConstants.CENTER);
			logoDoSenai.setForeground(Color.WHITE);
			logoDoSenai.setBackground(Color.RED);
			GroupLayout gl_backgroundSenai = new GroupLayout(backgroundSenai);
			gl_backgroundSenai.setHorizontalGroup(gl_backgroundSenai.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_backgroundSenai.createSequentialGroup()
							.addComponent(logoDoSenai, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE).addContainerGap()));
			gl_backgroundSenai.setVerticalGroup(gl_backgroundSenai.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_backgroundSenai.createSequentialGroup()
							.addComponent(logoDoSenai, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
			backgroundSenai.setLayout(gl_backgroundSenai);
			desktopPane.setLayout(null);

			JLabel LogoDoSenai2 = new JLabel("-");
			LogoDoSenai2.setBounds(10, 46, 92, 12);
			desktopPane.add(LogoDoSenai2);
			LogoDoSenai2.setForeground(Color.WHITE);
			LogoDoSenai2.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));
			LogoDoSenai2.setHorizontalAlignment(SwingConstants.CENTER);

			JLabel LogoDoSenai2_1 = new JLabel("-");
			LogoDoSenai2_1.setBounds(10, 34, 92, 12);
			desktopPane.add(LogoDoSenai2_1);
			LogoDoSenai2_1.setHorizontalAlignment(SwingConstants.CENTER);
			LogoDoSenai2_1.setForeground(Color.WHITE);
			LogoDoSenai2_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));

			JLabel LogoDoSenai2_1_1 = new JLabel("-");
			LogoDoSenai2_1_1.setBounds(10, 23, 92, 12);
			desktopPane.add(LogoDoSenai2_1_1);
			LogoDoSenai2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			LogoDoSenai2_1_1.setForeground(Color.WHITE);
			LogoDoSenai2_1_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));

			JLabel LogoDoSenai2_1_2 = new JLabel("-");
			LogoDoSenai2_1_2.setBounds(22, 11, 69, 12);
			desktopPane.add(LogoDoSenai2_1_2);
			LogoDoSenai2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			LogoDoSenai2_1_2.setForeground(Color.WHITE);
			LogoDoSenai2_1_2.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));

			JLabel LogoDoSenai2_1_3_3 = new JLabel("-");
			LogoDoSenai2_1_3_3.setBounds(252, 45, 91, 15);
			LogoDoSenai2_1_3_3.setHorizontalAlignment(SwingConstants.CENTER);
			LogoDoSenai2_1_3_3.setForeground(Color.WHITE);
			LogoDoSenai2_1_3_3.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));
			desktopPane.add(LogoDoSenai2_1_3_3);

			JLabel LogoDoSenai2_1_3_1 = new JLabel("-");
			LogoDoSenai2_1_3_1.setBounds(252, 23, 91, 12);
			desktopPane.add(LogoDoSenai2_1_3_1);
			LogoDoSenai2_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
			LogoDoSenai2_1_3_1.setForeground(Color.WHITE);
			LogoDoSenai2_1_3_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));

			JLabel LogoDoSenai2_1_3 = new JLabel("-");
			LogoDoSenai2_1_3.setBounds(252, 11, 91, 12);
			desktopPane.add(LogoDoSenai2_1_3);
			LogoDoSenai2_1_3.setHorizontalAlignment(SwingConstants.CENTER);
			LogoDoSenai2_1_3.setForeground(Color.WHITE);
			LogoDoSenai2_1_3.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));

			JLabel LogoDoSenai2_1_3_2 = new JLabel("-");
			LogoDoSenai2_1_3_2.setBounds(252, 34, 91, 12);
			LogoDoSenai2_1_3_2.setHorizontalAlignment(SwingConstants.CENTER);
			LogoDoSenai2_1_3_2.setForeground(Color.WHITE);
			LogoDoSenai2_1_3_2.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));
			desktopPane.add(LogoDoSenai2_1_3_2);
			desktopPane.add(conteinerLogin);
			desktopPane.add(backgroundSenai);
			GroupLayout gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10).addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)));
			gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup().addGap(11)
							.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE).addGap(1)));
			contentPane.setLayout(gl_contentPane);
	}
}
