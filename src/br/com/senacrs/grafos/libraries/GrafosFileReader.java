package br.com.senacrs.grafos.libraries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GrafosFileReader {
	
	public static final String HEADER_VERTICES = "vertices";
	public static final String HEADER_ARESTAS = "arestas";
	
	private Object data;
	
	public GrafosFileReader(){}
	
	public Object parseFile(File file) throws IOException, FileNotFoundException, IllegalArgumentException {
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(file));
			data = new Object();
			String line = null;
			int option = 0;
			
			while ((line = br.readLine()) != null){
				if(line.equals(HEADER_VERTICES)){ option = 1; continue; }
				if(line.equals(HEADER_ARESTAS)){ option = 2; continue; }
				
				switch(option){
					case 1: addVertice(line); break;
					case 2: addAresta(line); break;
					default: throw new IllegalArgumentException("arquivo invalido");
				}
			}
		} finally {
			br.close();
		}
		
		return data;
	}

	private void addVertice(String line) throws IllegalArgumentException {
		
	}
	
	private void addAresta(String line) throws IllegalArgumentException {
		System.out.println(line);
	}
}
