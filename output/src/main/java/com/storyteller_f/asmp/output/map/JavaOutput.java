package com.storyteller_f.asmp.output.map;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class JavaOutput implements Output{
    @Override
    public String output(HashMap<String, List<String>> data) {
        StringBuilder stringBuilder=new StringBuilder("HashMap<String,String[]> map = new HashMap<>();\n");
        Set<String> strings = data.keySet();
        for (String string : strings) {
            List<String> list1 = data.get(string);
            StringBuilder list = getArray(list1);
            stringBuilder.append("map.put(\"").append(string).append("\",new String[]{").append(list).append("});\n");
        }
        return stringBuilder.toString();
    }


}
