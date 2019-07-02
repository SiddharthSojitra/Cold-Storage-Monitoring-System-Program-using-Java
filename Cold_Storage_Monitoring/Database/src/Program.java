//jar files are available in files section of canvas

import java.sql.*;


public class Program {

    public static void main(String[] args) {
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
 
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException e) { 
            System.out.println("Problem in loading or " + "registering MS Access JDBC driver");
            e.printStackTrace();
        }
 
        try {
 
            String msAccDB = "C:\\Users\\Sid\\Documents\\Cold_Storage_Monitoring\\C_S_M_S_Master.accdb";
            String dbURL = "jdbc:ucanaccess://" + msAccDB; 

            connection = DriverManager.getConnection(dbURL); 
            statement = connection.createStatement();
            
                        
            resultSet = statement.executeQuery("SELECT * FROM Employee_Master");
 
            System.out.println("ID\tName\tBranch");
            System.out.println("==\t======\t======");
            
            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
             try {
                if(null != connection) {
                    resultSet.close();
                    statement.close();
                    connection.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
        
}

/*
For MySql

Class.forName("com.mysql.jdbc.Driver");  
String dbURL = "jdbc:mysql://localhost/test";
connection=DriverManager.getConnection(  
dbURL,"root","");


For Access
Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
String msAccDB = "D:/java/mydb.accdb";
String dbURL = "jdbc:ucanaccess://" + msAccDB; 
connection = DriverManager.getConnection(dbURL); 


*/