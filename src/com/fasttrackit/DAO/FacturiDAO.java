package com.fasttrackit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fasttrackit.helper.DBHelper;
import com.fasttrackit.pojo.Facturi;

public class FacturiDAO {
	public void createFacturi(Facturi fr) throws SQLException {
	    Connection conn = DBHelper.getConnection();
	    String insertString="INSERT INTO facturi (id, codProduse, numeProdus, brand, numeMagazin, pret, numeClient, nrFactura, data, cantitate, metodaPlata) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    PreparedStatement stmt = conn.prepareStatement(insertString);

	    stmt.setInt(1,fr.getId());
	    stmt.setString(2, fr.getCodProdus());
	    stmt.setString(3,fr.getNumeProdus());
	    stmt.setString(4, fr.getBrand());
	    stmt.setString(5, fr.getNumeMagazin());
	    stmt.setDouble(6, fr.getPret());
	    stmt.setString(7, fr.getNumeClient());
	    stmt.setInt(8, fr.getNrFactura());
	    stmt.setString(9, fr.getData());
	    stmt.setInt(10, fr.getCantitate());
	    stmt.setString(11, fr.getMetodaPlata());
	    stmt.executeUpdate(); 
	    DBHelper.closeConnection(conn);
	}

	public ArrayList<Facturi> getFacturi() throws SQLException {
	        Connection conn = DBHelper.getConnection();
	        String selectString = "select * from facturi";
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(selectString);

	        ArrayList<Facturi> result = new ArrayList<Facturi>();
	        while (rs.next()){
	            int id = rs.getInt("id");
	            String codProdus = rs.getString("codProdus");
	            String numeProdus = rs.getString("numeProdus");
	            String brand = rs.getString("brand");
	            String numeMagazin = rs.getString("numeMagazin");
	            double pret = rs.getDouble("pret");
	            String numeClient = rs.getString("numeClient");
	            int nrFactura = rs.getInt("nrFactura");
	            String data = rs.getString("data");
	            int cantitate = rs.getInt("cantitate");
	            String metodaPlata = rs.getString("metodaPlata");
	            Facturi fr = new Facturi(id, codProdus, numeProdus, brand, numeMagazin, pret, numeClient, nrFactura, data, cantitate, metodaPlata);
	            result.add(fr);
	        }
	        DBHelper.closeConnection(conn);
	        return result;
	    }
	    public  void updateFacturi(Facturi facturi) throws SQLException {
	        Connection con = DBHelper.getConnection();
	        String updateString = "UPDATE facturi SET codProduse=?, numeProdus=?, brand=?, numeMagazin=?, pret=?, numeClient=?, nrFactura=?, data=?, cantitate=?, metodaPlata=? WHERE id=?";
	        PreparedStatement stmt = con.prepareStatement(updateString);

		    stmt.setString(1, facturi.getCodProdus());
		    stmt.setString(2,facturi.getNumeProdus());
		    stmt.setString(3, facturi.getBrand());
		    stmt.setString(4, facturi.getNumeMagazin());
		    stmt.setDouble(5, facturi.getPret());
		    stmt.setString(6, facturi.getNumeClient());
		    stmt.setInt(7, facturi.getNrFactura());
		    stmt.setString(8, facturi.getData());
		    stmt.setInt(9, facturi.getCantitate());
		    stmt.setString(10, facturi.getMetodaPlata());
		    stmt.setInt(11,facturi.getId());
	        stmt.executeUpdate();

	        DBHelper.closeConnection(con);
	    }

	    public  void delete(Facturi facturi) throws SQLException {
	        Connection con = DBHelper.getConnection();
	        String deleteString = "DELETE FROM facturi WHERE id=?";
	        PreparedStatement stmt = con.prepareStatement(deleteString);
	        stmt.setInt(1, facturi.getId());
	        stmt.executeUpdate();

	        DBHelper.closeConnection(con);
	    }

	    
	    public Facturi getFacturiById(String facturiId) throws SQLException {
	    	Connection con = DBHelper.getConnection();
	    	String selectString = "select * from facturi where id=?";
	    	PreparedStatement stmt = con.prepareStatement(selectString);
	    	stmt.setString(1, facturiId);
	    	ResultSet rs = stmt.executeQuery();
	    	Facturi result = null;
	    	if (rs.next()) {
	    		int id = rs.getInt("id");
	            String codProdus = rs.getString("codProdus");
	            String numeProdus = rs.getString("numeProdus");
	            String brand = rs.getString("brand");
	            String numeMagazin = rs.getString("numeMagazin");
	            double pret = rs.getDouble("pret");
	            String numeClient = rs.getString("numeClient");
	            int nrFactura = rs.getInt("nrFactura");
	            String data = rs.getString("data");
	            int cantitate = rs.getInt("cantitate");
	            String metodaPlata = rs.getString("metodaPlata");
	            result = new Facturi(id, codProdus, numeProdus, brand, numeMagazin, pret, numeClient, nrFactura, data, cantitate, metodaPlata);
	    	
	    	}
	    DBHelper.closeConnection(con);
	    return result;
	    
	    }
}
