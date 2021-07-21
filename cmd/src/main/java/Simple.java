import com.storyteller_f.read.ExcelRead;

import java.util.HashMap;
import java.util.List;

public class Simple {
    public static void main(String[] args) {
        String path = "C:\\Users\\faber\\Documents\\test.ods";

        ExcelRead excelRead = new ExcelRead(path);
        HashMap<String, List<String>> read = excelRead.read(8, 7);
        Output output = Factory.get("JavaScript");
        String output1 = output.output(read);
        System.out.println(output1);
    }
}
