import java.sql.*;
import java.util.List;

public class dbtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      DAOPanifici daop=new DAOPanifici("root","root");
      
      List<Panificio>l=daop.getPanifici();
      
      for ( Panificio p : l ) {
    	  System.out.println(p);
      }
	}	
}
