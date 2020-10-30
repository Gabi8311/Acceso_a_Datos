package ejercicio_3;

import java.io.Serializable;

public class Coche implements Serializable {

	private String modelo;
	private String marca;
	private String color;
	private int cilindrada;

	public Coche() {

	}

	public Coche(String modelo, String marca, String color, int cilindrada) {

		
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.cilindrada = cilindrada;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		
		String s =  "Coche:\n  Modelo:" + this.modelo + "\n  Marca:" + this.marca + "\n  Color:" + this.color + "\n  Cilindrada=" + this.cilindrada;
		
		return s;
	}

}
