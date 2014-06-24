package br.com.senacrs.grafos;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import br.com.senacrs.grafos.controllers.DefaultController;

public class Application implements Runnable {
	
	private static String[] params;
	
	@Override
	public void run() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new DefaultController(params);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		params = args;
		SwingUtilities.invokeLater(new Application());
	}
}
