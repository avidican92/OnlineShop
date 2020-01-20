package com.fasttrackit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fasttrackit.helper.DBHelper;
import com.fasttrackit.pojo.Produse;

public class ProduseDAO {
	public void createProduse(Produse p) throws SQLException {
	    Connection conn = DBHelper.getConnection();
	    String insertString="INSERT INTO produse (id, codProduse, nume, brand, categorie, stoc, pret) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    PreparedStatement stmt = conn.prepareStatement(insertString);

	    stmt.setInt(1,p.getId());
	    stmt.setString(2,p.getCodProduse());
	    stmt.setString(3, p.getNume());
	    stmt.setString(4, p.getBrand());
	    stmt.setString(5, p.getCategorie());
	    stmt.setInt(6, p.getStoc());
	    stmt.setDouble(7, p.getPret());
	    stmt.executeUpdate();
	    DBHelper.closeConnection(conn);
	}

	public ArrayList<Produse> getProduse() throws SQLException {
	        Connection conn = DBHelper.getConnection();
	        String selectString = "select * from produse";
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(selectString);

	        ArrayList<Produse> result = new ArrayList<Produse>();
	        while (rs.next()){
	            int id = rs.getInt("id");
	            String codProduse = rs.getString("codProduse");
	            String nume = rs.getString("nume");
	            String brand = rs.getString("brand");
	            String categorie = rs.getString("categorie");
	            int stoc = rs.getInt("stoc");
	            double pret = rs.getDouble("pret");
	            Produse p = new Produse(id, codProduse, nume, brand, categorie, stoc, pret);
	            result.add(p);
	        }
	        DBHelper.closeConnection(conn);
	        return result;
	    }
	    public  void updateProduse(Produse produse) throws SQLException {
	        Connection con = DBHelper.getConnection();
	        String updateString = "UPDATE produse SET codProduse=?, nume=?, brand=?, categorie=?, stoc=?, pret=? WHERE id=?";
	        PreparedStatement stmt = con.prepareStatement(updateString);
	        stmt.setString(1, produse.getCodProduse());
	        stmt.setString(2, produse.getNume());
	        stmt.setString(3, produse.getBrand());
	        stmt.setString(4, produse.getCategorie());
	        stmt.setInt(5, produse.getStoc());
	        stmt.setDouble(6, produse.getPret());
	        stmt.setInt(7, produse.getId());
	        stmt.executeUpdate();

	        DBHelper.closeConnection(con);
	    }

	    public  void delete(Produse produse) throws SQLException {
	        Connection con = DBHelper.getConnection();
	        String deleteString = "DELETE FROM produse WHERE id=?";
	        PreparedStatement stmt = con.prepareStatement(deleteString);
	        stmt.setInt(1, produse.getId());
	        stmt.executeUpdate();

	        DBHelper.closeConnection(con);
	    }

	    
	    public Produse getProduseById(String produseId) throws SQLException {
	    	Connection con = DBHelper.getConnection();
	    	String selectString = "select * from produse where id=?";
	    	PreparedStatement stmt = con.prepareStatement(selectString);
	    	stmt.setString(1, produseId);
	    	ResultSet rs = stmt.executeQuery();
	    	Produse result = null;
	    	if (rs.next()) {
	    		int id = rs.getInt("id");
	            String codProduse = rs.getString("codProduse");
	            String nume = rs.getString("nume");
	            String brand = rs.getString("brand");
	            String categorie = rs.getString("categorie");
	            int stoc = rs.getInt("stoc");
	            double pret = rs.getDouble("pret");
	    		result = new Produse(id, codProduse, nume, brand, categorie, stoc, pret);
	    	
	    	}
	    DBHelper.closeConnection(con);
	    return result;
	    }
}
