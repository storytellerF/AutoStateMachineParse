package com.storyteller_f.asmp.output.map;

import java.util.HashMap;
import java.util.List;

public class CSharpOutput implements Output{
    @Override
    public String output(HashMap<String, List<String>> data) {
        StringBuilder result = new StringBuilder("Dictionary<string, string[]> map = new Dictionary<string, string[]>();\n");
        for (String s : data.keySet()) {
            result.append("map.Add(\"").append(s).append("\",new string[]{").append(getArray(data.get(s))).append("});\n");
        }
        return result.toString();
    }
}
