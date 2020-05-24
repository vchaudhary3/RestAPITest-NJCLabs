import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ArrayList;
import java.util.Arrays;
public class JavaMysqlSelect
{

  public static void main(String[] args)
  {
    try
    {


      String myUrl = "jdbc:mysql://localhost:3306/pets";


      Connection conn = DriverManager.getConnection(myUrl, "ved", "H@r5h1t@");


      ArrayList<String> queries = new ArrayList<String>(
            Arrays.asList("SELECT * FROM cats",
                          "SELECT * FROM dogs",
                          "SELECT * FROM turtles",
                          "SELECT name, birth FROM cats",
                          "SELECT name, birth FROM dogs",
                          "SELECT name, birth FROM turtles",
                          "SELECT name FROM cats WHERE owner = 'Casey'",
                          "SELECT id FROM cats WHERE name = 'Cookie'",
                          "SELECT * FROM dogs LIMIT 2;",
                          "SELECT t1.id, t1.owner, t2.owner, t2.id FROM cats AS t1, dogs AS t2 WHERE t1.name = t2.name;"));

      // our SQL SELECT query.
      // if you only need a few columns, specify them by name instead of using "*"

      ArrayList <ResultSet> results = new ArrayList<ResultSet>();

      for (int i = 0; i < queries.size(); i++) {
          String query = queries.get(i);

          // create the java statement
          Statement st = conn.createStatement();

          // execute the query, and get a java resultset
          ResultSet rs = st.executeQuery(query);

          // store resultsets from each query in an array
          results.add(rs);

          st.close();

      }


    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }
}
