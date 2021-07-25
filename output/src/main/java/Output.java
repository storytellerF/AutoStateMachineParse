import java.util.HashMap;
import java.util.List;

public interface Output {
    default StringBuilder getArray(List<String> list1) {
        StringBuilder list=new StringBuilder();
        for (String s : list1) {
            list.append("\"").append(s).append("\",");
        }
        list.deleteCharAt(list.length() - 1);
        return list;
    }
    String output(HashMap<String, List<String>> data);
}
