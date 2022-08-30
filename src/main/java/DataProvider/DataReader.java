package DataProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ArrangeManager.ScenarioProvider;
import Managers.FileReaderManager;

public class DataReader {
	
	private String dbURL;
	private String user;
	private String password;
	private String recordNo;
	private Connection conn = null;
	
	
	public DataReader() {
		dbURL = FileReaderManager.getInstance().getConfigReader().getDBUrl();
		user = FileReaderManager.getInstance().getConfigReader().getDBUserName();
		password = FileReaderManager.getInstance().getConfigReader().getDBPassword();
		recordNo = FileReaderManager.getInstance().getConfigReader().getRecordSet();
	}
	
	public ScenarioProvider getConnectionResult() {
		
		ScenarioProvider scenarioProvider = new ScenarioProvider();
		try {
			conn = DriverManager.getConnection(dbURL, user, password);	
			String query = "SELECT * FROM LoginDataSet where RecordNo=" + recordNo;
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next())
		    {
				
				System.out.println(rs.getString("Name"));
				scenarioProvider.setContext("Name", rs.getString("Name"));
				scenarioProvider.setContext("Email", rs.getString("Email"));
				scenarioProvider.setContext("WebURL", rs.getString("website"));
				scenarioProvider.setContext("Years_Exp", rs.getInt("Years_Exp"));
				scenarioProvider.setContext("Expertise", rs.getString("Expertise"));
				scenarioProvider.setContext("Education", rs.getString("Education"));
				scenarioProvider.setContext("Comment", rs.getString("Comment"));
				System.out.println("Retreive here is: " + scenarioProvider.getContext("Name"));
		    }
		    st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return scenarioProvider;
	}
	
	
}
