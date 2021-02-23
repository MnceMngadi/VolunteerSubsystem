package volunteer;

import java.sql.*;
import java.util.ArrayList;


public class Volunteer {


    private String name="";
    private String surname="";
    private String gender="";
    private int age=0;
    private long idNumber=0;
    private long phoneNumber=0;
    private String homeLanguage="";
    private String province="";
    private String userName="";
    private String password="";

    public ArrayList<Long> volunteers = new ArrayList<>();
    String droppingTable = "drop table volunteer if exists";
    String droppingTableLogged = "drop table logged if exists";
    String droppingTableDelivery = "drop table delivery if exists";
    String create_table_stmt_logged ="create table logged(Id LONG)";
    String create_table_stmt_delivery ="create table delivery(DeliveryNum LONG, Deliver_Address VARCHAR(100), Number_Of_Parcels INTEGER)";
    String create_Table_stmt="create table volunteer(Id LONG, Name VARCHAR(30), Surname VARCHAR(30), Gender VARCHAR(30), Age INTEGER, Phone_Number LONG, Home_Language VARCHAR(30), User_Name VARCHAR(30), Password VARCHAR(30), Province VARCHAR(30))";
    public static String dbFile = "C:\\Users\\Mncedisi\\IdeaProjects\\Project3-Mncedisi-Helpfull-Mngadi-214210286\\FoodParcel.mdb";
    String dbURL = "jdbc:ucanaccess://"+dbFile.trim();
    public static Connection con;
    Statement s;
    PreparedStatement prstm;




    public Volunteer(){

    }

    public Volunteer(String name, String surname, String gender, int age, long idNumber, long phoneNumber, String homeLanguage, String province, String userName, String password) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.homeLanguage = homeLanguage;
        this.province = province;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getHomeLanguage() {
        return homeLanguage;
    }

    public String getProvince() {
        return province;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setHomeLanguage(String homeLanguage) {
        this.homeLanguage = homeLanguage;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Volonteer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", idNumber=" + idNumber +
                ", phoneNumber=" + phoneNumber +
                ", homeLanguage='" + homeLanguage + '\'' +
                ", province='" + province + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }



    public void register(Volunteer volunteer){


        String insert_Values_stmt="insert into volunteer values(?,?,?,?,?,?,?,?,?,?)";

        try {
                con = Connections.getConnection();
                System.out.println("adding another....");
                prstm = con.prepareStatement(insert_Values_stmt);

                prstm.setLong(1, volunteer.getIdNumber());
                prstm.setString(2, volunteer.getName());
                prstm.setString(3, volunteer.getSurname());
                prstm.setString(4, volunteer.getGender());
                prstm.setInt(5, volunteer.getAge());
                prstm.setLong(6, volunteer.getPhoneNumber());
                prstm.setString(7, volunteer.getHomeLanguage());
                prstm.setString(8, volunteer.getUserName());
                prstm.setString(9, volunteer.getPassword());
                prstm.setString(10, volunteer.getProvince());

                prstm.execute();

            System.out.println("Added....");



        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void createDatabase(){


        try {

            System.out.println("About to get a connection....");
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(dbURL);
            System.out.println("Creating statement Object....");
            s = con.createStatement();
            System.out.println("Statement object created Successfully....");
            System.out.println("About to execute SQL stmt....");
            s.execute(droppingTable);
            s.executeUpdate(create_Table_stmt); // execute the SQL statement

            System.out.println("SQL statement executed  Successfully....");

            //System.out.println("About to close Statement....");
            prstm.close();
            s.close(); // close the Statement to let the database know we're done with it
            con.close(); // close the Connection to let the database know we're done with it
            //System.out.println("Statement closed successfully....");


        }
        catch (Exception err) {
            System.out.println("ERROR: " + err);
        }

    }

    public void loggedIn(Volunteer idNumber){

        try {

            System.out.println("About to get a connection....");
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(dbURL);
            System.out.println("Creating statement Object....");
            s = con.createStatement();
            System.out.println("Statement object created Successfully....");
            System.out.println("About to execute SQL stmt....");
            s.execute(droppingTableLogged);
            s.executeUpdate(create_table_stmt_logged); // execute the SQL statement

            System.out.println("SQL statement executed  Successfully....");

            //System.out.println("About to close Statement....");
            prstm.close();
            s.close(); // close the Statement to let the database know we're done with it
            con.close(); // close the Connection to let the database know we're done with it
            //System.out.println("Statement closed successfully....");


        }
        catch (Exception err) {
            System.out.println("ERROR: " + err);
        }



        String insert_Values_stmt="insert into logged values(?)";

        try {
            con = Connections.getConnection();
            System.out.println("adding another....");
            prstm = con.prepareStatement(insert_Values_stmt);
            System.out.println(idNumber.getIdNumber());
            prstm.setLong(1, idNumber.getIdNumber());


            prstm.execute();

            System.out.println("Added....");



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void createDeliveryTable(){

        try {

            System.out.println("About to get a connection....");
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(dbURL);
            System.out.println("Creating statement Object....");
            s = con.createStatement();
            System.out.println("Statement object created Successfully....");
            System.out.println("About to execute SQL stmt....");
            s.execute(droppingTableDelivery);
            s.executeUpdate(create_table_stmt_delivery); // execute the SQL statement

            System.out.println("SQL statement executed  Successfully....");

            //System.out.println("About to close Statement....");
            prstm.close();
            s.close(); // close the Statement to let the database know we're done with it
            con.close(); // close the Connection to let the database know we're done with it
            //System.out.println("Statement closed successfully....");


        }
        catch (Exception err) {
            System.out.println("ERROR: " + err);
        }


        Delivery d1 = new Delivery(121,"Walacedene 24421 cape town 7075",35);
       Delivery d2 = new Delivery(123,"Mitchelsplain 4125 cape town 7570",55);
       Delivery d3 = new Delivery(124,"Kraaifontein 4571 cape town 7570",100);
       Delivery d4 = new Delivery(125,"Umlazi 15451 durban 031",1500);

       ArrayList<Delivery> deliveries = new ArrayList<>();
       deliveries.add(d1);
       deliveries.add(d2);
       deliveries.add(d3);
       deliveries.add(d4);

        String insert_Values_stmt="insert into delivery values(?,?,?)";

        try {
            con = Connections.getConnection();
            System.out.println("adding another....");


            prstm = con.prepareStatement(insert_Values_stmt);

            for (int y =0; y < deliveries.size(); y++) {

                prstm.setLong(1, deliveries.get(y).getDeleveryNum());
                prstm.setString(2, deliveries.get(y).getDeliveryAddress());
                prstm.setInt(3,deliveries.get(y).getNumberOfParcels());

                prstm.execute();

            }
            System.out.println("Added....");



        } catch (SQLException e) {
            e.printStackTrace();
        }



    }


}



