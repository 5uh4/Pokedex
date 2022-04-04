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
import java.awt.Color;

public class RegisterView {

	private JFrame frame;
	private JTextField txtFUser;
	private JPasswordField passwordField;
	private JPasswordField passwordConfirm;
	private JButton btnCrear;
	private JButton btnLogin;
	private String nombreUsuario;
	private JLabel lblLogin;
	private JLabel lblNewUser;
	private JLabel lblContraseña;
	private JLabel lblConfirmar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView window = new RegisterView();
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
	public RegisterView() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 235, 205));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		setUIComponents();
		setUIBehaviour();
	}

	/**
	 * Sets all components with their properties.
	 */
	private void setUIComponents() {
		frame.getContentPane().setLayout(null);

		lblNewUser = new JLabel("Username:");
		lblNewUser.setBounds(39, 57, 66, 13);
		frame.getContentPane().add(lblNewUser);

		lblContraseña = new JLabel("Introduce tu contrase\u00F1a:");
		lblContraseña.setBounds(22, 98, 138, 13);
		frame.getContentPane().add(lblContraseña);

		lblConfirmar = new JLabel("Confirma tu contrase\u00F1a:");
		lblConfirmar.setBounds(22, 140, 138, 13);
		frame.getContentPane().add(lblConfirmar);

		txtFUser = new JTextField();
		txtFUser.setBounds(187, 54, 96, 19);
		frame.getContentPane().add(txtFUser);
		txtFUser.setColumns(10);

		btnCrear = new JButton("Crear cuenta");
		btnCrear.setBounds(55, 201, 114, 21);
		frame.getContentPane().add(btnCrear);

		lblLogin = new JLabel("<html>\u00BFYa tienes<br>cuenta?</html>");
		lblLogin.setBounds(237, 166, 96, 25);
		frame.getContentPane().add(lblLogin);

		btnLogin = new JButton("<html>Volver al<br>login</html>");
		btnLogin.setBounds(237, 201, 96, 35);
		frame.getContentPane().add(btnLogin);

		passwordField = new JPasswordField();
		passwordField.setBounds(187, 95, 96, 19);
		frame.getContentPane().add(passwordField);

		passwordConfirm = new JPasswordField();
		passwordConfirm.setBounds(187, 137, 96, 19);
		frame.getContentPane().add(passwordConfirm);
	}

	/**
	 * Sets the behaviour each component must follow.
	 */
	private void setUIBehaviour() {
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginView();
				frame.dispose();
			}
		});

		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registro();
			}
		});
		btnCrear.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					registro();
				}
			}
		});

	}

	/**
	 * Checks all elements are in order and executes the "registro" function.
	 */
	@SuppressWarnings("deprecation")
	public void registro() {
		if ((txtFUser.getText() != null) && (passwordField.getText() != null) && (passwordConfirm.getText() != null)
				&& passwordField.getText().equals(passwordConfirm.getText())) {
			registrar();
		} else {
			JOptionPane.showMessageDialog(btnCrear, "Comprueba que los elementos son correctos.");
		}
	}

	/**
	 * Creates a user that gets added to the arraylist of users.
	 */
	private void registrar() {
		nombreUsuario = txtFUser.getText();
		@SuppressWarnings("deprecation")
		String userPassword = passwordField.getText();
		Usuarios usuarioActual = new Usuarios(nombreUsuario, userPassword);
		for(int i = 0; i < utils.Almacen.cuentas.size(); i++) {
			if(utils.Almacen.cuentas.get(i).getUsername() == nombreUsuario || utils.Almacen.cuentas.get(i).getPassword() == userPassword) {
				JOptionPane.showMessageDialog(btnCrear, "Ya existe ese usuario.");
			} else {
				utils.Almacen.cuentas.add(usuarioActual);
				new LoginView();
				frame.dispose();
			}
		}
		
	}
	
}
