package utils;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String DELIMITER = ",";

    public static List<String> parsing(String inputContent) {
        List<String> splits = splitting(inputContent);
        return trimming(splits);
    }

    private static List<String> splitting(String targetContent) {
        return Arrays.stream(targetContent.split(DELIMITER))
                .toList();
    }

    private static List<String> trimming(List<String> elements) {
        return elements.stream()
                .map(String::strip)
                .toList();
    }

}
