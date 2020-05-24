import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class SqlRest extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try{
		String html_q= request.getQueryString();
		String myUrl = "jdbc:mysql://localhost:3306/pets";

		Connection conn = DriverManager.getConnection(myUrl, "ved", "secret");
		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM "+query);

		String js ="";
		while (rs.next())
		{
			js = js+ "ID : "+ rs.getInt("id")+"\t";
			js = js+ "Name : "+ rs.getString("name")+"\t";
				js = js+ "Owner : "+ rs.getInt("owner")+"\t";
					js = js+ "birth year : "+ rs.getInt("birth")+"\n";
		}

		st.close();
		response.getOutputStream().println(js);

}
catch (Exception e)
{
	System.err.println("Got an exception! ");
	System.err.println(e.getMessage());
}
}



}
