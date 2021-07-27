package com.storyteller_f.asmp.output.map;

import java.util.HashMap;
import java.util.List;

public class KotlinOutput implements Output{
    @Override
    public String output(HashMap<String, List<String>> data) {
        StringBuilder stringBuilder = new StringBuilder("val map= mapOf(\n");
        for (String s : data.keySet()) {
            stringBuilder.append("\tPair(\"").append(s).append("\",arrayOf(").append(getArray(data.get(s))).append(")),\n");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()-1);
        stringBuilder.append(")\n");
        return stringBuilder.toString();
    }
}
