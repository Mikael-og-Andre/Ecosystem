import java.io.FileWriter;
import java.io.IOException;

public class CSVLogger {

    private static FileWriter csvWriter;
    StringBuilder string;

    public CSVLogger(){
        string = new StringBuilder();
    }

    public static void writeFile(StringBuilder text, String fileName) throws IOException {
        csvWriter = new FileWriter(fileName);
        csvWriter.append(text.toString());
        csvWriter.flush();
        csvWriter.close();
    }

    public void addToString(String s){
        string.append(s+",");
    }

    public void addToStringNewLine(String s){
        string.append(s+",\n");
    }

    public StringBuilder getBuilder(){
        return string;
    }

    public void reset(){
        string = new StringBuilder();
    }
}
