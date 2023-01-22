package dataOp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteOp {
    public static void main(String[] args) {

    }
    public static boolean canWrite(String filePath, String line){
        File file = new File(filePath);
        try {
            Scanner myReader = new Scanner(file);
            String descLine = myReader.nextLine().toString();
            int descLineCount = descLine.split(":").length;
            int lineCount = line.split(":").length;
            return descLineCount == lineCount;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void appendFile(String filePath,String line){
        if (canWrite(filePath,line)){
            try {
                File myObj = new File(filePath);
                if (myObj.createNewFile()) {
                    System.out.print("Enter description line [example][user:pass] : ");
                    Scanner descLine = new Scanner(System.in);
                    FileWriter myWriter = new FileWriter(filePath);
                    myWriter.write(descLine.nextLine());
                    myWriter.close();
                    FileWriter mySecondWriter = new FileWriter(filePath,true);
                    mySecondWriter.write('\n' + line);
                    mySecondWriter.close();
                } else {
                    FileWriter myWriter = new FileWriter(filePath,true);
                    myWriter.write('\n' + line);
                    myWriter.close();
                }

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }else {
            System.out.println("Nashod Zakhar");
        }
    }

}
