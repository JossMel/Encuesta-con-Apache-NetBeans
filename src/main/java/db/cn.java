/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 *
 * @author JosselynMartinez
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class cn{

    private Connection con;

    public cn () throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");

            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/encuesta","root","");
            
        }catch (Exception e){
         System.err.println("Error"+e);
        }
    }
    
    public Connection getCon() { 
        return con; 
    }

}
