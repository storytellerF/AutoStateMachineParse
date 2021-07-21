package com.storyteller_f.read;

import java.util.HashMap;
import java.util.List;

public abstract class Read {
    protected String path;

    public Read(String path) {
        this.path = path;
    }

    public abstract HashMap<String, List<String>> read(int row,int col);
}
