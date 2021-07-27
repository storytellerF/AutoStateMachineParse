package com.storyteller_f.asmp.output.map;

import java.util.HashMap;
import java.util.List;

public class JavaScriptOutput implements Output {
    @Override
    public String output(HashMap<String, List<String>> data) {
        StringBuilder stringBuilder = new StringBuilder("let map=new Map();\n");
        data.forEach((s, strings) -> stringBuilder.append("map.set(\"").append(s).append("\",[")
                .append(getArray(strings))
                .append("]);\n"));
        return stringBuilder.toString();
    }
}
