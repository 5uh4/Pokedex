package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import utils.Usuarios;

public class LoginView {
	private JTextField txtFUsuario;
	private JButton btnRegistro;
	private JButton btnEntrar;
	private JFrame frame;
	private Usuarios userActual;
	private JLabel lblRegistro;
	private JLabel lblUsuario;
	private JLabel lblContraseña;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
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
	public LoginView() {
		initialize();
		frame.setVisible(true);
		frame.repaint();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
		
		setUIComponents();
		setUIBehaviour();
	}

	/**
	 * Sets all elements with their properties.
	 */
	private void setUIComponents() {
		frame.getContentPane().setLayout(null);
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(67, 68, 55, 13);
		frame.getContentPane().add(lblUsuario);

		lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setBounds(67, 108, 85, 13);
		frame.getContentPane().add(lblContraseña);

		txtFUsuario = new JTextField();
		txtFUsuario.setBounds(180, 65, 147, 19);
		frame.getContentPane().add(txtFUsuario);
		txtFUsuario.setColumns(10);

		/**
		 * Por medio de este botón se entra en la pokedex, empleando un comparador para
		 * comprobar que exista en la lista.
		 */
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(67, 179, 85, 21);
		frame.getContentPane().add(btnEntrar);

		/**
		 * Esto lleva a una nueva vista de Registro que permite meter un usuario nuevo
		 * (con su usuario y contraseña).
		 */
		btnRegistro = new JButton("\u00A1Registrate!");
		btnRegistro.setBounds(207, 179, 109, 21);
		frame.getContentPane().add(btnRegistro);

		lblRegistro = new JLabel("<html>\u00BFNo tienes<br>cuenta?</html>");
		lblRegistro.setBounds(231, 134, 85, 35);
		frame.getContentPane().add(lblRegistro);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 105, 147, 19);
		frame.getContentPane().add(passwordField);
	}

	public void setUIBehaviour() {
		btnEntrar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
		txtFUsuario.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
		passwordField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enterRegister();
			}
		});
	}

	/**
	 * Función que permite acceder a la pokedex tras comprobar si existe la cuenta.
	 */
	@SuppressWarnings("deprecation")
	public void login() {
		String username = txtFUsuario.getText();
		String password = passwordField.getText();
		userActual = new Usuarios(username, password);
		boolean encontrado = false;
		for (int i = 0; i < utils.Almacen.cuentas.size(); i++) {
			if (userActual.comparar(utils.Almacen.cuentas.get(i))) {
				encontrado = true;
			}
		}
		if (encontrado == true) {
			new PokedexView();
			frame.dispose();
		} else if (txtFUsuario.getText().isBlank() || passwordField.getText().isBlank()) {
			JOptionPane.showMessageDialog(btnEntrar, "Rellena los campos.");
		} else {
			JOptionPane.showMessageDialog(btnEntrar, "No existe ese usuario o la contraseña no es correcta.");
		}
	}
	public void enterRegister() {
		new RegisterView();
		frame.dispose();
	}
}
