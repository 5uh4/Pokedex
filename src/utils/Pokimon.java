package utils;

public class Pokimon {
	public int numero;
	public String nombre;
	public String tipo;
	public double altura;
	public double peso;
	public String categoria;
	public String habilidad;

	public Pokimon(String nombre, String tipo, double altura, double peso, String categoria,
			String habilidad) {
		super();
		numero = utils.Almacen.pokemones.size() + 1;
		this.nombre = nombre;
		this.tipo = tipo;
		this.altura = altura;
		this.peso = peso;
		this.categoria = categoria;
		this.habilidad = habilidad;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}

	@Override
	public String toString() {
		return "Pokimon [numero=" + getNumero() + ", nombre=" + getNombre() + ", tipo=" + getTipo() + ", altura=" + getAltura() + ", peso="
				+ getPeso() + ", categoria=" + getCategoria() + ", habilidad=" + getHabilidad() + "]";
	}
}
