package Lab07_SQLAccess;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner ;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class Lab07_SQLAccess {
    static String strPassword ="";
    static Scanner input;
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        //strPassword = getPassword();
       // executeSQL(strPassword,sql);
        int choice =0;
        while(choice!=6){
            choice = displayMenu();
            execute(choice);
        }

    }


    static int displayMenu(){
        input = new Scanner(System.in);
        System.out.println ( "------------------------------------------------------------------" );
        System.out.println ( "1.\tDisplay Job IDs, descriptions, and pay rates " );
        System.out.println ( "2.\tDisplay employees IDs, first name, last name, and job description " );
        System.out.println ( "3.\tAdd a Job" );
        System.out.println ( "4.\tEdit a job by list number" );
        System.out.println ( "5.\tEdit a person by list number" );
        System.out.println ( "6.\tExit the program " );
        System.out.println ( "------------------------------------------------------------------" );
        System.out.print(">>");
        return input.nextInt();
    }
    static void execute(int choice){
        switch (choice){
            case 1: displaySQL(menu1());break;
            case 2: displaySQL(menu2());break;
            case 3: menu3();break;
            case 4: menu4();break;
            case 5: menu5();break;
            case 6: System.exit(0);
        }
    }

    static String menu1(){
        return "Select Jobcode, description, payrate from job ";
    }

    static String menu2(){
        return "Select e.emplID, e.firstname, e.lastname, j.description from Employee e inner join Job j ON e.Jobcode = j.Jobcode order by emplID";
    }

    static void menu3(){
        input = new Scanner(System.in);
        System.out.println("Enter the job code");
        int jobCode= input.nextInt();
        System.out.println("Enter the job description");
        String jobDes = "'"+input.next()+"',";
        System.out.println("Enter its pay rate");
        float payRate = input.nextFloat();
        System.out.println("1.Salary 2.Hourly");
        String payClass;
        if(input.nextInt()==1){
            payClass = "'"+"Salary"+"'";
        }else payClass = "'"+"Hourly"+"'";

        String statement = "Insert Into Job Values"+"("+jobCode+","+jobDes+payRate+","+payClass+")";
        executeUpdate(statement);
    }

    static void menu4(){
        displaySQL("Select JobCode, description, payrate, payclass from job ");
        input = new Scanner(System.in);
        System.out.println("Enter a number you want to edit on the list");
        int index = input.nextInt();
        Statement stmt = null;
        ResultSet rset = null;

        Connection conn  = null;

        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection ("jdbc:oracle:thin:@bisoracle.siast.sk.ca:1521:ACAD","CISTU030","bekind");

            stmt = conn.createStatement();

            String SQLQuery = "Select Count(*) from Job";
            rset = stmt.executeQuery(SQLQuery);
            rset.next();
            int size = rset.getInt(1);
            int[] jobCode = new int[size];
            rset = stmt.executeQuery("Select Jobcode from Job order by Jobcode");

            int recordNum =0;
            while(rset.next()){
                jobCode[recordNum] = Integer.valueOf(rset.getString("jobcode"));
                recordNum++;
            }

            for(int i=0; i<jobCode.length+1;i++){
                if(index==i){
                    System.out.println("\n1. Description \n2. Payrate");
                    int editNum = input.nextInt();
                    if(editNum==1){
                        System.out.println("Input a new job description");
                        String newDescription = input.next();
                        String Sql ="Update job set description = '"+newDescription+"' where jobcode = "+jobCode[i-1]+"";
                        stmt.executeUpdate(Sql);
                    }
                    else if(editNum == 2){
                        System.out.println("Input a new job payrate");
                        float newPayRate = input.nextFloat();
                        String Sql ="Update job set payrate = "+newPayRate+" where jobcode = "+jobCode[i-1]+"";
                        stmt.executeUpdate(Sql);

                    }
                }
            }

        }catch(SQLException sqle){
            sqle.printStackTrace();
        }catch(Exception e){
            System.out.println("Unknown error has occurred.");
            System.out.println("Exception!"); e.printStackTrace();
        }finally{
            try{
                rset.close();
                stmt.close();
                conn.close();
            }catch (Exception e){
                System.out.println("Warning.");
                System.out.println("Failed to free up system resources");
            }
        }
    }

    static void menu5(){
        displaySQL("Select employee.EmplID, employee.firstname, employee.lastname, employee.jobcode, Job.DESCRIPTION from Employee Inner JOIN Job on employee.Jobcode = Job.Jobcode order by EmplID");
        input = new Scanner(System.in);
        System.out.println("Enter a number you want to edit on the list");
        int index = input.nextInt();
        Statement stmt = null;
        ResultSet rset = null;
        ResultSetMetaData rsmd = null;
        Connection conn  = null;

        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection ("jdbc:oracle:thin:@bisoracle.siast.sk.ca:1521:ACAD","CISTU030","bekind");

            stmt = conn.createStatement();

            String SQLQuery = "Select Count(*) from Employee";
            rset = stmt.executeQuery(SQLQuery);
            rset.next();
            int size = rset.getInt(1);
            int[] emplID = new int[size];
            rset = stmt.executeQuery("Select EmplID from Employee order by EmplID");
            rsmd = rset.getMetaData();

            int recordNum =0;

            while(rset.next()){
                emplID[recordNum] = Integer.valueOf(rset.getString("emplID"));
                recordNum++;
            }

            for(int i=0; i<emplID.length+1;i++){
                if(index==i){
                    System.out.println("\n1. First name \n2. Last name \n3. Job description");
                    int editNum = input.nextInt();
                    if(editNum==1){
                        System.out.println("Input a new first name");
                        String newFirstName = input.next();
                        String Sql ="Update Employee set Firstname = '"+newFirstName+"' where emplID = "+emplID[i-1]+"";
                        stmt.executeUpdate(Sql);
                    }
                    else if(editNum == 2){
                        System.out.println("Input a new last name");
                        String newLastName = input.next();
                        String Sql ="Update Employee set Lastname = '"+newLastName+"' where emplID = "+emplID[i-1]+"";
                        stmt.executeUpdate(Sql);
                    }
                    else if(editNum==3){
                        displaySQL("SELECT JobCode, Description, Payrate, Payclass from Job");
                        System.out.println("Choose the number of the job code you want to change to");
                        int newJobCode = input.nextInt();
                        String Sql ="Update Employee set Jobcode = "+newJobCode+" where emplID = "+emplID[i-1]+"";
                        stmt.executeUpdate(Sql);
                    }
                }
            }

        }catch(SQLException sqle){
            sqle.printStackTrace();
        }catch(Exception e){
            System.out.println("Unknown error has occurred.");
            System.out.println("Exception!"); e.printStackTrace();
        }finally{
            try{
                rset.close();
                stmt.close();
                conn.close();
            }catch (Exception e){
                System.out.println("Warning.");
                System.out.println("Failed to free up system resources");
            }
        }
    }

     static String getPassword() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter a password:");
        JPasswordField pass = new JPasswordField(10);
        panel.add(label);
        panel.add(pass);
        String[] options = new String[]{"OK", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panel, "The title",
                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[1]);

        if (option == 0) // pressing OK button
        {
            char[] password = pass.getPassword();
            strPassword = new String(password);
        }
        return strPassword;
    }

    static void displaySQL(String sql){
        Statement stmt = null;
        ResultSet rset = null;
        ResultSetMetaData rsmd = null;
        Connection conn  = null;

        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection ("jdbc:oracle:thin:@bisoracle.siast.sk.ca:1521:ACAD","CISTU030","bekind");

            stmt = conn.createStatement();
            rset = stmt.executeQuery(sql);
            rsmd  = rset.getMetaData();

            int columnCount = rsmd.getColumnCount();
            int recordNum =1;
            while(rset.next()){
                System.out.print(recordNum+".");
                recordNum++;
                for(int i=0;i<columnCount;i++){
                    System.out.print(" "+rset.getString(i+1));
                }
                System.out.println("\n------------------------------------------");
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }catch(Exception e){
            System.out.println("Unknown error has occurred.");
            System.out.println("Exception!" + e);
        }finally{
            try{
                rset.close();
                stmt.close();
                conn.close();
            }catch (Exception e){
                System.out.println("Warning.");
                System.out.println("Failed to free up system resources");
            }
        }

    }
     static void executeSQL(String password, String sql){
        Statement stmt = null;
        ResultSet rset = null;
        ResultSetMetaData rsmd = null;
        Connection conn  = null;

        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection ("jdbc:oracle:thin:@bisoracle.siast.sk.ca:1521:ACAD","CISTU030",password);

            stmt = conn.createStatement();
            rset = stmt.executeQuery(sql);
            rsmd  = rset.getMetaData();

            int columnCount = rsmd.getColumnCount();
            int recordNum =1;
            while(rset.next()){
                System.out.print(recordNum);
                recordNum++;
                for(int i=0;i<columnCount;i++){
                    System.out.print(". "+rset.getString(i+1));
                }
                System.out.println("\n------------------------------------------");
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }catch(Exception e){
            System.out.println("Unknown error has occurred.");
            System.out.println("Exception!" + e);
        }finally{
            try{
                rset.close();
                stmt.close();
                conn.close();
            }catch (Exception e){
                System.out.println("Warning.");
                System.out.println("Failed to free up system resources");
            }
        }
    }

    static void executeUpdate(String sql){
        Statement stmt = null;

        Connection conn  = null;
        try{
            //register driver
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            //get connection
            conn = DriverManager.getConnection ("jdbc:oracle:thin:@bisoracle.siast.sk.ca:1521:ACAD","CISTU030","bekind");
            //get statement
            stmt = conn.createStatement();
            //create sql statement
            stmt.executeUpdate(sql);

        }catch(SQLException sqle){
            sqle.printStackTrace();
        }catch(Exception e){
            System.out.println("Unknown error has occurred.");
            System.out.println("Exception!" + e);
        }finally{
            try{
                stmt.close();
                conn.close();
            }catch (Exception e){
                System.out.println("Warning.");
                System.out.println("Failed to free up system resources");
            }
        }

    }
}
