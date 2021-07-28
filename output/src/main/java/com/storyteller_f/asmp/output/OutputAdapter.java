package com.storyteller_f.asmp.output;

import com.storyteller_f.asmp.output.map.Output;

import java.util.HashMap;
import java.util.List;

public abstract class OutputAdapter implements Output {
    @Override
    public String output(HashMap<String, List<String>> data) {
        String header = onHeader();
        StringBuilder stringBuilder = new StringBuilder(header);
        for (String s : data.keySet()) {
            stringBuilder.append(onContent(s, data.get(s))).append("\n");
        }
        int delete = delete();
        if (delete > 0) {
            stringBuilder.delete(stringBuilder.length() - delete - 1, stringBuilder.length() - 1);
        }
        stringBuilder.append(onEnd()).append("\n");
        return stringBuilder.toString();
    }

    protected abstract String onEnd();

    protected abstract String onContent(String s, List<String> strings);

    protected abstract String onHeader();

    public abstract int delete();
}
