package com.fasttrackit.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fasttrackit.helper.DBHelper;
import com.fasttrackit.pojo.Clienti;
import java.sql.Connection;

public class ClientiDAO {
	public void createClienti(Clienti c) throws SQLException{
		Connection conn = DBHelper.getConnection();
		String insertString="INSERT INTO clienti(id, nume, adresa, oras, codPostal, email, telefon) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(insertString);

		stmt.setInt(1,c.getId());
		stmt.setString(2, c.getNume());
		stmt.setString(3, c.getAdresa());
		stmt.setString(4, c.getOras());
		stmt.setInt(5, c.getCodPostal());
		stmt.setString(6, c.getEmail());
		stmt.setString(7, c.getTelefon());
		stmt.executeUpdate();
		DBHelper.closeConnection(conn);
	}	

	public ArrayList<Clienti> getClienti() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String selectString = "select * from clienti";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(selectString);

        ArrayList<Clienti> result = new ArrayList<Clienti>();
        while (rs.next()){
            int id = rs.getInt("id");
            String nume = rs.getString("nume");
            String adresa = rs.getString("adresa");
            String oras = rs.getString("oras");
            int codPostal = rs.getInt("codPostal");
            String email = rs.getString("email");
            String telefon = rs.getString("telefon");
            Clienti c = new Clienti(id, nume, adresa, oras, codPostal, email, telefon);
            result.add(c);
        }
        DBHelper.closeConnection(conn);
        return result;
    }		
	
	public  void updateClienti(Clienti clienti) throws SQLException {
        Connection con = DBHelper.getConnection();
        String updateString = "UPDATE clienti SET nume=?, adresa=?, oras=?, codPostal=?, email=?, telefon=? WHERE id=?";
        PreparedStatement stmt = con.prepareStatement(updateString);
		stmt.setString(1, clienti.getNume());
		stmt.setString(2, clienti.getAdresa());
		stmt.setString(3, clienti.getOras());
		stmt.setInt(4, clienti.getCodPostal());
		stmt.setString(5, clienti.getEmail());
		stmt.setString(6, clienti.getTelefon());
		stmt.setInt(7,clienti.getId());
        stmt.executeUpdate();

        DBHelper.closeConnection(con);
    }
	
    public  void deleteClienti(Clienti clienti) throws SQLException {
        Connection con = DBHelper.getConnection();
        String deleteString = "DELETE FROM clienti WHERE id=?";
        PreparedStatement stmt = con.prepareStatement(deleteString);
        stmt.setInt(1, clienti.getId());
        stmt.executeUpdate();

        DBHelper.closeConnection(con);
    }
    
    public Clienti getClientiById(String clientiId) throws SQLException {
    	Connection con = DBHelper.getConnection();
    	String selectString = "select * from clienti where id=?";
    	PreparedStatement stmt = con.prepareStatement(selectString);
    	stmt.setString(1, clientiId);
    	ResultSet rs = stmt.executeQuery();
    	Clienti result = null;
    	if (rs.next()) {
    		int id = rs.getInt("id");
            String nume = rs.getString("nume");
            String adresa = rs.getString("adresa");
            String oras = rs.getString("oras");
            int codPostal = rs.getInt("codPostal");
            String email = rs.getString("email");
            String telefon = rs.getString("telefon");
    		result = new Clienti(id, nume, adresa, oras, codPostal, email, telefon);
    		
    	}
    DBHelper.closeConnection(con);
    return result;
    }
}
