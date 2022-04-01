package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import utils.Pokimon;

public class Crear {
	private JFrame frame;
	private JTextField txtNom;
	private JTextField txtTipo;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JTextField txtCategoria;
	private JTextField txtSkill;
	private JLabel lblNewPkmn;
	private JLabel lblCrNom;
	private JLabel lblCrTipo;
	private JLabel lblCrAltura;
	private JLabel lblCrPeso;
	private JLabel lblCrCategoria;
	private JLabel lblCrSkill;
	private JButton btnCrear;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crear window = new Crear();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Crear() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 565, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		setUIComponents();
		setUIBehaviour();
	}

	private void setUIComponents() {
		lblNewPkmn = new JLabel("Nuevo Pokemon:");
		lblNewPkmn.setBounds(46, 20, 118, 13);
		frame.getContentPane().add(lblNewPkmn);

		lblCrNom = new JLabel("Nombre:");
		lblCrNom.setBounds(10, 55, 73, 13);
		frame.getContentPane().add(lblCrNom);

		lblCrTipo = new JLabel("Tipo:");
		lblCrTipo.setBounds(10, 78, 73, 13);
		frame.getContentPane().add(lblCrTipo);

		lblCrAltura = new JLabel("Altura:");
		lblCrAltura.setBounds(10, 101, 73, 13);
		frame.getContentPane().add(lblCrAltura);

		lblCrPeso = new JLabel("Peso:");
		lblCrPeso.setBounds(10, 124, 85, 13);
		frame.getContentPane().add(lblCrPeso);

		lblCrCategoria = new JLabel("Categoria:");
		lblCrCategoria.setBounds(10, 147, 85, 13);
		frame.getContentPane().add(lblCrCategoria);

		lblCrSkill = new JLabel("Habilidad:");
		lblCrSkill.setBounds(10, 168, 85, 13);
		frame.getContentPane().add(lblCrSkill);

		txtNom = new JTextField();
		txtNom.setBounds(109, 52, 96, 19);
		frame.getContentPane().add(txtNom);
		txtNom.setColumns(10);

		txtTipo = new JTextField();
		txtTipo.setBounds(109, 75, 96, 19);
		frame.getContentPane().add(txtTipo);
		txtTipo.setColumns(10);

		txtAltura = new JTextField();
		txtAltura.setBounds(109, 98, 96, 19);
		frame.getContentPane().add(txtAltura);
		txtAltura.setColumns(10);

		txtPeso = new JTextField();
		txtPeso.setBounds(109, 121, 96, 19);
		frame.getContentPane().add(txtPeso);
		txtPeso.setColumns(10);

		txtCategoria = new JTextField();
		txtCategoria.setBounds(109, 144, 96, 19);
		frame.getContentPane().add(txtCategoria);
		txtCategoria.setColumns(10);

		txtSkill = new JTextField();
		txtSkill.setBounds(109, 165, 96, 19);
		frame.getContentPane().add(txtSkill);
		txtSkill.setColumns(10);

		btnCrear = new JButton("Crear");
		btnCrear.setBounds(250, 74, 96, 21);
		frame.getContentPane().add(btnCrear);

		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(250, 143, 96, 21);
		frame.getContentPane().add(btnCancel);
	}

	private void setUIBehaviour() {
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmado = JOptionPane.showConfirmDialog(btnCrear, "¿Desea crear el Pokemon?",
						"Creación pokemon.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (JOptionPane.OK_OPTION == confirmado) {
					crearPokemon();
					System.out.println("Saliendo.");
					new PokedexView();
					frame.dispose();
					JOptionPane.showMessageDialog(btnCrear, "Creando");
				} else {
					JOptionPane.showMessageDialog(btnCrear, "Volviendo a la creación");
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmado = JOptionPane.showConfirmDialog(btnCancel, "¿Volver a la pokedex?", "Cancelar creación",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (JOptionPane.OK_OPTION == confirmado) {
					new PokedexView();
					frame.dispose();
					JOptionPane.showMessageDialog(btnCancel, "Saliendo");
				} else {
					JOptionPane.showMessageDialog(btnCancel, "Volviendo");
				}
			}
		});
	}

	public void crearPokemon() {
		String nombrePkmn = txtNom.getText();
		String tipoPkmn = txtTipo.getText();
		String alturo = txtAltura.getText();
		String pesito = txtPeso.getText();
		double alturaPkmn = Double.parseDouble(alturo);
		double pesoPkmn = Double.parseDouble(pesito);
		String categoria = txtCategoria.getText();
		String habilidad = txtSkill.getText();

		utils.Almacen.pokemones.add(new Pokimon(nombrePkmn, tipoPkmn, alturaPkmn, pesoPkmn, categoria, habilidad));
	}
}
