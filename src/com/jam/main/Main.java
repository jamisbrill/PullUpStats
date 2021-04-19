package com.jam.main;

import com.jam.gui.MainGui;
import com.jam.sql.DatabaseConnector;

public class Main {

	public static void main(String[] args) {

		
		
		DatabaseConnector.allvalues(); // connect to the database FIRST !!! 
		
		MainGui.main(null);  // Launch the gui 
		
		
		
		
		
		
	}

}
