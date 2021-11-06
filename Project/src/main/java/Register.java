import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Register")
public class Register extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("userName");
		String p = request.getParameter("userPass");
		String e = request.getParameter("userEmail");
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root",
					"mysql");

			PreparedStatement ps = con.prepareStatement("insert into account values(?,?,?)");

			ps.setString(1, n);
			ps.setString(2, e);
			ps.setString(3, p);

			int i = ps.executeUpdate();
			if (i > 0) {
				out.print("You are successfully registered...");
				RequestDispatcher rs = request.getRequestDispatcher("/index.html");
		        rs.include(request, response);
			}
				

		} catch (Exception e2) {
			System.out.println(e2);
		}

		out.close();
	}

}