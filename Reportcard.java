package SchoolAssissement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.mysql.jdbc.Statement;

@WebServlet("/Reportcard")
public class Reportcard extends GenericServlet{
	
	
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String url = "jdbc:mysql://localhost:3306/teca43?user=root&password=12345";
        String select = "SELECT * FROM student1 WHERE percentage >= 60";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url);
            Statement statement = (Statement) connection.createStatement();
            ResultSet rs = statement.executeQuery(select);

            out.println("<html><body>");
            out.println("<h2>Student Details:</h2>");

            while (rs.next()) {
                out.println("<p>Grade: " + rs.getString(1) + "</p>");
                out.println("<p>Telugu: " + rs.getString(2) + "</p>");
                out.println("<p>Hindi: " + rs.getString(3) + "</p>");
                out.println("<p>English: " + rs.getString(4) + "</p>");
                out.println("<p>Maths: " + rs.getString(5) + "</p>");
                out.println("<p>Science: " + rs.getString(6) + "</p>");
                out.println("<p>Social: " + rs.getString(7) + "</p>");
                out.println("<p>Total Marks: " + rs.getInt(9) + "</p>");
                out.println("<p>Percentage: " + rs.getFloat(8) + "</p>");
                out.println("<hr>");
            }

            out.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}