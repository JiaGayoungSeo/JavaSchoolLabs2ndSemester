package MidTermExercise;
import java.io.*;
import java.io.BufferedReader;

public class ResigerProgram {

    public static void main(String[] args){

    }

    static void FileReadMain(){
        File file = new File ( "F:\\COMP233 JAVA\\IntelliJ\\examTestData.txt" );
        try{
            if(checkBeforeReadFile(file)){
                FileReader fileReader = new FileReader ( file );
                int ch = fileReader.read ();
                while(ch!=-1){
                    System.out.print ( (char)ch );
                    ch = fileReader.read ();
                }
                fileReader.close ();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace ();
        } catch(IOException e){
            e.printStackTrace ();
        }
    }

    static boolean checkBeforeReadFile(File file){
        if(file.exists ()){
            if(file.isFile () && file.canRead ()){
                return true;
            }
        }
        return false;
    }




}


