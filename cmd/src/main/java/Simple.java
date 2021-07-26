import com.storyteller_f.read.ExcelRead;
import com.storyteller_f.asmp.output.map.MapFactory;
import com.storyteller_f.asmp.output.map.Output;

import java.util.HashMap;
import java.util.List;

public class Simple {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\faber\\Documents\\test.ods";

        ExcelRead excelRead = new ExcelRead(path);
        HashMap<String, List<String>> read = excelRead.read(8, 7, 0);
        Output output = new MapFactory().get("JavaScript");
        String output1 = output.output(read);
        System.out.println(output1);
    }
}
