package cucumberRunOption;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//trustServerCertificate=true
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=CI_Database;encrypt=false;username=sa;password=dbExpress01");
			//Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=CI_Database;encrypt=false", "sa", "dbExpress01");
			String query = "SELECT * FROM LoginDataSet where RecordNo=1" ;
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next())
		    {
				System.out.println(rs.getString("Name"));
//				scenarioProvider.setContext("Email", rs.getString("Email"));
//				scenarioProvider.setContext("WebURL", rs.getString("website"));
//				scenarioProvider.setContext("Years_Exp", rs.getInt("Years_Exp"));
//				scenarioProvider.setContext("Expertise", rs.getString("Expertise"));
//				scenarioProvider.setContext("Education", rs.getString("Education"));
//				scenarioProvider.setContext("Comment", rs.getString("Comment"));
			
		    }
		    st.close();
		    conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
