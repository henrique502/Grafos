package br.com.senacrs.grafos.utils;

import java.io.File;

/**
 * @author Oracle
 * @see http://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html
 */
public class Extension {
	
	 public final static String txt = "txt";

	 public static String getExtension(File f) {
		 if(f == null) return "";
		 String ext = null;
	     String s = f.getName();
	     int i = s.lastIndexOf('.');

	     if (i > 0 &&  i < s.length() - 1) {
	    	 ext = s.substring(i+1).toLowerCase();
	     }
	     return ext;
	 }
}