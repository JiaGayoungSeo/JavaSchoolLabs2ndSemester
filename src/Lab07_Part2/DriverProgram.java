package Lab07_Part2;

import java.sql.*;

public class DriverProgram {

    public static void main(String[] args){

    }

    public static Job[] getAllJobsAsList(){
        Statement stmt = null;
        ResultSet rset = null;
        ResultSetMetaData rsmd = null;
        Connection conn = getConnection();

        Job[] jobs = null;
        try{

            stmt = conn.createStatement();
            String SQLQuery = "Select Count(JobCode) from Job";
            rset = stmt.executeQuery(SQLQuery);
            rset.next();
            int size = rset.getInt(1);
            jobs = new Job[size];
            SQLQuery = "Select JobCode, Description From Job";
            rset = stmt.executeQuery(SQLQuery);
            int i=0;
            while(rset.next()){
                Job j = new Job();
                j.setJobCode(rset.getInt(1));
                j.setDescription(rset.getString(2));
                jobs[i]=j;
                i++;
            }
        }
        catch(Exception e){e.printStackTrace();}
        return jobs;
    }

    public static Connection getConnection(){
        Connection conn = null;

        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection ("jdbc:oracle:thin:@bisoracle.siast.sk.ca:1521:ACAD","CISTU030","bekind");

        }catch(SQLException sqle){
            sqle.printStackTrace();
        }catch(Exception e){
            System.out.println("Unknown error has occurred.");
            System.out.println("Exception!" + e);
        }
        return conn;
    }
}
