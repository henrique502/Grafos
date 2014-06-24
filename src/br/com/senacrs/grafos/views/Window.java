package br.com.senacrs.grafos.views;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import br.com.senacrs.grafos.utils.Text;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	private Dimension size = new Dimension(950,600);
	private JPanel pane;
	private CardLayout layout;
	
	public Window(){
		super();
		setupFrame();
	}
	
	private void setupFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(size);
		setResizable(true);
		setJMenuBar(new JMenuBar());
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle(Text.key("title"));
		layout = new CardLayout();
		pane = new JPanel();
		setLayout(layout);
		setContentPane(pane);
		pane.add(new JPanel(), "init");
	}
	
	public void addPanel(JPanel panel, String name){
		pane.add(panel, name);
	}
	
	public void cangePanel(String name){
		layout.show(pane, name);
		repaint();
	}
}
