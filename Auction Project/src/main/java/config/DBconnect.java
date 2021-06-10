package config;

import static java.lang.System.out;
import java.sql.*;
public class DBconnect {
public static Connection getConnection(){
    
    Connection con=null;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        String path="jdbc:mysql://localhost:3306/auctiondb";
        String user="root";
        String pass="root";
        
        con = DriverManager.getConnection(path,user,pass);
    }
    catch(ClassNotFoundException | SQLException e){
       out.println("Exception of Connection" + e);   
    }
    
    
    return con;
    
    
}


}
