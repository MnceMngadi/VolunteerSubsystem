package volunteer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "/SignUpServlet")
public class SignUpServlet extends HttpServlet {

    private  Volunteer volunteer;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
       // out.println(request.getParameter("fname"));


            volunteer = new Volunteer(request.getParameter("fname"), request.getParameter("lname"), request.getParameter("Gender"), Integer.parseInt(request.getParameter("age")), Long.parseLong(request.getParameter("idnumber")), Long.parseLong(request.getParameter("pnumber")), request.getParameter("language"), request.getParameter("Province"), request.getParameter("uname"), request.getParameter("password"));

            sendingToDb();

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
            response.getWriter().println("<a href=\"Dashboard.jsp\" class = \"nav_link\">Dash Board</a>");
            response.getWriter().println("</td>");
            response.getWriter().println("<td>");
            response.getWriter().println("<a href=\"Deregistration.jsp\" class = \"nav_link\">Deregister</a>");
            response.getWriter().println("</td>");
            response.getWriter().println("<td>");
            response.getWriter().println("<a href=\"Services.html\" class = \"nav_link\">Delivery</a>");
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
            response.getWriter().println("<p>Congratulation to you "+request.getParameter("fname")+" for Joining The team that is serving the community in these dificult times..</p>");
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

    public void sendingToDb(){

        Volunteer create = new Volunteer();

        create.createDatabase();
        create.createDeliveryTable();
        create.register(volunteer);
        create.loggedIn(volunteer);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }



}
