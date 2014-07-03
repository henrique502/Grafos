package br.com.senacrs.grafos.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import br.com.senacrs.grafos.libraries.grafo.Dijkstra;
import br.com.senacrs.grafos.libraries.grafo.GrafoMatriz;
import br.com.senacrs.grafos.libraries.grafo.Vertice;
import br.com.senacrs.grafos.models.Linha;
import br.com.senacrs.grafos.models.Ponto;

public class DefaultController {

	public DefaultController(String[] params) throws Exception {
		setup();
	}

	private void setup() throws IOException, FileNotFoundException {
		//GrafoMatriz<Linha, Ponto> grafo = new GrafosFileReader().parseFile(new File("/grafo.txt"));
		
		GrafoMatriz<Linha, Ponto> grafo = new GrafoMatriz<Linha, Ponto>(7);
		populate(grafo);
		
		Dijkstra<Linha, Ponto> algo = new Dijkstra<Linha, Ponto>();
		List<Vertice<Ponto>> lista = algo.getMelhorCaminho(grafo, grafo.getVertices().get(5), grafo.getVertices().get(1));
		
		System.out.println(lista);
		
		System.exit(0);
		
	}

	private void populate(GrafoMatriz<Linha, Ponto> grafo) {
		grafo.addVertice(new Ponto(0, 0, 0));
		grafo.addVertice(new Ponto(1, 3, 10));
		grafo.addVertice(new Ponto(2, 4, 10));
		grafo.addVertice(new Ponto(3, 3, 10));
		grafo.addVertice(new Ponto(4, 3, 10));
		grafo.addVertice(new Ponto(5, 6, 10));
		grafo.addVertice(new Ponto(6, 1, 10));
		
		addAresta(grafo, 1, 2, 3);
		addAresta(grafo, 1, 3, 4);
		addAresta(grafo, 2, 3, 3);
		addAresta(grafo, 2, 4, 3);
		addAresta(grafo, 3, 4, 1);
		
		addAresta(grafo, 2, 5, 6);
		addAresta(grafo, 3, 6, 2);
		addAresta(grafo, 4, 5, 2);
		addAresta(grafo, 5, 6, 5);
		
	}

	private void addAresta(GrafoMatriz<Linha, Ponto> grafo, int start, int end, double peso) {
		Ponto s = getPoint(grafo, start).getDado();
		Ponto e = getPoint(grafo, end).getDado();
		Linha l = new Linha(start, end, peso);
		grafo.addAresta(s, e, l);
	}
	
	private Vertice<Ponto> getPoint(GrafoMatriz<Linha, Ponto> grafo, int index){
		return grafo.getVertices().get(index);
	}
}
