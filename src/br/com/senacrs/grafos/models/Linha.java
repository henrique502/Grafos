package br.com.senacrs.grafos.models;

public class Linha {
	
	private int start, end;
	private double peso;
	
	public Linha(int start, int end, double peso) {
		this.start = start;
		this.end = end;
		this.peso = peso;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public double getPeso() {
		return peso;
	}

	@Override
	public String toString() {
		return "Linha [start=" + start + ", end=" + end + ", peso=" + peso + "]\n";
	}
}