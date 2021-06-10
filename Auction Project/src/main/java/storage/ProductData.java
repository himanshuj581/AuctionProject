package storage;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import bean1.ProductBean;
import bean1.SignupBean;
import config.DBconnect;

public class ProductData {
	
	 public static void setProductDetails1(ProductBean pb){
	        try{
	            Connection con = DBconnect.getConnection();
	            String q="insert into new_auction(category,description,initial_price,schedule_date,bid) values(?,?,?,?,?)";
	            PreparedStatement ps=con.prepareStatement(q);
	            ps.setString(1, pb.getCategory());
	            ps.setString(2, pb.getDescription());
	            ps.setString(3, pb.getInitial_price());
	            ps.setString(4, pb.getSchedule_date());
	            ps.setInt(5, pb.getB_id());
	            
	            ps.executeUpdate();
	            con.close();
	        }
	        catch(SQLException e){
	            out.println("Error in "+e);
	        }
	    }
	 
	 public static void setImage(String path, int id){
	        try{
	            Connection con = DBconnect.getConnection();
	            String q="update new_Auction set photo=? where product_id=?";
	            PreparedStatement ps=con.prepareStatement(q);
	            ps.setString(1, path);
	            ps.setInt(2, id);

	            ps.executeUpdate();
	            con.close();
	        }
	        catch(SQLException e){
	            out.println("Error in "+e);
	        }
	    }
	 public static int getImageId(){
		 	int id = 0;
	        try{
	            Connection con = DBconnect.getConnection();
	            String q="select product_id from new_auction";
	            PreparedStatement ps=con.prepareStatement(q);
	            ResultSet rs = ps.executeQuery();
	            if(rs.last()) {
	            	id = rs.getInt(0);
	            }
	            con.close();
	        }
	        catch(SQLException e){
	            out.println("Error in "+e);
	        }
	        return id;
	    }
	 public static ArrayList<ArrayList<String>> getAllRecords(int b_id){
		 	ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
	        try{
	            Connection con = DBconnect.getConnection();
	            String q="select * from new_auction where b_id=?";
	            PreparedStatement ps=con.prepareStatement(q);
	            ps.setInt(1, b_id);
	            ResultSet rs = ps.executeQuery();

	            while(rs.next()) {
	            	ArrayList<String> b = new ArrayList<String>();
	            	b.add(rs.getString(1));
	            	b.add(rs.getString(2));
	            	b.add(rs.getString(3));
	            	b.add(rs.getString(4));
	            	b.add(rs.getString(5));
	            	b.add(rs.getString(6));
	            	a.add(b);
	            }
	            con.close();
	        }
	        catch(SQLException e){
	            out.println("Error in "+e);
	        }
	        return a;
	    }
}
