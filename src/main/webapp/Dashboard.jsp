<%@ page import="java.sql.Connection" %>
<%@ page import="volunteer.Volunteer" %>
<%@ page import="static java.lang.Class.forName" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Mncedisi
  Date: 2020/09/08
  Time: 5:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type='text/css' rel='stylesheet' href='cssFile.css'/>
    <link type='text/css' rel='stylesheet' href='DashboardCss.css'/>

    <style>

        .dashHead{

            border:2px solid blue;
            border-radius:40px;
            color: chartreuse;

        }
        .dashData{

            border:2px solid blue;
            border-radius:40px;

        }

        #deliverNum{
            border-radius:40px;
        }

        #deliveryBtn{

            font-size: larger;
            background: red;
            padding: initial;
            border-radius:40px;

        }

    </style>

</head>
<body>

<div class="container">

    <header>



        <table id="logoTable2">

            <tr>


                <td id="logo">

                    <img src="Logo2.jpg" width="100" height="100">

                </td>

                <td>

                    <p class="word">Food Parcel</p>

                </td>


            </tr>

        </table>

        <table id="navTable">

            <tr>

                <td>

                    <a href="home.html" class = "nav_link"></a>

                </td>

                <td>

                    <a href="home.html" class = "nav_link">Home</a>

                </td>


                <td>

                    <a href="Deregistration.jsp" class = "nav_link">Deregister</a>

                </td>


                <td>


                    <a href="about.html" class = "nav_link">About</a>
                </td>

                <td>


                    <a href="Login.jsp" class = "nav_link">Logout</a>
                </td>

                <td>


                    <a href="" class = "nav_link"></a>
                </td>

            </tr>

        </table>



    </header>



    <div id="dashboardBox">

        <h3>Volunteer Dasboard</h3>
        <hr>

        <p>Please Select a delivery that you have completed....</p>
        <table id="detailsTable">



            <tr>

                <th class="dashHead">Delivery Number</th>
                <th class="dashHead">Address</th>
                <th class="dashHead">Number of parcels</th>
            </tr>


            <%


                String dbFile = "C:\\Users\\Mncedisi\\IdeaProjects\\Project3-Mncedisi-Helpfull-Mngadi-214210286\\FoodParcel.mdb";
                String dbURL = "jdbc:ucanaccess://"+dbFile.trim();
                Connection con;

                try {

                    forName("net.ucanaccess.jdbc.UcanaccessDriver");
                    con = DriverManager.getConnection(dbURL);

                    String query = "select * from delivery";
                    Statement stm = con.createStatement();
                    ResultSet rs = stm.executeQuery(query);

                    while(rs.next()){

            %>
            <tr>
                <td class="dashData"><%=rs.getString(1)%></td>
                <td class="dashData"><%=rs.getString(2)%></td>
                <td class="dashData"><%=rs.getString(3)%></td>
            </tr>

            <%








                    }


                }catch (Exception exception) {

                    System.out.println(exception.getMessage());
                }


            %>


            <tr>
                <form action="DashBoardServlet" method="post">
                    <td>


                       <input id="deliverNum" type="number" placeholder="Delivery Number" name="deliveryId"/>

                    </td>

                    <td>
                        <input id="deliveryBtn" type="submit" value="Delivery Made">

                    </td>

                </form>

            </tr>

</table>




    </div>



    <div id="pagefooter2">


        <p>&copy; 2020 - Food Parcel.Ltd</p>
        <script type="text/javascript">
            var todaysDate;

            todaysDate=new Date();

            document.write(todaysDate+"<br>");

        </script>

    </div>


</div>



</body>


</html>