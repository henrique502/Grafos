package br.com.senacrs.grafos.models;

public class Ponto {
	
	private int index;
	private double peso, tempo;
	private double distancia = Double.POSITIVE_INFINITY;

	public Ponto(int index, double x, double y) {
		this.index = index;
		this.peso = x;
		this.tempo = y;
	}

	public int getIndex() {
		return index;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public double getTempo() {
		return tempo;
	}
	
	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	@Override
	public String toString() {
		return "Ponto [index=" + index + ", x=" + peso + ", y=" + tempo + "]\n";
	}
}
