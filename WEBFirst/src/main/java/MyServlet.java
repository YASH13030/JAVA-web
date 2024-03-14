
import java.sql.Connection;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try
		{
			//read and establish connection.
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/mydatabase", "root", "sharda1234@");
		Statement statement=connection.createStatement(); 
		ResultSet set=statement.executeQuery("SELECT * FROM student_data");
		while(set.next())
		{
			
			out.println("\n"+set.getInt(1)+" "+set.getString(2));
			
		}
	}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
