package com.storyteller_f.asmp.output.map;

import java.util.HashMap;
import java.util.List;

public class CPPOutput implements Output {
    @Override
    public String output(HashMap<String, List<String>> data) {
        StringBuilder result = new StringBuilder("std::map<std::string,std::vector<std::string>> map;\n");
        for (String s : data.keySet()) {
            result.append("map.insert(std::pair<std::string,std::vector<std::string>>(\"").append(s)
                    .append("\",{").append(getArray(data.get(s))).append("}));\n");
        }
        return result.toString();
    }
}
