package volunteer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.lang.Class.forName;

@WebServlet(name = "/DashBoardServlet")
public class DashBoardServlet extends HttpServlet {

    public static String dbFile = "C:\\Users\\Mncedisi\\IdeaProjects\\Project3-Mncedisi-Helpfull-Mngadi-214210286\\FoodParcel.mdb";
    public static String dbURL = "jdbc:ucanaccess://"+dbFile.trim();
    public static Connection con;
    Statement s;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String deleveryName = "";

        try {
            forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(dbURL);
            s = con.createStatement();

            String query = "select * from delivery WHERE DeliveryNum = " + request.getParameter("deliveryId") + ";" ;
            ResultSet resultSet = s.executeQuery(query);

            while(resultSet.next()){

                deleveryName = resultSet.getString(2);


            }


            String deleteQuery = "DELETE FROM delivery WHERE DeliveryNum = " + request.getParameter("deliveryId") + ";" ;
            int rs = s.executeUpdate(deleteQuery);




        }catch (Exception u){

            System.out.println(u.getMessage());
        }

        response.setContentType("text/html");
        response.getWriter().println("<html lang=\"en\">");
        response.getWriter().println("<head>");
        response.getWriter().println("<meta charset=\"UTF-8\">");
        response.getWriter().println("<title>Title</title>");
        response.getWriter().println("<link type='text/css' rel='stylesheet' href='serveletCss.css'/>");
        response.getWriter().println("<link type='text/css' rel='stylesheet' href='cssFile.css'/>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<div class=\"container\">");
        response.getWriter().println("<header>");
        response.getWriter().println("<table id=\"logoTable\">");
        response.getWriter().println("<tr>");
        response.getWriter().println("<td id=\"logo\">");
        response.getWriter().println("<img src=\"Logo2.jpg\" width=\"100\" height=\"100\">");
        response.getWriter().println("</td>");
        response.getWriter().println("<td>");
        response.getWriter().println("<p class=\"word\">Food Parcel</p>");
        response.getWriter().println("</td>");
        response.getWriter().println("</tr>");
        response.getWriter().println("</table>");
        response.getWriter().println("<table id=\"navTable2\">");
        response.getWriter().println("<tr>");
        response.getWriter().println("<td id=\"home\">");
        response.getWriter().println("<a href=\"home.html\" class = \"nav_link\"></a>");
        response.getWriter().println("</td>");
        response.getWriter().println("<td>");
        response.getWriter().println("<a href=\"home.html\" class = \"nav_link\">Home</a>");
        response.getWriter().println("</td>");
        response.getWriter().println("<td>");
        response.getWriter().println("<a href=\"Deregistration.jsp\" class = \"nav_link\">Deregister</a>");
        response.getWriter().println("</td>");
        response.getWriter().println("<td>");
        response.getWriter().println("<a href=\"Dashboard.jsp\" class = \"nav_link\">Dash Board</a>");
        response.getWriter().println("</td>");
        response.getWriter().println("<td>");
        response.getWriter().println("<a href=\"about.html\" class = \"nav_link\">Beneficiary</a>");
        response.getWriter().println("</td>");
        response.getWriter().println("</tr>");
        response.getWriter().println("</table>");
        response.getWriter().println("</header>");
        response.getWriter().println("<div id=\"serveletBox\">");
        response.getWriter().println("<h3>Congratulations</h3>");
        response.getWriter().println("<hr>");
        response.getWriter().println("<p>Thank you for the delivery at "+deleveryName+"...</p>");
        response.getWriter().println("</div>");
        response.getWriter().println("<div id=\"pagefooter\">");
        response.getWriter().println("<p>&copy; 2020 - Food Parcel.Ltd</p>");
        response.getWriter().println("<script type=\"text/javascript\">");
        response.getWriter().println("var todaysDate;");
        response.getWriter().println("todaysDate=new Date();");
        response.getWriter().println("document.write(todaysDate+\"<br>\");");
        response.getWriter().println("</script>");
        response.getWriter().println("</div>");
        response.getWriter().println("</div>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
