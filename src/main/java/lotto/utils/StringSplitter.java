package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {

    private StringSplitter() {

    }

    public static List<String> splitByDelimiter(String userInput, String delimiter) {
        String[] splittedUserInput = userInput.split(delimiter);
        return Arrays.stream(splittedUserInput).toList();
    }
}
