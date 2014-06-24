package br.com.senacrs.grafos.libraries;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import br.com.senacrs.grafos.utils.Extension;

public class GrafosFileBrowser extends JFileChooser {
	
	private static final long serialVersionUID = 1L;
	private static String userDir = null;
	
	public GrafosFileBrowser(){
		super();
		
		if(userDir == null)
			userDir = System.getProperty("user.dir");

		setCurrentDirectory(new File(userDir));
		
		addPropertyChangeListener(new PropertyChangeListener(){
			
			@Override
			public void propertyChange(PropertyChangeEvent evt){
				if(JFileChooser.DIRECTORY_CHANGED_PROPERTY.equals(evt.getPropertyName())) {
					File dir = (File) evt.getNewValue();
					
					userDir = dir.getAbsolutePath();
				}
			}
		});
		
		setFileHidingEnabled(false);
		setFileFilter(new FileBrowserFileFilter());
		setAcceptAllFileFilterUsed(false);
	}
	
	private class FileBrowserFileFilter extends FileFilter {

		@Override
		public boolean accept(File f) {
			if (f.isDirectory()) {
		        return true;
		    }

		    String extension = Extension.getExtension(f);
		    if (extension != null) {
		        if (extension.equals(Extension.txt)){
		        	return true;
		        }
		    }

		    return false;
		}

		@Override
		public String getDescription() {
			return "*." + Extension.txt;
		}
		
	}
}