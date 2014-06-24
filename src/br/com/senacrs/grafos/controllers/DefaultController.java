package br.com.senacrs.grafos.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.com.senacrs.grafos.libraries.GrafosFileBrowser;
import br.com.senacrs.grafos.libraries.GrafosFileReader;
import br.com.senacrs.grafos.utils.Text;
import br.com.senacrs.grafos.views.Window;

public class DefaultController {
	
	@SuppressWarnings("unused")
	private static Text textCache = null;
	
	private Window window;
	private File defaultLocation = null;
	
	public DefaultController(String[] params) throws Exception {
		initParams(params);
		textCache = new Text(getPropertiesFile("texts"));
		window = new Window();
		setupFile();
		setup();
	}

	private void initParams(String[] params) throws IllegalArgumentException {
		int size = params.length;
		
		if(size == 0) return;
		if(size != 1) throw new IllegalArgumentException("o programa deve receber 0 ou 1 parametro(s)");
		
		File location = new File(params[0]);
		
		if(!location.exists()) throw new IllegalArgumentException("o arquivo nao existe");
		if(!location.canRead()) throw new IllegalArgumentException("o arquivo nao esta acessivel para leitura");
		
		defaultLocation = location;
	}
	
	private void setupFile() throws IllegalArgumentException, Exception {
		if(defaultLocation != null) return;
		
		GrafosFileBrowser browser = new GrafosFileBrowser();
		int option = browser.showOpenDialog(window);
		
		switch(option){
			case GrafosFileBrowser.APPROVE_OPTION : defaultLocation = browser.getSelectedFile(); break;
			default : throw new Exception("voce deve selecionar algum arquivo para continuar");
		}

		if(!defaultLocation.exists()) throw new IllegalArgumentException("o arquivo nao existe");
		if(!defaultLocation.canRead()) throw new IllegalArgumentException("o arquivo nao esta acessivel para leitura");
	}

	private void setup() throws IOException, FileNotFoundException {
		Object ob = new GrafosFileReader().parseFile(defaultLocation);
		
		
	}

	private Properties getPropertiesFile(String file) throws Exception {
		Properties prop = null;
		InputStream input = null;
		try {
			prop = new Properties();
			input = getClass().getResourceAsStream("/assets/properties/" + file + ".properties");
			prop.load(input);
		} finally {
			input.close();
		}
		
		return prop;
	}
	
}
