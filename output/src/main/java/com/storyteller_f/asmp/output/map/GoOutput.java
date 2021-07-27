package com.storyteller_f.asmp.output.map;

import java.util.HashMap;
import java.util.List;

public class GoOutput implements Output{
    @Override
    public String output(HashMap<String, List<String>> data) {
        StringBuilder stringBuilder = new StringBuilder("var stateMap=map[string][]string\n");
        stringBuilder.append("stateMap = make(map[string][]string)\n");
        for (String s : data.keySet()) {
            stringBuilder.append("stateMap[\"").append(s).append("\"]=[]string{").append(getArray(data.get(s))).append("}\n");
        }
        return stringBuilder.toString();
    }
}
