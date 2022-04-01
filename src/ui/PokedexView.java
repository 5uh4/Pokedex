package ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PokedexView {

	private JFrame frame;
	private JButton btnAtras;
	private JButton btnDelante;
	private JLabel lblPokemone;
	private JLabel lblPkNum;
	private JLabel lblPkNom;
	private JLabel lblPkType;
	private JLabel lblPkAltura;
	private JLabel lblPkPeso;
	private JLabel lblPkSkill;
	private JLabel lblPkCategoria;
	private JButton btnPkCrear;
	private JButton btnPkUpd;
	private JButton btnPkDel;
	private JTextField txtNum;
	private JTextField txtNom;
	private JTextField txtType;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JTextField txtCategoria;
	private JTextField txtSkill;
	private int contadorPkmn = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PokedexView window = new PokedexView();
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
	public PokedexView() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 565, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		setUIComponents();
		setUIBehaviour();
	}

	private void setUIComponents() {

		btnAtras = new JButton("<");
		btnAtras.setBounds(36, 31, 49, 21);
		frame.getContentPane().add(btnAtras);

		btnDelante = new JButton(">");
		btnDelante.setBounds(449, 31, 60, 21);
		frame.getContentPane().add(btnDelante);

		lblPokemone = new JLabel("Pokemon");
		lblPokemone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPokemone.setBounds(217, 106, 104, 21);
		frame.getContentPane().add(lblPokemone);

		lblPkNum = new JLabel("Numero:");
		lblPkNum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPkNum.setBounds(78, 174, 72, 21);
		frame.getContentPane().add(lblPkNum);

		lblPkNom = new JLabel("Nombre:");
		lblPkNom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPkNom.setBounds(78, 211, 72, 21);
		frame.getContentPane().add(lblPkNom);

		lblPkType = new JLabel("Tipo:");
		lblPkType.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPkType.setBounds(78, 244, 72, 21);
		frame.getContentPane().add(lblPkType);

		lblPkAltura = new JLabel("Altura:");
		lblPkAltura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPkAltura.setBounds(78, 275, 71, 21);
		frame.getContentPane().add(lblPkAltura);

		lblPkPeso = new JLabel("Peso:");
		lblPkPeso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPkPeso.setBounds(78, 308, 72, 21);
		frame.getContentPane().add(lblPkPeso);

		lblPkCategoria = new JLabel("Categoria:");
		lblPkCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPkCategoria.setBounds(78, 341, 72, 21);
		frame.getContentPane().add(lblPkCategoria);

		lblPkSkill = new JLabel("Habilidad:");
		lblPkSkill.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPkSkill.setBounds(78, 372, 72, 21);
		frame.getContentPane().add(lblPkSkill);

		btnPkCrear = new JButton("Crear");
		btnPkCrear.setBounds(114, 31, 100, 21);
		frame.getContentPane().add(btnPkCrear);

		btnPkUpd = new JButton("Actualizar");
		btnPkUpd.setBounds(224, 31, 97, 21);
		frame.getContentPane().add(btnPkUpd);

		btnPkDel = new JButton("Borrar");
		btnPkDel.setBounds(333, 31, 101, 21);
		frame.getContentPane().add(btnPkDel);

		txtNum = new JTextField();
		txtNum.setEditable(false);
		txtNum.setText((contadorPkmn + 1) + "");
		txtNum.setBounds(259, 176, 175, 19);
		frame.getContentPane().add(txtNum);
		txtNum.setColumns(10);

		txtNom = new JTextField();
		txtNom.setEditable(true);
		txtNom.setBounds(259, 213, 175, 19);
		frame.getContentPane().add(txtNom);
		txtNom.setColumns(10);

		txtType = new JTextField();
		txtType.setEditable(true);
		txtType.setBounds(259, 246, 175, 19);
		frame.getContentPane().add(txtType);
		txtType.setColumns(10);

		txtAltura = new JTextField();
		txtAltura.setEditable(true);
		txtAltura.setBounds(259, 277, 175, 19);
		frame.getContentPane().add(txtAltura);
		txtAltura.setColumns(10);

		txtPeso = new JTextField();
		txtPeso.setEditable(true);
		txtPeso.setBounds(259, 310, 175, 19);
		frame.getContentPane().add(txtPeso);
		txtPeso.setColumns(10);

		txtCategoria = new JTextField();
		txtCategoria.setEditable(true);
		txtCategoria.setBounds(259, 343, 175, 19);
		frame.getContentPane().add(txtCategoria);
		txtCategoria.setColumns(10);

		txtSkill = new JTextField();
		txtSkill.setEditable(true);
		txtSkill.setBounds(259, 374, 175, 19);
		frame.getContentPane().add(txtSkill);
		txtSkill.setColumns(10);

	}

	private void setUIBehaviour() {

		btnPkCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Crear();
			}
		});
		btnPkUpd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPkmn();
				setElemsPkmn();
			}
		});
		btnPkDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utils.Almacen.pokemones.remove(contadorPkmn - 1);
				setElemsPkmn();
				if (utils.Almacen.pokemones.size() == 0) {
					frame.dispose();
					new Crear();
				} else
					new PokedexView();
			}
		});
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					while (contadorPkmn > 0) {
						contadorPkmn--;
					setElemsPkmn();
					}	if (contadorPkmn == 0) {
						JOptionPane.showMessageDialog(btnAtras, "No hay más pokemones por debajo.");
					}
					
				} catch (Exception r) {

				}

			}
		});
		btnDelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					while (contadorPkmn <= utils.Almacen.pokemones.size()) {
						contadorPkmn++;
						setElemsPkmn();
					} if (contadorPkmn == utils.Almacen.pokemones.size()) {
						contadorPkmn = 1;
					}
				} catch (Exception ef) {
				}

			}
		});
		setElemsPkmn();
	}

	public void setElemsPkmn() {
		txtNum.setText(contadorPkmn + "");
		txtNom.setText(utils.Almacen.pokemones.get(contadorPkmn - 1).getNombre());
		txtAltura.setText(utils.Almacen.pokemones.get(contadorPkmn - 1).getAltura() + "");
		txtPeso.setText(utils.Almacen.pokemones.get(contadorPkmn - 1).getPeso() + "");
		txtType.setText(utils.Almacen.pokemones.get(contadorPkmn - 1).getTipo());
		txtSkill.setText(utils.Almacen.pokemones.get(contadorPkmn - 1).getHabilidad());
		txtCategoria.setText(utils.Almacen.pokemones.get(contadorPkmn - 1).getCategoria());
	}

	public void cambiarPkmn() {
		String nombrePkmn = txtNom.getText();
		String tipoPkmn = txtType.getText();
		String alturo = txtAltura.getText();
		String pesito = txtPeso.getText();
		double alturaPkmn = Double.parseDouble(alturo);
		double pesoPkmn = Double.parseDouble(pesito);
		String categoria = txtCategoria.getText();
		String habilidad = txtSkill.getText();
		utils.Almacen.pokemones.get(contadorPkmn - 1).setNombre(nombrePkmn);
		utils.Almacen.pokemones.get(contadorPkmn - 1).setTipo(tipoPkmn);
		utils.Almacen.pokemones.get(contadorPkmn - 1).setAltura(alturaPkmn);
		utils.Almacen.pokemones.get(contadorPkmn - 1).setPeso(pesoPkmn);
		utils.Almacen.pokemones.get(contadorPkmn - 1).setCategoria(categoria);
		utils.Almacen.pokemones.get(contadorPkmn - 1).setHabilidad(habilidad);
	}
}
