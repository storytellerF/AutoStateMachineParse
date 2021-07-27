package com.storyteller_f.asmp.output.mj;

import com.storyteller_f.asmp.output.map.Output;

import java.util.HashMap;
import java.util.List;

public class COutput implements Output {
    @Override
    public String output(HashMap<String, List<String>> data) {
        StringBuilder enumStringBuilder = new StringBuilder("enum State{\n\t");
        for (String s : data.keySet()) {
            enumStringBuilder.append(s).append(", ");
        }
        StringBuilder result = new StringBuilder(String.format("char map[%d][%d]={\n",data.size(),data.get(data.keySet().iterator().next()).size()));
        if (enumStringBuilder.length() > 0) {
            enumStringBuilder.delete(enumStringBuilder.length()-2,enumStringBuilder.length());
        }
        enumStringBuilder.append("\n};\n");
        //初始化数组
        for (String s : data.keySet()) {
            List<String> list = data.get(s);
            StringBuilder array = getEnum(list);
            array.append("}");
            array.insert(0, "{");
            result.append("\t").append(array).append("\n");
        }
        result.append("};\n");
        result.insert(0, enumStringBuilder);
        return result.toString();
    }
}
