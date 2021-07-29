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
            stringBuilder.append("\t").append(onContent(s, data.get(s))).append("\n");
        }
        int delete = delete();
        if (delete > 0) {
            stringBuilder.delete(stringBuilder.length() - delete - 1, stringBuilder.length() - 1);
        }
        stringBuilder.append(onEnd()).append("\n");
        return stringBuilder.toString();
    }

    /**
     * 不需要在尾部添加换行
     * @return
     */
    protected abstract String onEnd();

    /**
     * 不需要自行添加制表符
     * @param stateName 状态名称
     * @param list 状态列表
     * @return
     */
    protected abstract String onContent(String stateName, List<String> list);

    /**
     * 需要根据情况自行添加换行
     * @return 需要添加在头部的信息
     */
    protected abstract String onHeader();

    /**
     * 需要移除多少个字符
     * @return 字符个数
     */
    public abstract int delete();
}
