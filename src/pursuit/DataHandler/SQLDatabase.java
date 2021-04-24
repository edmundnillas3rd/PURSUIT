
package pursuit.DataHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLDatabase {
    static private Connection c;
    static private Statement stmt;
    
    private final static String columnWorkout = "workout_name";
    private final static String columnWorkoutDuration = "workout_duration";
    private final static String columnDiet = "diet";
    
    public static Connection getCon() {
        try {
            if (c == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String dbUrl = "jdbc:mysql://localhost:3306/plandba";
                String dbUser = "root";
                String dbPass = "dbedmund45";
                c = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            }
        } catch (ClassNotFoundException classNotFoundException) {
            
        } catch (SQLException sQLException) {
            
        }
        return c;
    }
    
    public static void createTable(String tblName) {
        try {
            String name = tblName;
            String q = "CREATE TABLE IF NOT EXISTS " + name + " ("
                    +   columnWorkout + " VARCHAR(100), "
                    +   columnWorkoutDuration + " VARCHAR(100), "
                    +   columnDiet + " VARCHAR(100));";
            stmt = c.createStatement();
            stmt.execute(q);
            System.out.println("Table Successfully Created!");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQLDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void dropTable(String tblName) {
        try {
            String q = "DROP TABLE IF EXISTS " + tblName;
            stmt = c.createStatement();
            stmt.execute(q);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQLDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static void queryTable(String tblName) {
        try {
            stmt = c.createStatement();
        } catch (SQLException ex) {
            
        }
    }
    
    public static void insertData(String tblName, String data) {
        try {
            String name = tblName;
            String query = "INSERT INTO " + name + " ("
                    +   columnDiet 
                    + ") "
                    + "VALUES (?);";
            PreparedStatement stmt = SQLDatabase.getCon().prepareStatement(query);
            stmt.setString(1, data);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQLDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insertData(String tblName, String workoutTypes, String workoutDuration) {
        try {
            String name = tblName;
            String query = "INSERT INTO " + name + " ("
                    +   columnWorkout + ", "
                    +   columnWorkoutDuration
                    +   ") "
                    +   "VALUES (?, ?);";
            PreparedStatement stmt = SQLDatabase.getCon().prepareStatement(query);
            stmt.setString(1, workoutTypes);
            stmt.setString(2, workoutDuration);
            System.out.println("SQL Insert Successful");

            stmt.execute();
            stmt.close();
        } catch (Exception ex) {
            Logger.getLogger(SQLDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ResultSet getData(String query) throws Exception {
        return SQLDatabase.getCon().createStatement().executeQuery(query);
    }
}
