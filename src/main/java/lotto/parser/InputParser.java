package lotto.parser;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public static List<String> parseInputString(String input) {
        return Arrays.stream(input.split(",")).toList();
    }

    public static List<Integer> parseIntNumbers(String input){
        return parseInputString(input).stream().map(Integer::parseInt).toList();
    }

    public static Integer parseIntNumber(String input){
        return Integer.parseInt(input);
    }
}
