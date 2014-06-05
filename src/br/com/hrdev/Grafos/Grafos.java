package br.com.hrdev.Grafos;

import java.awt.Dimension;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import br.com.hrdev.Grafos.utils.Text;

public class Grafos extends JFrame {

	private static final long serialVersionUID = 1L;
	private Dimension size = new Dimension(950,600);
	
	public Grafos(){
		super();

		try {
			setupProperties();
			setupFrame();
			// TODO: 
			// DatabaseFactory.close(DatabaseFactory.getInstance());
			
			setVisible(true);
		} catch(Exception ex){
			Logger.getLogger(Grafos.class.getName()).log(Level.SEVERE, "Fatal Error", ex);
			System.exit(-1);
		}
	}
	
	private void setupFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(size);
		setResizable(true);
		setJMenuBar(new JMenuBar());
		setResizable(true);
		setLocationRelativeTo(null);
		setTitle(Text.key("title"));
	}
	
	private void setupProperties() throws Exception {
		new Text(getPropertiesFile("texts"));
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