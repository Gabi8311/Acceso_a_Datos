package ejercicio_5;

import java.io.Serializable;

public class Casa implements Serializable{

	private int numPersonas;
	private double precioAlq;
	private int codigoP;

	public Casa() {

	}

	public Casa(int numPersonas, double precioAlq, int codigoP) {

		this.numPersonas = numPersonas;
		this.precioAlq = precioAlq;
		this.codigoP = codigoP;
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	public double getPrecioAlq() {
		return precioAlq;
	}

	public void setPrecioAlq(double precioAlq) {
		this.precioAlq = precioAlq;
	}

	public int getCodigoP() {
		return codigoP;
	}

	public void setCodigoP(int codigoP) {
		this.codigoP = codigoP;
	}

	@Override
	public String toString() {
		return "Casa:\n" + "  Nº de Personas:"+this.numPersonas + "\n  Precio del Alquiler:" + this.precioAlq + "\n  Código Postal:" + this.codigoP;
	}

}
