package lotto.util;
import java.util.Arrays;
import java.util.List;

public class InputParser {

    public static List<String> parseInput(String input) {
        return Arrays.asList(input.split(","));
    }

}