package br.com.senacrs.grafos.libraries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import br.com.senacrs.grafos.libraries.grafo.GrafoMatriz;
import br.com.senacrs.grafos.models.Linha;
import br.com.senacrs.grafos.models.Ponto;

public class GrafosFileReader {
	
	public static final String HEADER_VERTICES = "vertices";
	public static final String HEADER_ARESTAS = "arestas";
	
	public GrafosFileReader(){}
	
	public GrafoMatriz<Linha, Ponto> parseFile(File file) throws IOException, FileNotFoundException, IllegalArgumentException {
		BufferedReader br = null;
		GrafoMatriz<Linha, Ponto> data = null;
		
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			int option = 0;
			
			ArrayList<Ponto> pontos = new ArrayList<Ponto>();
			ArrayList<Linha> linhas = new ArrayList<Linha>();
			
			while ((line = br.readLine()) != null){
				if(line.equals(HEADER_VERTICES)){ option = 1; continue; }
				if(line.equals(HEADER_ARESTAS)){ option = 2; continue; }
				
				switch(option){
					case 1: addVertice(line, pontos); break;
					case 2: addAresta(line, linhas); break;
					default: throw new IllegalArgumentException("arquivo invalido");
				}
			}
			
			data = new GrafoMatriz<Linha, Ponto>(pontos.size());
			
			for(Ponto ponto : pontos)
				data.addVertice(ponto);
			
			for(Linha linha : linhas)
				data.addAresta(pontos.get(linha.getStart()), pontos.get(linha.getEnd()), linha);
			
		} finally {
			br.close();
		}
		
		return data;
	}

	private void addVertice(String line, ArrayList<Ponto> pontos) throws IllegalArgumentException {
		String[] explode = line.split(" ");
		if(explode.length != 3) throw new IllegalArgumentException("Vertice invalido");
		
		int index = Integer.parseInt(explode[0]);
		pontos.add(index, new Ponto(
			index,
			Double.parseDouble(explode[1]),
			Double.parseDouble(explode[2])
		));		
	}
	
	private void addAresta(String line, ArrayList<Linha> linhas) throws IllegalArgumentException {
		String[] explode = line.split(" ");
		if(explode.length != 3) throw new IllegalArgumentException("Aresta invalido");
		
		linhas.add(new Linha(
			Integer.parseInt(explode[0]),
			Integer.parseInt(explode[1]),
			Double.parseDouble(explode[2])
		));		
	}
}
