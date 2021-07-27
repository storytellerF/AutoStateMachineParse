package com.storyteller_f.asmp.output.map;

import java.util.HashMap;
import java.util.List;

public class PhpOutput implements Output{
    @Override
    public String output(HashMap<String, List<String>> data) {
        StringBuilder stringBuilder = new StringBuilder("$map=array(\n");
        for (String s : data.keySet()) {
            stringBuilder.append("\t\"").append(s).append("\"=>").append("array(").append(getArray(data.get(s))).append(")\n,\n");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(");\n");
        return stringBuilder.toString();
    }
}
