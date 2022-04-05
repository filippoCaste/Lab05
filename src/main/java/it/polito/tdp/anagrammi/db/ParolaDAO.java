package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Parola;

public class ParolaDAO {
	
	public Set<Parola> getTutteLeParole() {
		Set<Parola> result = new HashSet<>();
		String sql = "SELECT p.nome FROM parola p";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				result.add(new Parola(rs.getString("parola")));
			}
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Errore DB");
		}
		
		return result;
	}
	
	public boolean isPresente(String parola) {
		String sql = "SELECT p.nome FROM parola p WHERE p.nome= ? ";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, parola);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.first())
				return true;
			else 
				return false;
			
		} catch(SQLException s) {
			s.printStackTrace();
			System.out.println("Errore DB");
		}
		return false;
	}
	
	

}
