import com.storyteller_f.asmp.output.mj.COutput;
import com.storyteller_f.asmp.output.map.Output;
import com.storyteller_f.asmp.output.mj.EnumFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test {
    @org.junit.jupiter.api.Test
    public void testParse() {
        HashMap<String,List<String>> hashMap=new HashMap<>();
        List<String> list=new ArrayList<>(Arrays.asList("start","singed","整数"));

        hashMap.put("start",list);
        Output javaScriptOutput = new EnumFactory().get("C");
        String output = javaScriptOutput.output(hashMap);
        System.out.println(output);
    }
}
