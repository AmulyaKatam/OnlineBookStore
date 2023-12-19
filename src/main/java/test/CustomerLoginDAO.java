package test;
import java.sql.*;

public class CustomerLoginDAO {
	public CustomerBean cb = null;
	public CustomerBean login(String name,String pword) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from CustomerDetails57 where uname=? and pword=?");
			
			ps.setString(1, name);
			ps.setString(2, pword);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				cb = new CustomerBean();
				cb.setUname(rs.getString(1));
				cb.setPword(rs.getString(2));
				cb.setFname(rs.getString(3));
				cb.setLname(rs.getString(4));
				cb.setAddr(rs.getString(5));
				cb.setMid(rs.getString(6));
				cb.setPhno(rs.getLong(7));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cb;
	}

}
