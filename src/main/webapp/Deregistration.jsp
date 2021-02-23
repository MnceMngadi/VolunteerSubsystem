<%--
  Created by IntelliJ IDEA.
  User: Mncedisi
  Date: 2020/09/07
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="static java.lang.Class.forName" %>
<%@ page import="volunteer.Volunteer" %>
<%@ page import="volunteer.SignUpServlet" %>
<%@ page import="static volunteer.Volunteer.dbFile" %>
<%@ page import="static volunteer.Connections.dbURL" %>


<html>
<head>
    <title>Title</title>
    <link type='text/css' rel='stylesheet' href='Deregister.css'/>
    <link type='text/css' rel='stylesheet' href='cssFile.css'/>
    <link type='text/css' rel='stylesheet' href='reg.css'/>
    <link type='text/css' rel='stylesheet' href='footer.css'/>

    <style>

        .deregHead{

            border:2px solid blue;
            border-radius:40px;
            color: chartreuse;

        }
        .dereg{

            border:2px solid blue;
            border-radius:40px;

        }


        #detailsTable{

            width: 20%;

        }
        #text{

            color: #F2F2F2;

        }

        #reBtn{

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



        <table id="logoTable">

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


                <td id="home">

                    <a href="home.html" class = "nav_link"></a>

                </td>

                <td>

                    <a href="home.html" class = "nav_link">Home</a>

                </td>

                <td>

                    <a href="Gallery.html" class = "nav_link">volunteer.Volunteer</a>

                </td>

                <td>

                    <a href="Services.html" class = "nav_link">Delivery</a>

                </td>

                <td>


                    <a href="about.html" class = "nav_link">Beneficiary</a>
                </td>

            </tr>

        </table>



    </header>



    <div id="deregisterBox">

        <h3>Deregister As A volunteer</h3>
        <hr>

        <p>Please confirm if these are your details....</p>
        <form action="DeregistrationServlet" method="post">
        <table id="detailsTable" style="width: 1%">



            <tr>

                <th class="deregHead">Name</th>
                <th class="deregHead">Surname</th>
                <th class="deregHead">User Name</th>
                <th class="deregHead">Id Number</th>
                <th class="deregHead">Province</th>

            </tr>


                <%

                  long g =0;

                    String dbFile1 = "C:\\Users\\Mncedisi\\IdeaProjects\\Project3-Mncedisi-Helpfull-Mngadi-214210286\\FoodParcel.mdb";
                    String dbURL1 = "jdbc:ucanaccess://"+dbFile1.trim();
                    Connection con1;

                    try {

                        forName("net.ucanaccess.jdbc.UcanaccessDriver");
                        con1 = DriverManager.getConnection(dbURL1);


                        String query = "select * from logged";
                        Statement stm = con1.createStatement();
                        ResultSet rs = stm.executeQuery(query);

                        while(rs.next()){

                            g = rs.getLong(1);

                        }

                    }catch (Exception n){

                        System.out.println(n.getMessage());

                    }


                    String dbFile = "C:\\Users\\Mncedisi\\IdeaProjects\\Project3-Mncedisi-Helpfull-Mngadi-214210286\\FoodParcel.mdb";
                    String dbURL = "jdbc:ucanaccess://"+dbFile.trim();
                    Connection con;

                    try {

                        forName("net.ucanaccess.jdbc.UcanaccessDriver");
                        con = DriverManager.getConnection(dbURL);




                        String query = "select * from volunteer where id="+g;
                        Statement stm = con.createStatement();
                        ResultSet rs = stm.executeQuery(query);

                        while(rs.next()){

                            %>
                            <tr>
                                <td class="dereg"><%=rs.getString(2)%></td>
                                <td class="dereg"><%=rs.getString(3)%></td>
                                <td class="dereg"><%=rs.getString(8)%></td>
                                <td class="dereg"><%=rs.getString(1)%></td>
                                <td class="dereg"><%=rs.getString(10)%></td>
                            </tr>
                            <%


                            %>

                            <tr>
                               <td >
                                   <input id="text" type="number" name="idnum" value=<%=g%> >

                               </td>

                                <td class="deregBtn">
                                    <input id="reBtn" type="submit" value="Deregister">
                                </td>

                            </tr>
                            <%

                        }





                    }catch (Exception exception) {

                        System.out.println(exception.getMessage());
                    }


                %>




        </table>


            </form>


    </div>



    <div id="theFooter">


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
