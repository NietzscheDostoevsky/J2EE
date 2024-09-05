package banks.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import banks.Model.Banks;

public class BanksController {
	
	static Connection conn; 
	static {
		try {
			String jdbcUrl = "jdbc:postgresql://localhost:5432/qsp";
	        String username = "postgres";
	        String password = "m";
	        
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(jdbcUrl, username, password);
		} catch  (ClassNotFoundException | SQLException e)  {
			e.printStackTrace();
		}
	}
	
	public void addBank (Banks bank) {
		try {
			PreparedStatement ps = conn.prepareStatement("insert into bank values(?,?)");
			ps.setInt(1,  bank.getId());
			ps.setString(2, bank.getName());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public Banks getBankById(int id) {
		Banks bank = new Banks();
		
		try {
			PreparedStatement ps = conn.prepareStatement("select * from bank where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			bank.setId(rs.getInt("id"));
			bank.setName(rs.getString("name"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return bank;
	}
	
	public boolean deleteBankById(int id) {
		try {
			PreparedStatement ps = conn.prepareStatement("delete from bank where id = ?");
			ps.setInt(1, id);
			ps.execute();
			
			if (getBankById(id) == null)
				return true;
			
		} catch (SQLException e) {
			
		}
		return false;
	}
	
	public boolean updateBankById(int id, String newName) {
		try {
			PreparedStatement ps = conn.prepareStatement("update bank set name = ? where id = ?");
			ps.setInt(1, id);
			ps.setString(2, newName);
			ps.execute();
			
			Banks temp =  getBankById(id);
			if (temp.getName().equals(newName))
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false; 
	}
	
	public List<Banks> getAll() {
		List<Banks> list = new ArrayList<>();
		
		try {
			PreparedStatement ps = conn.prepareStatement("select * from bank");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Banks bank = new Banks(); 
				bank.setId(rs.getInt("id"));
				bank.setName(rs.getString("name"));
				list.add(bank);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list; 
	}

	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
