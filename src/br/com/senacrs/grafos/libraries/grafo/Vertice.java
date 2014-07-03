package br.com.senacrs.grafos.libraries.grafo;

/** @author Leon_Dias */
public class Vertice<T> {

	private T dado;
	private Vertice<T> anterior;
	private boolean visitado;

	public Vertice() {

	}

	public Vertice(T dado) {
		super();
		this.dado = dado;
		this.visitado = false;
		this.anterior = null;
	}

	public T getDado() {
		return dado;
	}

	public void setDado(T dado) {
		this.dado = dado;
	}

	public Vertice<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(Vertice<T> anterior) {
		this.anterior = anterior;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	@Override
	public String toString() {
		return this.dado.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		/** Se o obj for uma inst�ncia da classe v�rtice */
		else if (obj instanceof Vertice<?>) {

			@SuppressWarnings("unchecked")
			/**Passa-se o dado de obj (claro que fazendo um cast) para dadoObj*/
			T dadoObj = ((Vertice<T>) obj).getDado();
			/**
			 * Compara-se o dado desta(this) classe com o valor passado como
			 * par�metro no m�todo.
			 */
			return this.dado.equals(dadoObj);

		} else
			return false;

	}

}
