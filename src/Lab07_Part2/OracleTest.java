package Lab07_Part2;

import java.sql.*;

public class OracleTest {
    public static void main(String[] args){

        Connection conn = null; // DB 연걸된 상태를 담은 객체
        PreparedStatement pstm = null; //SQL 명령어 나타내는 객체
        ResultSet rset = null; //Query를 날리면(select문을 실행하면) 리턴되는 값을 담을 객체

        try{
            String quary = "Select * from Job";

            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(quary);
            rset = pstm.executeQuery();

            while(rset.next()){
                int jobCode = rset.getInt(1);
                //int jobCode = rset.getInt("Jobcode");
                String description = rset.getString("Description");
                float payRate = rset.getFloat(3);
                String payClass = rset.getString(4);

                String result = jobCode+" "+description+" "+payRate+" "+payClass;
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
