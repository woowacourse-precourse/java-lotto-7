package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class ParseUtils {

    public static List<Integer> convertToNumbers(List<String> inputs) {
        List<Integer> convertedNumbers = new ArrayList<>();

        for (String winNumber : inputs) {
            convertedNumbers.add(Integer.valueOf(winNumber));
        }
        return convertedNumbers;
    }

    public static List<String> removeWhitespace(String[] inputs) {
        List<String> trimmedWinNumbers = new ArrayList<>();
        for (String winNumber : inputs ) {
            trimmedWinNumbers.add(winNumber.trim());
        }
        return trimmedWinNumbers;
    }
}
