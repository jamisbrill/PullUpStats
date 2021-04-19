package com.jam.main;

import com.jam.gui.MainGui;
import com.jam.sql.DatabaseConnector;

public class Main {

	public static void main(String[] args) {

		
		
		DatabaseConnector.allvalues(); // connect to the database FIRST !!! not b4 ss
		
	    	MainGui.main(null);  // Launch the gui 
		
		
		
		
		
		
	}

}
