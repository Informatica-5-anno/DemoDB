import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOPanifici {
	private final String DBUrl = "jdbc:mysql://localhost:3306/panificio";
	private String user;
	private String passw;
	private Connection c;
	
	public DAOPanifici(String user, String passw) {
		this.user = user;
		this.passw = passw;
	}
	private void connectDB() {
		try {
			c=DriverManager.getConnection(DBUrl,user,passw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

	private void closeDB() {
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List getPanifici() {
		List p=new ArrayList<Panificio>();
		connectDB();
		
		closeDB();
		return p;
	}
	
	public List<String> getProvince();
	public List<String> getCitta(String provincia);
	public Panificio getPanificio(Panificio p);
	public List<Panificio> getPanifici(String provincia, String citta);

}
