package br.com.senacrs.grafos.libraries.grafo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GrafoMatriz<A, V> {

	/** Lista de arestas do grafo */
	private ArrayList<Aresta<A, V>> arestas;

	/** Lista de vertices do grafo */
	private ArrayList<Vertice<V>> vertices;

	/** Matriz de adjac�ncias: linhas e colunas representam v�rtices */
	private Aresta<A, V> matriz[][];

	/**
	 * Construtor da classe: inicializa seus elementos e a matriz gen�rica
	 * quadrada de acordo com o valor inteiro passado como par�metro na
	 * constru��o do objeto
	 */

	@SuppressWarnings("unchecked")
	public GrafoMatriz(int n) {

		this.arestas = new ArrayList<Aresta<A, V>>();
		this.vertices = new ArrayList<Vertice<V>>();

		this.matriz = (Aresta<A, V>[][]) Array.newInstance(Aresta.class, n, n);

	}

	/** Insere um novo v�rtice com o dado v */
	public void addVertice(V v) {

		/** Se a matriz est� completamente ocupada gera-se a exce��o */

		if (matriz.length == vertices.size()) {

			throw new ArrayIndexOutOfBoundsException();

		} else {
			/** Se n�o cria-se uma nova v�rtice */

			Vertice<V> ojbVertice = new Vertice<V>(v);
			/** E adiciona este � lista de v�rtices */
			this.vertices.add(ojbVertice);
		}

	}

	/**
	 * Insere uma nova aresta com os dados v1 e v2 e dado a(mensurar
	 * pondera��o entre a rela��o)
	 */
	public boolean addAresta(V v1, V v2, A a) {

		/** Obtendo �ndice para a aresta */

		int i = this.vertices.indexOf(new Vertice<V>(v1));
		int j = this.vertices.indexOf(new Vertice<V>(v2));

		if (i != -1 && j != -1) {

			/** Criando o objeto aresta */
			Aresta<A, V> objAresta = new Aresta<A, V>(a, vertices.get(i),
					vertices.get(j));

			/** Adiciona-se � lista de arestas */
			this.arestas.add(objAresta);

			/**
			 * Se for um grafo n�o direcionado ambos v�rtices devem se
			 * referenciar e para isso:
			 */
			this.matriz[i][j] = objAresta;
			this.matriz[j][i] = objAresta;
			return true;

		}

		return false;
	}

	public boolean delVertice(V v) {

		int posVertice = this.vertices.indexOf(new Vertice<V>(v));

		V objVertice = this.vertices.remove(posVertice).getDado();

		// TODO delAresta(A a)
		// quando um v�rtice � removido suas arestas tamb�m devem ser
		// removidas

		return objVertice != null;
	}

	public boolean delAresta(A a) {

		Aresta<A, V> objAresta = null;

		int k = 0;

		while (k < this.arestas.size()) {

			objAresta = this.arestas.get(k);

			if (objAresta.getDado().equals(a)) {

				this.arestas.remove(k);

				int i = this.vertices.indexOf(objAresta.getV1());
				int j = this.vertices.indexOf(objAresta.getV2());

				this.matriz[i][j] = null;
				this.matriz[j][i] = null;

				return true;
			}
			k++;
		}

		return false;
	}

	public ArrayList<Vertice<V>> getVizinhos(V v) {

		ArrayList<Vertice<V>> vizinhos = new ArrayList<Vertice<V>>();

		/**
		 * Descobre linha/coluna da matriz que guarda arestas que cont�m o
		 * v�rtice 'v' como um v�rtice incidente, EM OUTRAS PALAVRAS,
		 * OBT�M A POSI��O DA VARI�VEL DA QUAL QUEREMOS SEUS VIZINHOS
		 */
		int posVertice = this.vertices.indexOf(new Vertice<V>(v));

		for (int i = 0; i < this.matriz[posVertice].length; i++) {

			if (this.matriz[posVertice][i] != null) {

				/**
				 * Para cada c�lula da linha correspondente ao v�rtice na
				 * matriz, verifica se h� uma aresta (!=null). Se for
				 * diferente de null, testa se o dado de v1 � diferente de v,
				 * se sim o v�rtice adjacente est� em v1, caso contr�rio
				 * est� em v2
				 */

				if (!matriz[posVertice][i].getV1().getDado().equals(v))
					vizinhos.add(matriz[posVertice][i].getV1());

				else
					vizinhos.add(matriz[posVertice][i].getV2());

				// H� redund�ncia em testar: matriz[posVertice][i] != null?
				// if (matriz[posVertice][i] != null
				// && !matriz[posVertice][i].getV1().getDado().equals(v))
				// objAresta.add(matriz[posVertice][i].getV1());
				//
				// else if (matriz[posVertice][i] != null)
				// objAresta.add(matriz[posVertice][i].getV2());
			}

		}
		return vizinhos;
	}

	public boolean isAdjacente(V v1, V v2) {

		int i = this.vertices.indexOf(new Vertice<V>(v1));
		int j = this.vertices.indexOf(new Vertice<V>(v2));

		if (i == -1 && j == -1)
			return false;
		else
			/**
			 * O valor da aresta na posi��o da matriz[i][j] e diferente de
			 * null?
			 */
			return this.matriz[i][j] != null;
	}

	@Override
	public String toString() {

		String aux = "";
		for (int i = 0; i < matriz.length; i++) {

			for (int j = 0; j < matriz.length; j++) {
				Aresta<A, V> aresta = matriz[i][j];

				aux += aresta;
				if (aresta != null)
					aux += " - " + aresta.getDado();

			}
			aux += "\n";
		}

		return aux;

	}

	public ArrayList<Vertice<V>> getVertices() {
		return vertices;
	}

	public Aresta<A, V>[][] getMatriz() {
		return matriz;
	}

	// public static void main(String[] args) {
	//
	// GrafoMatriz<Integer, String> gm = new GrafoMatriz<>(10);
	//
	// String b = "Brasil", p = "Paraguay", a = "Africa do Sul", e =
	// "Estados Unidos";
	//
	// gm.addVertice(b);
	// gm.addVertice(p);
	// gm.addVertice(a);
	// gm.addVertice(e);
	//
	// gm.addAresta(b, p, 1000);
	//
	// System.out.println(gm.isAdjacente(b, e));
	//
	//
	// }

	// public static void main(String[] args) {
	//
	// ArrayList<String> listaString = new ArrayList<>();
	//
	// listaString.add("A");
	// listaString.add("B");
	// listaString.add("C");
	// listaString.add("D");
	// listaString.add("E");
	//
	// int indice = listaString.indexOf(new String("D"));
	//
	// int matriz[][] = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 } };
	//
	// for (int i = 0; i < matriz[indice].length; i++) {
	//
	// System.out.print(matriz[indice].length);
	//
	// }
	// }

}
