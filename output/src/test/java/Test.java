import com.storyteller_f.asmp.output.map.MapFactory;
import com.storyteller_f.asmp.output.map.Output;

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
        Output javaScriptOutput = new MapFactory().get("Go");
        String output = javaScriptOutput.output(hashMap);
        System.out.println(output);
    }
}
