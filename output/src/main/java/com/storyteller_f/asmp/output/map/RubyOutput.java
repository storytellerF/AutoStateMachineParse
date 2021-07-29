package com.storyteller_f.asmp.output.map;

import com.storyteller_f.asmp.output.OutputAdapter;

import java.util.List;

public class RubyOutput extends OutputAdapter {
    @Override
    protected String onEnd() {
        return "]";
    }

    @Override
    protected String onContent(String stateName, List<String> list) {
        return getKey(stateName)+"=>Array["+getArray(list)+"],\n";
    }

    @Override
    protected String onHeader() {
        return "map=Hash[\n";
    }

    @Override
    public int delete() {
        return 2;
    }
}
