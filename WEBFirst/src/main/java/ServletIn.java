

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletIn
 */
@WebServlet("/ServletIn")
public class ServletIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/mydatabase", "root", "sharda1234@");
			Statement statement=connection.createStatement();
			System.out.println("enter id and name: ");
			Scanner sc = new Scanner(System.in);
			int x = sc.nextInt();
			String n=sc.next();
			statement.executeUpdate("INSERT INTO `mydatabase`.`student_data` (`s_id`, `name`) VALUES ('"+x+"', '"+n+"')");
			out.println("Data Inserted in DB. ");
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
