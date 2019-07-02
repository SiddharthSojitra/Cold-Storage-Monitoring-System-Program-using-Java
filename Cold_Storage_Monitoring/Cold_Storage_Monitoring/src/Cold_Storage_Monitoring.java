import java.util.*;
import java.io.*;
import java.sql.*;

class banner
{
    void agri()
    {                
        System.out.println("\n\t\t    ||     |||||| |||||| |||||| ");
        System.out.println("\t\t   ||||    ||     ||  ||   ||   ");
        System.out.println("\t\t  ||  ||   ||     ||||||   ||   ");
        System.out.println("\t\t ||||||||  ||  || || ||    ||   ");
        System.out.println("\t\t||      || |||||| ||  || |||||| ");
        System.out.println("\t\t================================");
        System.out.println("\t\t  ~ COLD STORAGE DEPARTMENT ~   ");
        System.out.println("\t\t================================\n\n");
    }        
}

class Storage
{     
    String C_1, C_2, C_3, C_4;
    void Get_Compartment_Temprature(String C_1, String C_2, String C_3, String C_4)
    {
        this.C_1 = C_1;
        this.C_2 = C_2;
        this.C_3 = C_3;
        this.C_4 = C_4;
    }

    void storage_structure_display()
    {
        System.out.println("\t||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("\t||             ||             ||             ||             ||");
        System.out.println("\t||     A1      ||     A2      ||     B1      ||     B2      ||");
        System.out.println("\t||     --      ||     --      ||     --      ||     --      ||");
        System.out.println("\t|| Temperature || Temperature || Temperature || Temperature ||");
        System.out.println("\t||     is,     ||     is,     ||     is,     ||     is,     ||");
        System.out.println("\t||    -" + C_2 + "'c    ||    -" + C_2 + "'c    ||    -" + C_3 + "'c    ||    -" + C_4 + "'c    ||");
        System.out.println("\t||             ||             ||             ||             ||");
        System.out.println("\t||             ||             ||             ||             ||");
        System.out.println("\t||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.print("\n\n\t\t\tPress_ENTER_TO_BACK TO MAIN MENU...");
    }
}

public class Cold_Storage_Monitoring 
{
	public static void main(String[] args) throws Exception
	{
		//========================================================================================================================
		//------------------------------------------------------FOR DATEBASE------------------------------------------------------
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try
        {	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");	}
        catch(ClassNotFoundException e) 
        { 	System.out.println("Problem in loading or " + "registering MS Access JDBC driver");
            e.printStackTrace();	}
 
        try 
        {	String msAccDB = "F:\\SEM_4\\(MP) MINI PROJECT\\Cold_Storage_Monitoring\\Database.accdb";
            String dbURL = "jdbc:ucanaccess://" + msAccDB; 
            connection = DriverManager.getConnection(dbURL);         
            statement = connection.createStatement();

		//========================================================================================================================		
		
		
		
		
		Scanner data = new Scanner(System.in);
	    Storage Comp = new Storage();
	    banner display = new banner();
	    
	    
	    String Compartment_1 = "";
	    String Compartment_2 = "";
	    String Compartment_3 = "";
	    String Compartment_4 = "";
	    
	    boolean loop = true;
	    while(loop == true)
	    {
	    	for (int i = 0; i < 100; ++i)	{	System.out.println();	}                            // for clear screen.
	        display.agri();
	
            System.out.println("\n\t\tWhat you want to do...");
            System.out.println("\n\t\t\t PRESS_L_for_Log-In");
            System.out.println("\t\t\t PRESS_E_for_Exit");
            System.out.print("\n\t\t\t\tEnter your choice here...");
            String main_choice = data.nextLine();
            switch(main_choice)
            {                               
                case "E":
                case "e":
                    loop = false;
                    for (int i = 0; i < 100; ++i)	{	System.out.println();	}
                    System.out.print("\n\t Bye...Bye...(*_*)...");
                    data.nextLine();
                break;
	            
                    case "L":
                    case "l":
                    {
	                    for (int i = 0; i < 100; ++i)	{	System.out.println();	}

	                    display.agri();
	                    System.out.print("\t\t >> ENTER USERNAME : ");
	                    String user_name = data.nextLine();
	                    
	                    System.out.print("\t\t >> ENTER PASSWORD : ");
	                    String password = data.nextLine();
	                    
	                    String Admin_ID = "admin";
	                    String Admin_PIN = "java";
	                    
	                    String Emp_ID = "emp";
                        String Emp_PIN = "emp";
	                            
                        if(user_name.equals(Admin_ID) && password.equals(Admin_PIN))
                        {
                            boolean admin_exit=true;
                            while(admin_exit == true)
                            {
                            	for (int i = 0; i < 100; ++i)	{	System.out.println();	}
                                display.agri();
	                                            
                                System.out.println("\n\t\t   >>>> CHOOSE THE OPTION <<<<      ");
                                System.out.println("\t   ------------------------------------------");
                                System.out.println("\t\tPress_AC_FOR_ADD NEW CUSTOMER");
                                System.out.println("\t\tPress_AE_FOR_ADD NEW EMPLOYEE");
                                System.out.println("\t\tPress_SC_FOR_SHOW CUSTOMER DETAILS");
                                System.out.println("\t\tPress_SE_FOR_SHOW EMPLOYEE DETAILS");
                                System.out.println("\t\tPress_SS_FOR_SHOW STORAGE STRUCTURE");
                                System.out.println("\t\tPress_ST_FOR_SET STORAGE TEMPERATURE");
                                System.out.println("\t\tPress_B__FOR_BACK TO MAIN MENU");
                                System.out.println("\t   ------------------------------------------");
                                System.out.print("\t\t\tEnter your choice here...");
	
                                String admin_choice = data.nextLine();
                                switch(admin_choice)
                                {
                                	case "SE":
                                	case "sE":
                                	case "Se":
                                	case "se":
                                	{
                                		for (int i = 0; i < 100; ++i)	{	System.out.println();	}
                                        display.agri();
                                        resultSet = statement.executeQuery("SELECT * FROM Employee_Master");
                                        
                                        System.out.println("\tID\tFirst_Name\tLast_Name\tPhone_No\tCity\t\tPin_Code\tAuthority");
                                        System.out.println("\t==\t==============\t==========\t=========\t========\t========\t==========");
                                        while(resultSet.next())
                                        {	System.out.println("\t" + resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3) + "\t\t" + resultSet.getString(4) + "\t" + resultSet.getString(5) + "\t\t" + resultSet.getString(6) + "\t" + resultSet.getString(7));	}
                                        data.nextLine();
                                	}
                                	break;
                                
                                	case "AE":
                                	case "aE":
                                	case "Ae":
                                	case "ae":
                                	{
                                		for (int i = 0; i < 100; ++i)	{	System.out.println();	}
                                        display.agri();

                                        
                                        System.out.println("\n\t\tEnter Employee details...");
                                        System.out.print("\n\t\t\tFirst_Name_______: ");
                                        String Employee_F_Name = data.nextLine();
                                        System.out.print("\t\t\tLast_Name________: ");
                                        String Employee_L_Name = data.nextLine();
                                        System.out.print("\t\t\tPhone_no.________: ");
                                        String Employee_Phone = data.nextLine();
                                        System.out.print("\t\t\tCity_____________: ");
                                        String Employee_City = data.nextLine();
                                        System.out.print("\t\t\tPin_Code_________: ");
                                        String Employee_Pincode = data.nextLine();
                                        System.out.print("\t\t\tAuthority_________: ");
                                        String Employee_Authority = data.nextLine();
                                        
                                        Statement sql_e = connection.createStatement();
                                		sql_e.executeUpdate("insert into Employee_Master (First_Name,Last_Name,Phone_No,City,Pin_Code,Authority) values ('"+Employee_F_Name+"','"+Employee_L_Name+"','"+Employee_Phone+"','"+Employee_City+"','"+Employee_Pincode+"','"+Employee_Authority+"')");
                                	}
                                	break;
                                
                                    case "AC":
                                    case "ac":
                                    case "Ac":
                                    case "aC":
                                    {
                                    	for (int i = 0; i < 100; ++i)	{	System.out.println();	}
                                        display.agri();
                                        
                                        System.out.println("\n\t\tEnter Customer details...");
                                        System.out.print("\n\t\t\tFirst_Name_______: ");
                                        String Customer_F_Name = data.nextLine();
                                        System.out.print("\t\t\tLast_Name________: ");
                                        String Customer_L_Name = data.nextLine();
                                        System.out.print("\t\t\tPhone_no.________: ");
                                        String Customer_Phone = data.nextLine();
                                        System.out.print("\t\t\tCity_____________: ");
                                        String Customer_City = data.nextLine();
                                        System.out.print("\t\t\tPin_Code_________: ");
                                        String Customer_Pincode = data.nextLine();
                                        System.out.print("\t\t\tItem to Store____: ");
                                        String Customer_Item = data.nextLine();
                                        System.out.print("\t\t\tQuantity of Item_: ");
                                        String Customer_Item_Quantity = data.nextLine();
                                        
                                        Statement sql_c = connection.createStatement();
                                		sql_c.executeUpdate("insert into Customer_Master (First_Name,Last_Name,Phone_No,City,Pin_Code,Item,Quantity) values ('"+Customer_F_Name+"','"+Customer_L_Name+"','"+Customer_Phone+"','"+Customer_City+"','"+Customer_Pincode+"','"+Customer_Item+"','"+Customer_Item_Quantity+"')");
                                    }
                                    break;
	                                                        
                                    case "SC":
                                    case "sc":
                                    case "Sc":
                                    case "sC":
                                	{
                                		for (int i = 0; i < 100; ++i)	{	System.out.println();	}
                                        display.agri();
                                    	resultSet = statement.executeQuery("SELECT * FROM Customer_Master");
                                        
                                        System.out.println("\tID\tFirst_Name\tLast_Name\tPhone_No\tCity\t\tPin_Code\tItem\t\tQuanity");
                                        System.out.println("\t==\t==============\t==========\t=========\t========\t========\t========\t========");
                                        while(resultSet.next())
                                        {	System.out.println("\t" + resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3) + "\t\t" + resultSet.getLong(4) + "\t" + resultSet.getString(5) + "\t\t" + resultSet.getString(6) + "\t\t" + resultSet.getString(7) + "\t\t" + resultSet.getString(8));	}
                                        data.nextLine();
                    				}
                            		break;
	                                                    
                                    case "ST":
                                    case "st":
                                    case "St":
                                    case "sT":
                                            boolean comp_exit=true;
                                            while(comp_exit == true)
                                            {
                                            	for (int i = 0; i < 100; ++i)	{	System.out.println();	}
                                                display.agri();
                                                
                                                System.out.println("\t\t||||||||||||||||||||||||||||||||||||||||||");
                                                System.out.println("\t\t||        ||        ||        ||        ||");
                                                System.out.println("\t\t||   A1   ||   A2   ||   B1   ||   B2   ||");
                                                System.out.println("\t\t||   --   ||   --   ||   --   ||   --   ||");
                                                System.out.println("\t\t||        ||        ||        ||        ||");
                                                System.out.println("\t\t||||||||||||||||||||||||||||||||||||||||||");
                                                System.out.println("\t\t\t\t      Press_E_TO BACK MENU");
                                                
                                                System.out.print("\n\t\t\t Choose the Compartment : ");
                                                String choose_comp = data.nextLine();
	                                                                    
                                                switch(choose_comp)
                                                {
                                                    case "E":
                                                    case "e":
                                                        comp_exit = false;
                                                    break;
	                                                                
                                                    case "A1":
                                                    case "a1":
                                                    	for (int i = 0; i < 100; ++i)	{	System.out.println();	}
	                                                    display.agri();
	                                                    
	                                                    System.out.print("\t\t\t Enter Temperature of the Compartment A1 : ");
	                                                    Compartment_1 = data.nextLine();                                        
                                                    break;
	                                                                            
                                                    case "A2":
                                                    case "a2":
                                                    	for (int i = 0; i < 100; ++i)	{	System.out.println();	}
                                                        display.agri();
                                                        
                                                        System.out.print("\t\t\t Enter Temperature of the Compartment A2 : ");
                                                        Compartment_2 = data.nextLine();
                                                    break;
                                                                
                                                    case "B1":
                                                    case "b1":
                                                    	for (int i = 0; i < 100; ++i)	{	System.out.println();	}
                                                        display.agri();
                                                        
                                                        System.out.print("\t\t\t Enter Temperature of the Compartment B1 : ");
                                                        Compartment_3 = data.nextLine();
                                                    break;
	                                                                            
                                                    case "B2":
                                                    case "b2":
                                                    	for (int i = 0; i < 100; ++i)	{	System.out.println();	}
                                                        display.agri();
                                                        
                                                        System.out.print("\t\t\t Enter Temperature of the Compartment B2 : ");
                                                        Compartment_4 = data.nextLine();
                                                    break;
	                                                                                
                                                   default:
                                                	   for (int i = 0; i < 100; ++i)	{	System.out.println();	}
	                                                    display.agri();
	
	                                                    System.out.println("\t\t!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	                                                    System.out.println("\t\t!!! PLEASE ENTER VALID OPTION !!!");
	                                                    System.out.println("\t\t!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	                            
	                                                    data.nextLine();
                                                    break;
                                                }
                                                Comp.Get_Compartment_Temprature(Compartment_1, Compartment_2, Compartment_3, Compartment_4);
                                            }
                                        break;
	                                            
                                        case "SS":
                                        case "ss":
                                        case "Ss":
                                        case "sS":
                                        	for (int i = 0; i < 100; ++i)	{	System.out.println();	}
                                            display.agri();
                                        	Comp.storage_structure_display();                                            
                                            data.nextLine();
                                        break;
                                            
                                        case "B":
                                        case "b":
                                            admin_exit = false;
                                        break;
	                                                        
	                                                    
	
                                        default:
                                        	for (int i = 0; i < 100; ++i)	{	System.out.println();	}
                                            display.agri();

                                            System.out.println("\t\t!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                            System.out.println("\t\t!!! PLEASE ENTER VALID OPTION !!!");
                                            System.out.println("\t\t!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    
                                            data.nextLine();
                                        break;
                                }
                            }
                        }
	
                        else if(user_name.equals(Emp_ID) && password.equals(Emp_PIN))
                        {
                        	for (int i = 0; i < 100; ++i)	{	System.out.println();	}
                        }
	                            
                        else if(user_name != Admin_ID && user_name != Emp_ID)
                        {
                        	for (int i = 0; i < 100; ++i)	{	System.out.println();	}
	                        display.agri();
	
	                        System.out.println("\t\t  !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	                        System.out.println("\t\t  !!!  PLEASE ENTER VALID  !!!");
	                        System.out.println("\t\t  !!! USER~NAME & PASSWORD !!!");
	                        System.out.println("\t\t  !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	
	                        data.nextLine();
                        }
                    }
                    break;
                    
                    default:
                    	for (int i = 0; i < 100; ++i)	{	System.out.println();	}
                        display.agri();

                        System.out.println("\t\t!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("\t\t!!! PLEASE ENTER VALID OPTION !!!");
                        System.out.println("\t\t!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                        data.nextLine();
                    break;
            }
	    }
	    
		//========================================================================================================================
		//------------------------------------------------------FOR DATEBASE------------------------------------------------------	    
    }catch(SQLException e)
    {	e.printStackTrace();	}
    finally {
         try {
            if(null != connection) 
            {	resultSet.close();
                statement.close();
                connection.close();
            }
         } catch (SQLException e){
            e.printStackTrace(); }}
		//========================================================================================================================
    }
}
