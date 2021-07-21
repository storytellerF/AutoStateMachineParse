import java.util.Arrays;
import java.util.List;

public class Factory {
    public static Output get(String type) {
        switch (type) {
            case "JavaScript":
                return new JavaScriptOutput();
            case "Java":
                return new JavaOutput();
        }
        return new JavaScriptOutput();
    }

    public static List<String> type() {
        return Arrays.asList("JavaScript", "Java");
    }
}
