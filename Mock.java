import java.sql.*;
import java.util.Scanner;
public class Mock {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int userChoice;
        boolean quit = false;

        Connection conn = null;//Init connection with JDBC
        Statement stmt = null;//USed to execute SQL Queries
        try{
        	Class.forName("com.mysql.jdbc.Driver");
		/*Class : Returns the Class object associated with the class or 
 interface with the given string name.*/

     
        	System.out.println("Connecting to a selected database...");
        	conn = DriverManager.getConnection(DB_URL, USER, PASS); //estab frm conn
        	System.out.println("Connected database successfully...");
            	System.out.println("Creating table in given database...");
            	stmt = conn.createStatement();//Allows exe sql queries
           
            	String dbinit = "CREATE DATABASE IF NOT EXISTS helloword";
            	stmt.executeUpdate(dbinit);
           
            do {
                  System.out.println("1. create table");
                  System.out.println("2. Insert");
                  System.out.println("3. update");
                  System.out.println("4 delete");
                  System.out.println("5. select");
                  
                  userChoice = in.nextInt();//accepts upcoming input as int
                  switch (userChoice) {
             
            case 1:
            	String use = "USE helloword";
            	String sql = "CREATE TABLE REGISTRATION1 " +
            			"(id INTEGER not NULL, " +
            			" first VARCHAR(255), " + 
            			" last VARCHAR(255), " + 
            			" age INTEGER, " + 
            			" PRIMARY KEY ( id ))"; 
            	stmt.executeUpdate(use);
            	stmt.executeUpdate(sql);
            	System.out.println("Created table in given database...");
            	break;

             case 2: 
                stmt = conn.createStatement();
     
                sql = "INSERT INTO REGISTRATION1 " +
                   "VALUES (100, 'Zara', 'Ali', 18)";
                stmt.executeUpdate(sql);
                sql = "INSERT INTO REGISTRATION1 " +
                   "VALUES (101, 'Mahnaz', 'Fatma', 25)";
                stmt.executeUpdate(sql);
                sql = "INSERT INTO REGISTRATION1 " +
                   "VALUES (102, 'Zaid', 'Khan', 30)";
                stmt.executeUpdate(sql);
                sql = "INSERT INTO REGISTRATION1 " +
                   "VALUES(103, 'Sumit', 'Mittal', 28)";
                stmt.executeUpdate(sql);
                System.out.println("Inserted records into the table...");
                break;

              case 3:
                 stmt = conn.createStatement();
                 String sql1 = "UPDATE REGISTRATION1 " +
                   "SET age = 30 WHERE id in (100, 101)";
                 stmt.executeUpdate(sql1);
         
                 sql1 = "SELECT id, first, last, age FROM REGISTRATION1";
                 ResultSet rs = stmt.executeQuery(sql1);

                 while(rs.next()){
                	
                	 int id  = rs.getInt("id");
                	 int age = rs.getInt("age");
                	 String first = rs.getString("first");
                	 String last = rs.getString("last");

                	 
                	 System.out.print("ID: " + id);
                	 System.out.print(", Age: " + age);
                	 System.out.print(", First: " + first);
                	 System.out.println(", Last: " + last);
                 }
                 rs.close();
                 break;
                 
              case 4:
                      
                      sql = "DELETE FROM REGISTRATION1 " +
                   "WHERE id = 101";
                      stmt.executeUpdate(sql);
                      sql = "SELECT id, first, last, age FROM REGISTRATION1";
                      ResultSet rs1 = stmt.executeQuery(sql);

                      while(rs1.next()){
                    	  //Retrieve by column name
                    	  int id  = rs1.getInt("id");
                    	  int age = rs1.getInt("age");
                    	  String first = rs1.getString("first");
                    	  String last = rs1.getString("last");

                    	
                    	  System.out.print("ID: " + id);
                    	  System.out.print(", Age: " + age);
                    	  System.out.print(", First: " + first);
                    	  System.out.println(", Last: " + last);
                      }
                      rs1.close();
                      break;
                  case 5:
                    
                        sql = "SELECT id, first, last, age FROM REGISTRATION1";
                        rs = stmt.executeQuery(sql);
             
                        while(rs.next()){
                        	//Retrieve by column name
                        	int id  = rs.getInt("id");
                        	int age = rs.getInt("age");
                        	String first = rs.getString("first");
                        	String last = rs.getString("last");

                        	
                        	System.out.print("ID: " + id);
                        	System.out.print(", Age: " + age);
                        	System.out.print(", First: " + first);
                        	System.out.println(", Last: " + last);
                        }
                        rs.close();
                      break;
 
                  case 0:
                     		 quit = true;
                      break;

                  default:
                        System.out.println("Wrong choice.");
                        break;
                  }
                  System.out.println();
            } while (!quit);

        }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   
 }
  }
