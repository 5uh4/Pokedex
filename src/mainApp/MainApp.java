package mainApp;

import ui.LoginView;
import utils.Pokimon;
import utils.Usuarios;

public class MainApp {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
		try {
			utils.Almacen.cuentas.add(new Usuarios("Usuario1", "1234"));
			utils.Almacen.pokemones.add(new Pokimon("Charmander", "Fuego", 0.6, 8.5, "Lagartija", "Mar de llamas."));
			utils.Almacen.pokemones.add(new Pokimon("Bulbasaur", "Planta", 0.7, 6.9, "Semilla", "Espesura"));
		} catch (Exception e) {
			System.out.println("No se pudieron crear los elementos.");
		}
		
		new LoginView();
		
	}

}
