package com.storyteller_f.asmp.output.map;

import com.storyteller_f.asmp.output.OutputAdapter;

import java.util.List;

public class PerlOutput extends OutputAdapter {

    @Override
    protected String onEnd() {
        return ");";
    }

    @Override
    protected String onContent(String stateName, List<String> list) {
        return getKey(stateName)+"=>["+getArray(list)+"],";
    }

    @Override
    protected String onHeader() {
        return "%map=(\n";
    }

    @Override
    public int delete() {
        return 1;
    }
}
