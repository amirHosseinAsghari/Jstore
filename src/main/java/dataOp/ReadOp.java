package dataOp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadOp {
    public static void main() {

    }
    public static ArrayList<String> readFile(String filePath){
        ArrayList<String> lines = new ArrayList<String>();
        File file = new File(filePath);
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                lines.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
    public static ArrayList<String> search(ArrayList<String> lines, String query){
        ArrayList<String> result = new ArrayList<String>();
        for (String line : lines) {
            String[] words = line.split(":");
            for (String word : words) {
                if (word.equals(query)) {
                    result.add(line);
                    break;
                }
            }
        }
        return result;
    }
}
