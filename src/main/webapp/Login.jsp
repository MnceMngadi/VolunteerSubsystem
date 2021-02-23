<%--
  Created by IntelliJ IDEA.
  User: Mncedisi
  Date: 2020/09/10
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link type='text/css' rel='stylesheet' href='cssFile.css'/>
    <link type='text/css' rel='stylesheet' href='serveletCss.css'/>

    <style>

        .loginLabel{

             color: #F2F2F2;
             font-family: century Gothic;
        }

        .loginField{

            border-radius:40px;
        }

        #submitId{

            border-radius:40px;
            background: green;
            font-size: medium;
        }

        #openAccountId{

            border-radius:40px;
            background: darkturquoise;
            font-size: medium;

        }

        #loginTable{

            margin: auto;

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

        <table id="navTable23">

            <tr>


                <td id="home">

                    <a href="home.html" class = "nav_link"></a>

                </td>

                <td>

                    <a href="home.html" class = "nav_link">Home</a>

                </td>

                <td>

                    <a href="Gallery.html" class = "nav_link">Accounting</a>

                </td>

                <td>

                    <a href="Services.html" class = "nav_link">Delivery</a>

                </td>

                <td>


                    <a href="about.html" class = "nav_link">Beneficiary</a>
                </td>

                <td>


                    <a href="about.html" class = "nav_link">Employee</a>
                </td>

            </tr>

        </table>



    </header>



    <div id="loginBox">

        <h3>Login as a volunteer</h3>
        <hr>

        <p>Please enter your credentials....</p>

        <table id="loginTable">

            <form>

                <tr>
                    <td>
                        <label class="loginLabel">Enter Username:</label><br>
                        <input class="loginField" name="username" type="text"><br><br>
                        <label class="loginLabel">Enter Password:</label><br>
                        <input class="loginField" name="password" type="password"><br><br>
                        <a href="Dashboard.jsp"><input id="submitId" type="button" value="Login"></a><a href="SignUp.html"><input id="openAccountId" type="button" value="Or Create Account"></a>
                    </td>

                </tr>

            </form>

        </table>




    </div>



    <div id="page_footer23">


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
