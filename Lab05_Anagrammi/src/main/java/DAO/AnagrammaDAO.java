package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class AnagrammaDAO {
	public List<String> getParole(){

		//togliere gli accapo e occhio a mettere spazi prima della fine delle virgolette!!!
		String sql="select * "+
				"from parola "+
				"where id=12 ";
		List<String> result= new ArrayList<String>();
		
		try {
			Connection conn= ConnectDB.getConnection();
			PreparedStatement st=conn.prepareStatement(sql);
			
			ResultSet rs= st.executeQuery();
			
			while(rs.next()) {
				result.add(rs.getString("nome"));
			}
			rs.close();
			st.close();
			conn.close();
		}catch(SQLException e) { 
			throw new RuntimeException(e);
		}
		return result;
	}
	
	
	public boolean isCorrect(String anagramma){
		boolean trovato=false;
		String sql="select * "+
				"from parola "+
				"where nome=? ";
//		List<String> result= new ArrayList<String>();
		
		try {
			Connection conn= ConnectDB.getConnection();
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, anagramma);
			
			ResultSet rs= st.executeQuery();
			
			if(rs.next()) {
				trovato=true;
			}else {
				trovato=false;
			}
			rs.close();
			st.close();
			conn.close();
		}catch(SQLException e) { 
			throw new RuntimeException(e);
		}
		return trovato;
		
	}
}
