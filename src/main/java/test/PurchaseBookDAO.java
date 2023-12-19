package test;
import java.sql.*;

public class PurchaseBookDAO {
	public int k = 0;
	public int update(int qty,String code) {
		try {
			Connection con = DBConnection.getCon();
			
			PreparedStatement ps = con.prepareStatement("update BookDetails57 set qty=qty-? where code=? ");
			ps.setInt(1, qty);
			ps.setString(2, code);
			
			k = ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return k;
	}

}
