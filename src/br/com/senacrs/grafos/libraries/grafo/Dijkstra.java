package br.com.senacrs.grafos.libraries.grafo;

import java.util.ArrayList;
import java.util.List;

import br.com.senacrs.grafos.models.Ponto;

public class Dijkstra<A, V> {


	public List<Vertice<V>> getMelhorCaminho(GrafoMatriz<A, V> grafo, Vertice<V> vi, Vertice<V> vf) {
		
		List<Vertice<V>> lista = new ArrayList<Vertice<V>>();
		((Ponto) vi.getDado()).setDistancia(0);
		vi.setVisitado(true);
		lista.add(vi);
		
		for(Vertice<V> x : grafo.getVizinhos(vi.getDado())){
			
			if(x.isVisitado()) continue;
			x.setVisitado(true);
			
			
			for(Vertice<V> y : grafo.getVizinhos(x.getDado())){
				
				if(y.isVisitado()) continue;
				y.setVisitado(true);
				
				System.out.println(y);
				
				Ponto pontoX = (Ponto) x.getDado();
				Ponto pontoY = (Ponto) y.getDado();
				
				double distancia = pontoX.getDistancia() + pontoY.getPeso();
				
				if(distancia > pontoX.getDistancia()){
					pontoX.setDistancia(distancia);
					lista.add(y);
					x = y;
				}
			}
			
			if(x.equals(vf)) break;
		}
		
		return lista;
	}
}
