import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  
import com.oreilly.servlet.MultipartRequest;  
@WebServlet("/go")
public class UploadServlet extends HttpServlet {  
  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
MultipartRequest m=new MultipartRequest(request,"D:\\Uploadfile");  
out.print("successfully uploaded");  
HttpSession session=request.getSession();
RequestDispatcher rs = request.getRequestDispatcher("HomePage.html");
rs.forward(request, response);
}  
}  