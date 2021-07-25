import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class Factory {
    public static Output get(String type) {
        try {
            Class<?> outputClass = Class.forName(type + "Output");
            Object o = outputClass.getConstructor().newInstance();
            if (o instanceof Output)
                return (Output) o;
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return new JavaScriptOutput();
    }

    public static List<String> type() {
        return Arrays.asList("JavaScript", "Java", "Python");
    }
}
