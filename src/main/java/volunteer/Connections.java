package volunteer;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connections {
    public static String dbFile = "C:\\Users\\Mncedisi\\IdeaProjects\\Project3-Mncedisi-Helpfull-Mngadi-214210286\\FoodParcel.mdb";
    public static String dbURL = "jdbc:ucanaccess://"+dbFile.trim();
    public static Connection con;


    public static Connection getConnection(){

        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(dbURL);

        }catch (Exception e){

            System.out.println(e);
        }

        return con;

    }

}
