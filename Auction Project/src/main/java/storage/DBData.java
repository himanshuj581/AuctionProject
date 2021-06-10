package storage;

import bean1.SignupBean;
import config.DBconnect;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBData {
    public static int newBidder(SignupBean sb){
        
        int i=0;
        try{
            Connection con = DBconnect.getConnection();
            String q="insert into bidder(name,email,occupation,networth,location,mobile,password) values(?,?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1, sb.getName());
            ps.setString(2, sb.getEmail());
            ps.setString(3, sb.getOccupation());
            ps.setString(4, sb.getNetWorth());
            ps.setString(5, sb.getLocaton());
            ps.setString(6, sb.getMobile());
            ps.setString(7, sb.getPassword());
            
            
            i = ps.executeUpdate();
            
            con.close();
        }
        catch(SQLException e){
            out.println("Error in "+e);
        }
        return i;
    }
    
    public static String checkLogin(SignupBean sb){
    	Connection con = null;
        try{
            con = DBconnect.getConnection();
            String q="select * from bidder where email = ? and password = ?";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1, sb.getEmail());
            ps.setString(2, sb.getPassword());

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
            	return "true";
            }else {
            	return "false";
            }
        }
        catch(SQLException e){
            out.println("Error in "+e);
        }
        finally {
        	try {
        		con.close();
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        }
        return "Error";
    }
    
    public static int getBidderId(String email){
    	Connection con = null;
        try{
            con = DBconnect.getConnection();
            String q="select b_id from bidder where email = ?";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
            	return rs.getInt(1);
            }else {
            	return -1;
            }
        }
        catch(SQLException e){
            out.println("Error in "+e);
        }
        finally {
        	try {
        		con.close();
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        }
        return -1;
    }
    public static String getBidderName(String email){
    	Connection con = null;
        try{
            con = DBconnect.getConnection();
            String q="select name from bidder where email = ?";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
            	return rs.getString(1);
            }else {
            	return "Not Found";
            }
        }
        catch(SQLException e){
            out.println("Error in "+e);
        }
        finally {
        	try {
        		con.close();
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        }
        return "Not Found";
    }
   
}
