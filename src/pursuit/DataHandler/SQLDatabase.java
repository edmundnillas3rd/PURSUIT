
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
    
    private static String tblPlanName;
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
            stmt = SQLDatabase.getCon().createStatement();
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
        } catch (SQLException ex) {
            Logger.getLogger(SQLDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static ResultSet queryTable(String tblName) throws Exception {
        return SQLDatabase.getCon().createStatement().executeQuery("SELECT * FROM " + tblName + ";");
    }
    
    public static ResultSet queryTable(String tblName, String column1) throws Exception {
        return SQLDatabase.getCon().createStatement().executeQuery("SELECT " + column1 + " FROM " + tblName + ";");
    }
    
    public static ResultSet queryTable(String tblName, String column1, String column2) throws Exception {
        return SQLDatabase.getCon().createStatement().executeQuery("SELECT " + column1 + ", " + column2 + " FROM " + tblName);
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
    
    public static void updateData(String tblName, String column, String value) {
        try {
            Connection con = SQLDatabase.getCon();
            PreparedStatement stmt = con.prepareStatement("UPDATE " + tblName + " SET " + column + "=?;");
            stmt.setString(1, value);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception ex) {
            Logger.getLogger(SQLDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ResultSet getData(String query) throws Exception {
        return SQLDatabase.getCon().createStatement().executeQuery(query);
    }
    
    public static void setTblName(String tblName) {
        tblPlanName = tblName;
    }
    
    public static String getTblName() {
        return tblPlanName;
    }
    
    public static String getWorkoutColumn() {
        return columnWorkout;
    }
    
    public static String getWorkoutDurationColumn() {
        return columnWorkoutDuration;
    }
    
    public static String getDietColumn() {
        return columnDiet;
    }
}
