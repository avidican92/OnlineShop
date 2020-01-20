package com.fasttrackit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fasttrackit.helper.DBHelper;
import com.fasttrackit.pojo.Finantare;

public class FinantareDAO {
	public void createFinantare(Finantare f) throws SQLException {
	    Connection conn = DBHelper.getConnection();
	    String insertString="INSERT INTO finantare (id, nume, bancaEmitenta, nrRate, categorieProduse, campanie) VALUES (?, ?, ?, ?, ?, ?)";
	    PreparedStatement stmt = conn.prepareStatement(insertString);

	    stmt.setInt(1,f.getId());
	    stmt.setString(2, f.getNume());
	    stmt.setString(3,f.getBancaEmitenta());
	    stmt.setByte(4, f.getNrRate());
	    stmt.setString(5, f.getCategorieProduse());
	    stmt.setBoolean(6, f.getCampanie());
	    stmt.executeUpdate(); 
	    DBHelper.closeConnection(conn);
	}

	public ArrayList<Finantare> getFinantare() throws SQLException {
	        Connection conn = DBHelper.getConnection();
	        String selectString = "select * from finantare";
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(selectString);

	        ArrayList<Finantare> result = new ArrayList<Finantare>();
	        while (rs.next()){
	            int id = rs.getInt("id");
	            String nume = rs.getString("nume");
	            String bancaEmitenta = rs.getString("bancaEmitenta");
	            byte nrRate = rs.getByte("nrRate");
	            String categorieProduse = rs.getString("categorieProduse");
	            Boolean campanie = rs.getBoolean("campanie");
	            Finantare f = new Finantare(id, nume, bancaEmitenta, nrRate, categorieProduse, campanie);
	            result.add(f);
	        }
	        DBHelper.closeConnection(conn);
	        return result;
	    }
	    public  void updateFinantare(Finantare finantare) throws SQLException {
	        Connection con = DBHelper.getConnection();
	        String updateString = "UPDATE finantare SET nume=?, bancaEmitenta=?, nrRate=?, categorieProduse=?, campanie=? WHERE id=?";
	        PreparedStatement stmt = con.prepareStatement(updateString);
	        stmt.setString(1, finantare.getNume());
	        stmt.setString(2, finantare.getBancaEmitenta());
	        stmt.setByte(3, finantare.getNrRate());
	        stmt.setString(4, finantare.getCategorieProduse());
	        stmt.setBoolean(5,finantare.getCampanie());
	        stmt.setInt(6,  finantare.getId());

	        stmt.executeUpdate();

	        DBHelper.closeConnection(con);
	    }

	    public  void delete(Finantare finantare) throws SQLException {
	        Connection con = DBHelper.getConnection();
	        String deleteString = "DELETE FROM finantare WHERE id=?";
	        PreparedStatement stmt = con.prepareStatement(deleteString);
	        stmt.setInt(1, finantare.getId());
	        stmt.executeUpdate();

	        DBHelper.closeConnection(con);
	    }

	    
	    public Finantare getFinantareById(String finantareId) throws SQLException {
	    	Connection con = DBHelper.getConnection();
	    	String selectString = "select * from finantare where id=?";
	    	PreparedStatement stmt = con.prepareStatement(selectString);
	    	stmt.setString(1, finantareId);
	    	ResultSet rs = stmt.executeQuery();
	    	Finantare result = null;
	    	if (rs.next()) {
	    		int id = rs.getInt("id");
	            String nume = rs.getString("nume");
	            String bancaEmitenta = rs.getString("bancaEmitenta");
	            byte nrRate = rs.getByte("nrRate");
	            String categorieProduse = rs.getString("categorieProduse");
	            Boolean campanie = rs.getBoolean("campanie");
	    		result = new Finantare(id, nume, bancaEmitenta, nrRate, categorieProduse, campanie);
	    	
	    	}
	    DBHelper.closeConnection(con);
	    return result;
	    
	    }
}
