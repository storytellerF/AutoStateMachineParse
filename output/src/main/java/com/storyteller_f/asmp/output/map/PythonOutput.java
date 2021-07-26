package com.storyteller_f.asmp.output.map;

import java.util.HashMap;
import java.util.List;

public class PythonOutput implements Output{
    @Override
    public String output(HashMap<String, List<String>> data) {
        StringBuilder stringBuilder = new StringBuilder("com.storyteller_f.asmp.output.map={\n");
        data.forEach((s, strings) -> stringBuilder.append("\t\"").append(s).append("\":[").append(getArray(strings)).append("],\n"));
        stringBuilder.deleteCharAt(stringBuilder.length() - 2);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }
}
