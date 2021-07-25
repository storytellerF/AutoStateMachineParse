import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;

public class PythonOutput implements Output{
    @Override
    public String output(HashMap<String, List<String>> data) {
        StringBuilder stringBuilder = new StringBuilder("map={\n");
        data.forEach((s, strings) -> stringBuilder.append("\t\"").append(s).append("\":[").append(getArray(strings)).append("],\n"));
        stringBuilder.deleteCharAt(stringBuilder.length() - 2);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }
}
