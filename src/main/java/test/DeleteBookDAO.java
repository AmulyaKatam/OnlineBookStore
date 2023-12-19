package test;
import java.sql.*;

public class DeleteBookDAO {
	int  k = 0;
	public int delete(String bcode) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("delete from BookDetails57 where code=?");
			ps.setString(1, bcode);
			
			k = ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return k;
		
	}

}
