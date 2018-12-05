
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOPanifici {
	private final String DBUrl = "jdbc:mysql://localhost:3306/panifici";
	private String user;
	private String passw;
	private Connection c=null;
	
	public DAOPanifici(String user, String passw) {
		this.user = user;
		this.passw = passw;
		//connectDB();
	}
	private void connectDB() {
		try {
			if (c==null) c=DriverManager.getConnection(DBUrl,user,passw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

	public void closeDB() {
		try {
			c.close();
			c=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Panificio> getPanifici() {
		List<Panificio> lp=new ArrayList<Panificio>();
		connectDB();
		try {
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("SELECT Citta, Provincia, Regione, Panetteria FROM panifici");
			while (rs.next()) {
				Panificio p=new Panificio();
				p.setCitta(rs.getString("Citta"));
				p.setProvincia(rs.getString("Provincia"));
				p.setRegione(rs.getString("Regione"));
				p.setPanificio(rs.getString("Panetteria"));
				lp.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeDB();
		return lp;
	}
//	
//	public List<String> getProvince();
	public List<String> getCitta(String provincia) {
		List<String> lp=new ArrayList<String>();
		connectDB();
		try {
			PreparedStatement s=c.prepareStatement("SELECT DISTINCT Citta FROM panifici WHERE Provincia=? ORDER BY 1 ASC");
			s.setString(1, provincia);
			ResultSet rs=s.executeQuery();
			while (rs.next()) {
				lp.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeDB();
		return lp;
	}
//	public Panificio getPanificio(Panificio p);
//	public List<Panificio> getPanifici(String provincia, String citta);

}
