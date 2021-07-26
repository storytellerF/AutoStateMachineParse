package com.storyteller_f.asmp.output.map;

import java.util.HashMap;
import java.util.List;

public class JavaScriptOutput implements Output {
    @Override
    public String output(HashMap<String, List<String>> data) {
        StringBuilder stringBuilder = new StringBuilder("let com.storyteller_f.asmp.output.map=new Map();\n");
        data.forEach((s, strings) -> stringBuilder.append("com.storyteller_f.asmp.output.map.set(\"").append(s).append("\",[")
                .append(getArray(strings))
                .append("]);\n"));
        return stringBuilder.toString();
    }
}
