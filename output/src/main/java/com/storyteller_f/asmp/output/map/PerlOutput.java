package com.storyteller_f.asmp.output.map;

import com.storyteller_f.asmp.output.OutputAdapter;

import java.util.List;

public class PerlOutput extends OutputAdapter {

    @Override
    protected String onEnd() {
        return ")";
    }

    @Override
    protected String onContent(String s, List<String> strings) {
        return "\t"+getKey(s)+"=>("+getArray(strings)+"),";
    }

    @Override
    protected String onHeader() {
        return "$map=\n";
    }

    @Override
    public int delete() {
        return 1;
    }
}
