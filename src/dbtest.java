import java.sql.*;

public class dbtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String DBUrl = "jdbc:mysql://localhost:3306/Classe5H?user=classe&password=classe";
        
        try {
			Connection connection=DriverManager.getConnection(DBUrl);
			
			Statement s=connection.createStatement();
			ResultSet rs=s.executeQuery("select * from docenti");
			
			while (rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			rs.close();
			s.close();
			
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
