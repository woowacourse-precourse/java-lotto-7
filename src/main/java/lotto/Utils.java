package lotto;

import static lotto.ExceptionHandler.validateNumeric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    private static final String COMMA = ",";

    public static List<String> parseByComma(String text) {
        List<String> parsedText = Arrays.asList(text.split(COMMA));
        parsedText.replaceAll(String::strip);
        return parsedText;
    }

    public static List<Integer> convertToNumber(List<String> numbersText) {
        List<Integer> commaSeperatedNumber = new ArrayList<>();
        for (String numberText : numbersText) {
            validateNumeric(numberText);
            commaSeperatedNumber.add(Integer.parseInt(numberText));
        }
        return commaSeperatedNumber;
    }
}
