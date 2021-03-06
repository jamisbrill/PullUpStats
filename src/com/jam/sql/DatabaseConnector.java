package com.jam.sql;

//STEP 1. Import required packages
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

public class DatabaseConnector {
// JDBC driver name and database URL
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  // append driver java database connector 
static final String DB_URL = "jdbc:mysql://192.168.1.54/PullUp"; // The database with ip address


//create the values that the db will put data intto 
static List<String> AllValues=new ArrayList<String>();  
public static List<Double> GPS=new ArrayList<Double>();  
public static List<Double> Temperature=new ArrayList<Double>();  
public static List<Double> Humidity=new ArrayList<Double>();  
public static List<Double> Motion=new ArrayList<Double>();  
public static List<Double> Pressure=new ArrayList<Double>();  
public static ArrayList<Integer> ID=new ArrayList<Integer>();  

static String sql=null;


//  Database credentials
static final String USER = "jam"; // username for DB 
static final String PASS = "jamtestpass"; // Hide this   // test pass for DB ss


public static String allvalues() {


	System.out.println("Sql is currently "+sql);

	//sql =  DataFile.getSql();

	// Might not need 
	if (sql == "" || sql == null || sql.isEmpty()) {    // stops there being an empty statement 

		sql = "SELECT * FROM Stats"; // default show all data in db statement 
		System.out.println("Sql Set has been run ");   

	}





	System.out.println("Here sql is"+sql);


	Connection conn = null;
	Statement stmt = null;
	try{
		//STEP 2: Register JDBC driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		//STEP 3: Open a connection
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL,USER,PASS);

		//STEP 4: Execute a query
		System.out.println("Creating statement...");
		stmt = conn.createStatement();

		ResultSet rs=null;

		System.out.println("Sql before SQL if statement is:"+sql);


		if (sql == "SELECT `id` FROM `Stats` WHERE 2" || sql ==  "SELECT * FROM Stats") {    // allows the use of ExecuteUpdate instead  

			rs = stmt.executeQuery(sql);

		} 
		

		if (sql == "SELECT * FROM Stats") {


			//STEP 5: Extract data from result set
			while(rs.next()) {
				//Retrieve by column name
				String UserID  = rs.getString("UserID");
				String Time = rs.getString("Time");
				String DATE = rs.getString("DATE");
				String Name = rs.getString("Name");
				double PullUp = rs.getInt("PullUps");

				//   String Time = rs.getString("Time");

				//Display values // output what has been found in the database 
				System.out.print("UserID: " + UserID);
				System.out.print(", Time: " + Time);
				System.out.print(", DATE: " + DATE);
				System.out.print(", Name: " + Name);
				System.out.print(", PullUp: " + PullUp);
				System.out.print("\n");

				//set the data to the current values    
			//	DataFile.setBigTextField("id:"+id+"Temperature:"+Temperature+"Pressure:"+Pressure+"GPSLAT:"+GPSLAT+"GPSLON:"+GPSLON+"Motion"+Motion);
				AllValues.add("ID:"+UserID+" Time:"+Time+" Date:"+DATE+" Name:"+Name+" PullUp:"+PullUp);


				// add the data to the lists that have been created at the top of the file 
		//		SQLConnect.Temperature.add(Double.valueOf(Temperature));
		//		SQLConnect.Pressure.add(Double.valueOf(Pressure));
		//		SQLConnect.Motion.add(Double.valueOf(Motion));
		//		SQLConnect.ID.add(id);

			}


		}

		if (rs == null) {
			// rs.close();
		}
		else {
			rs.close();
		}



		stmt.close();
		conn.close();
	}catch(SQLException se){
		//Handle errors for JDBC
		se.printStackTrace();
	}catch(Exception e){
		//Handle errors for Class.forName
		e.printStackTrace();
	}finally{
		//finally block used to close resources
		try{
			if(stmt!=null)
				stmt.close();
		}catch(SQLException se2){
		}// nothing we can do
		try{
			if(conn!=null)
				conn.close();
		}catch(SQLException se){
			se.printStackTrace();
		}//end finally try
	}//end try
	System.out.println("\n");


	com.jam.gui.MainGui gui = new com.jam.gui.MainGui();
 // gui.MaintextPane.get



	System.out.println("------END--------");


	StringBuilder strbul=new StringBuilder();

	for(String str : AllValues)
	{
		strbul.append(str);
		//for adding space between elements
		strbul.append("\n");
	}

	String allValuesstr=strbul.toString();
	System.out.println("hi"+allValuesstr);



	return allValuesstr;




}

//get methods to get the data from this class (wont work unless the allvalues in the class has been run first) 

public static ArrayList<Integer> getID() {

	System.out.println("IDS :"+ID);



	return ID;
}







public static List<Double> getTemperature() {

	System.out.println("TPList:"+Temperature);



	return Temperature;
}
public static List<Double> getMotion() {


	System.out.println("TempList:"+Motion);



	return Motion;
}
public static List<Double> getHumidity() {


	System.out.println("HBList:"+Humidity);



	return Humidity;
}


public static List<Double> getPressure() {


	System.out.println("TempList:"+Pressure);



	return Pressure;
}



public static List<String> getAllValues() {


	System.out.println(":"+AllValues);



	return AllValues;
}



}//end 
