

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
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try
		{
			//read and establish connection.
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/mydatabase", "root", "sharda1234@");
		Statement statement=connection.createStatement(); 
		
		
		Scanner sc = new Scanner (System.in);
		System.out.println("enter id and data to update: ");
		int id =sc.nextInt();
		String n=sc.next();
		String insert = "UPDATE `mydatabase`.`student_data` SET `name` = '"+n+"' WHERE (`s_id` = '"+id+"')";
		statement.executeUpdate(insert);
		out.println("Data updated in DB. ");
		}
		catch (Exception e) {
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
