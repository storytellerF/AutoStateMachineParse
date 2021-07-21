import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class JavaScriptOutput implements Output{
    @Override
    public String output(HashMap<String, List<String>> data) {
        StringBuilder stringBuilder=new StringBuilder("let map=new Map();\n");
        Set<String> strings = data.keySet();
        for (String string : strings) {
            List<String> list = data.get(string);
            StringBuilder array=new StringBuilder("[");
            for (String s : list) {
                array.append("\"").append(s).append("\",");
            }
            array.deleteCharAt(array.length()-1);
            array.append("]");
            stringBuilder.append("map.set(\"").append(string).append("\",").append(array).append(";\n");
        }
        return stringBuilder.toString();
    }
}
