package utils;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String DELIMITER = ",";

    public static List<String> parsing(String inputContent) {
        List<String> splits = splitting(inputContent);
        trimming(splits);
        return splits;
    }

    private static List<String> splitting(String targetContent) {
        return Arrays.stream(targetContent.split(DELIMITER)).toList();
    }

    private static void trimming(List<String> elements) {
        for (int i = 0; i < elements.size(); i++) {
            elements.set(i, elements.get(i).strip());
        }
    }

}
