package com.fasttrackit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fasttrackit.helper.DBHelper;

import com.fasttrackit.pojo.Branduri;

public class BranduriDAO {
	public void createBranduri(Branduri b) throws SQLException {
	    Connection conn = DBHelper.getConnection();
	    String insertString="INSERT INTO branduri (id, nume, categorie, website, taraProvenienta) VALUES (?, ?, ?, ?, ?)";
	    PreparedStatement stmt = conn.prepareStatement(insertString);

	    stmt.setInt(1,b.getId());
	    stmt.setString(2,b.getNume());
	    stmt.setString(3, b.getCategorie());
	    stmt.setString(4, b.getWebsite());
	    stmt.setString(5, b.getTaraProvenienta());
	    stmt.executeUpdate();
	    DBHelper.closeConnection(conn);
	}

	public ArrayList<Branduri> getBranduri() throws SQLException {
	        Connection conn = DBHelper.getConnection();
	        String selectString = "select * from branduri";
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(selectString);

	        ArrayList<Branduri> result = new ArrayList<Branduri>();
	        while (rs.next()){
	            int id = rs.getInt("id");
	            String nume = rs.getString("nume");
	            String categorie = rs.getString("categorie");
	            String website = rs.getString("website");
	            String taraProvenienta = rs.getString("taraProvenienta");
	            Branduri b = new Branduri(id, nume, categorie, website, taraProvenienta);
	            result.add(b);
	        }
	        DBHelper.closeConnection(conn);
	        return result;
	    }
	    public  void updateBranduri(Branduri branduri) throws SQLException {
	        Connection con = DBHelper.getConnection();
	        String updateString = "UPDATE branduri SET nume=?, categorie=?, website=?, taraProvenienta=? WHERE id=?";
	        PreparedStatement stmt = con.prepareStatement(updateString);
	        stmt.setString(1, branduri.getNume());
	        stmt.setString(2, branduri.getCategorie());
	        stmt.setString(3, branduri.getWebsite());
	        stmt.setString(4, branduri.getTaraProvenienta());
	        stmt.setInt(5,  branduri.getId());

	        stmt.executeUpdate();

	        DBHelper.closeConnection(con);
	    }

	    public  void deleteBranduri(Branduri branduri) throws SQLException {
	        Connection con = DBHelper.getConnection();
	        String deleteString = "DELETE FROM branduri WHERE id=?";
	        PreparedStatement stmt = con.prepareStatement(deleteString);
	        stmt.setInt(1, branduri.getId());
	        stmt.executeUpdate();

	        DBHelper.closeConnection(con);
	    }

	    
	    public Branduri getBranduriById(String branduriId) throws SQLException {
	    	Connection con = DBHelper.getConnection();
	    	String selectString = "select * from branduri where id=?";
	    	PreparedStatement stmt = con.prepareStatement(selectString);
	    	stmt.setString(1, branduriId);
	    	ResultSet rs = stmt.executeQuery();
	    	Branduri result = null;
	    	if (rs.next()) {
	    		int id = rs.getInt("id");
	    		String nume = rs.getString("nume");
	    		String categorie = rs.getString("categorie");
	    		String website = rs.getString("website");
	    		String taraProvenienta = rs.getString("taraProvenienta");
	    		result = new Branduri(id, nume, categorie, website, taraProvenienta);
	    	
	    	}
	    DBHelper.closeConnection(con);
	    return result;
	    }
}
