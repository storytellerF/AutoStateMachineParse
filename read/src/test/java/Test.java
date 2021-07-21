import com.storyteller_f.read.ExcelRead;

import java.util.HashMap;
import java.util.List;

public class Test {
    @org.junit.jupiter.api.Test
    public void testOds() {
        String path="C:\\Users\\faber\\Documents\\test.ods";
        ExcelRead excelRead=new ExcelRead(path);
        HashMap<String, List<String>> read = excelRead.read(8, 7);
        System.out.println(read.size());
    }
}
