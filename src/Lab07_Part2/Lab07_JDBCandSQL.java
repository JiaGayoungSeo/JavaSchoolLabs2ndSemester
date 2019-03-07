package Lab07_Part2;

import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class Lab07_JDBCandSQL {

    public static void main(String[] args){
       displayEmployee();
       update("Employee","Firstname");
       //delete("Job","Jobcode");
    }

    static void insertEmployee(){
        Scanner input = new Scanner(System.in);
        Connection conn = null;
        PreparedStatement pstmt = null;
        String query = "Insert into Employee(EMPLID,SIN,LastName,FirstName,Street,City,Province,PostalCode,JobCode,IncomeTax,BirthDate,HireDate,JobCodeDate) Values ?,?,?,?,?,?,?,?,?,?,?,?,?";
        try{
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(query); //create an object
            System.out.println("Enter a new emplID");
            int emplID = input.nextInt();
            pstmt.setInt(1,emplID);
            System.out.println("SIN Number");
            int Sin = input.nextInt();
            pstmt.setInt(2, Sin);
            System.out.println("Lastname");
            String lastName = input.next();
            pstmt.setString(3,lastName);
            System.out.println("Firstname");
            String firstName = input.next();
            pstmt.setString(4,firstName);
            System.out.println("Street(address)");
            String street = input.next();
            pstmt.setString(5,street);
            System.out.println("City");
            String city = input.next();
            pstmt.setString(6,city);
            System.out.println("Province");
            String prov = input.next();
            pstmt.setString(7,prov);
            System.out.println("Postal code");
            String postal = input.next();
            pstmt.setString(8,postal);
            System.out.println("Job code");
            int jobCode = input.nextInt();
            pstmt.setInt(9,jobCode);
            System.out.println("Income tax(Y/N)");
            char incomeTax = input.next().charAt(0);
            System.out.println("Birth date");
            System.out.println("Hire date");









            int result = pstmt.executeUpdate();
            System.out.println(result+ "column deleted");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                pstmt.close();
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    static void delete(String table, String index){
        Scanner input = new Scanner(System.in);
        Connection conn = null;
        PreparedStatement pstmt = null;
        String query = "DELETE from "+table+ " Where "+index+" =?";
        System.out.println(query);
        try{
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(query); //create an object
            System.out.println("Enter the "+index+" you want to delete");

            int num = input.nextInt();
            pstmt.setInt(1,num);
            int result = pstmt.executeUpdate();
            System.out.println(result+ "column deleted");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                pstmt.close();
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    static void update(String table, String column){
        Scanner input = new Scanner(System.in);
        Connection conn = null;
        PreparedStatement pstmt = null;
        String query = "UPDATE "+table+" Set "+column+" =? "+" Where "+column+" =?";
        System.out.println(query);
        try{
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(query); //create an object
            System.out.println("Input new information you want to change to");
            String newName = input.nextLine();
            System.out.println("Input the old information you want to change");
            String oldName = input.nextLine();
            pstmt.setString(1,newName);
            pstmt.setString(2, oldName);

            pstmt.executeUpdate();
            System.out.println("column updated");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                pstmt.close();
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    static void displayEmployee(){
        Connection conn = null; // DB 연걸된 상태를 담은 객체
        Statement stmt = null; //SQL 명령어 나타내는 객체
        ResultSet rset = null; //Query를 날리면(select문을 실행하면) 리턴되는 값을 담을 객체

        try{
            String sql ="Select employee.EmplID, employee.firstname, employee.lastname,  Job.DESCRIPTION, Job.PAYRATE from Employee Inner JOIN Job on employee.Jobcode = Job.Jobcode order by EmplID";

            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            rset = stmt.executeQuery(sql);
            System.out.println("EmplID  Firstname  Lastname  Description  Payrate");
            System.out.println("--------------------------------------------------");

            while(rset.next()){
                int emplId = rset.getInt(1);
                String firstName = rset.getString(2);
                String lastName = rset.getString(3);
                String description = rset.getString(4);
                float payRate = rset.getFloat(5);

                String result = emplId+"\t"+firstName+"\t"+lastName+"\t"+description+"\t"+payRate;
                System.out.println(result);
            }
        }
        catch (SQLException sqle){
            System.out.println("Error in SQL");
            sqle.printStackTrace();
        } finally {
            //exit DB connection
            try {
                if(rset!= null){
                    rset.close();
                }
                if (stmt!=null){
                    stmt.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }

    }

    static void displayJob(){
        Connection conn = null; // DB 연걸된 상태를 담은 객체
        PreparedStatement pstm = null; //SQL 명령어 나타내는 객체
        ResultSet rset = null; //Query를 날리면(select문을 실행하면) 리턴되는 값을 담을 객체

        try{
            String quary = "Select * from Job";

            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(quary);
            rset = pstm.executeQuery();
            System.out.println("JobCode Description Payrate Payclass");
            System.out.println("-------------------------------------");

            while(rset.next()){
                int jobCode = rset.getInt(1);
                //int jobCode = rset.getInt("Jobcode");
                String description = rset.getString("Description");
                float payRate = rset.getFloat(3);
                String payClass = rset.getString(4);

                String result = jobCode+"\t"+description+"\t"+payRate+"\t"+payClass;
                System.out.println(result);
            }
        } catch (SQLException sqle){
            System.out.println("Error in SQL");
            sqle.printStackTrace();
        } finally {
            //exit DB connection
            try {
                if(rset!= null){
                    rset.close();
                }
                if (pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }

    }
}
