package br.com.senacrs.grafos.libraries.grafo;

/** @author Leon_Dias */
public class Aresta<A, V> {

	/**
	 * Caso o grafo seja ponderado podemos definir um tipo de dado para mensurar
	 * a rela��o entre dois v�rtices
	 */
	private A dado;
	private Vertice<V> v1, v2;

	public Aresta(A dado, Vertice<V> v1, Vertice<V> v2) {
		super();
		this.dado = dado;
		this.v1 = v1;
		this.v2 = v2;
	}

	public A getDado() {
		return dado;
	}

	public void setDado(A dado) {
		this.dado = dado;
	}

	public Vertice<V> getV1() {
		return v1;
	}

	public void setV1(Vertice<V> v1) {
		this.v1 = v1;
	}

	public Vertice<V> getV2() {
		return v2;
	}

	public void setV2(Vertice<V> v2) {
		this.v2 = v2;
	}

	@Override
	public String toString() {
		return "[" + v1 + ", " + v2 + "]";
	}

}
