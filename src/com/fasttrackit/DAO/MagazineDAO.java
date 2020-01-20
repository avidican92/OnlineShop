package com.fasttrackit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fasttrackit.helper.DBHelper;
import com.fasttrackit.pojo.Magazine;

public class MagazineDAO {
	public void createMagazine(Magazine m) throws SQLException {
	    Connection conn = DBHelper.getConnection();
	    String insertString="INSERT INTO magazine (id, nume, easybox, adresa, program, telefon) VALUES ( ?, ?, ?, ?, ?, ?)";
	    PreparedStatement stmt = conn.prepareStatement(insertString);

	    stmt.setInt(1,m.getId());
	    stmt.setString(2,m.getNume());
	    stmt.setBoolean(3, m.getEasybox());
	    stmt.setString(4, m.getAdresa());
	    stmt.setString(5, m.getProgram());
	    stmt.setString(6, m.getTelefon());
	    stmt.executeUpdate(); 
	    DBHelper.closeConnection(conn);
	}

	public ArrayList<Magazine> getMagazine() throws SQLException {
	        Connection conn = DBHelper.getConnection();
	        String selectString = "select * from magazine";
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(selectString);

	        ArrayList<Magazine> result = new ArrayList<Magazine>();
	        while (rs.next()){
	            int id = rs.getInt("id");
	            String nume = rs.getString("nume");
	            Boolean easybox = rs.getBoolean("easybox");
	            String adresa = rs.getString("adresa");
	            String program = rs.getString("program");
	            String telefon = rs.getString("telefon");
	            Magazine m = new Magazine(id, nume, easybox, adresa, program, telefon);
	            result.add(m);
	        }
	        DBHelper.closeConnection(conn);
	        return result;
	    }
	    public  void updateMagazine(Magazine magazine) throws SQLException {
	        Connection con = DBHelper.getConnection();
	        String updateString = "UPDATE magazine SET nume=?, easybox=?, adresa=?, program=?, telefon=? WHERE id=?";
	        PreparedStatement stmt = con.prepareStatement(updateString);
	        stmt.setString(1, magazine.getNume());
	        stmt.setBoolean(2, magazine.getEasybox());
	        stmt.setString(3, magazine.getAdresa());
	        stmt.setString(4, magazine.getProgram());
	        stmt.setString(5, magazine.getTelefon());
	        stmt.setInt(6,  magazine.getId());
	        stmt.executeUpdate();
	        DBHelper.closeConnection(con);
	    }

	    public void delete(Magazine magazine) throws SQLException {
	        Connection con = DBHelper.getConnection();
	        String deleteString = "DELETE FROM magazine WHERE id=?";
	        PreparedStatement stmt = con.prepareStatement(deleteString);
	        stmt.setInt(1, magazine.getId());
	        stmt.executeUpdate();

	        DBHelper.closeConnection(con);
	    }

	    
	    public Magazine getMagazineById(String magazineId) throws SQLException {
	    	Connection con = DBHelper.getConnection();
	    	String selectString = "select * from magazine where id=?";
	    	PreparedStatement stmt = con.prepareStatement(selectString);
	    	stmt.setString(1, magazineId);
	    	ResultSet rs = stmt.executeQuery();
	    	Magazine result = null;
	    	if (rs.next()) {
	    		int id = rs.getInt("id");
	            String nume = rs.getString("nume");
	            Boolean easybox = rs.getBoolean("easybox");
	            String adresa = rs.getString("adresa");
	            String program = rs.getString("program");
	            String telefon = rs.getString("telefon");
	    		result = new Magazine(id, nume, easybox, adresa, program, telefon);
	    	
	    	}
	    DBHelper.closeConnection(con);
	    return result;
	    }
}
