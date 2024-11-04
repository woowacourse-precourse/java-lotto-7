package lotto.model.parseLotto;

import java.util.Arrays;
import java.util.List;
import lotto.error.ErrorMessage;


public class ParseLotto {

    private static String winNumberDelimiter = ",";

    public static List<String> splitWinNumber(String winNumbers) {
        return Arrays.asList(winNumbers.split(winNumberDelimiter));

    }

    public static List<Integer> winNumberStrToInteger(List<String> winNumbers) {
        if (validateWinNumberNotNumber(winNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.NOTNUMBERWINNUMBERS.getMessage());
        }

        return winNumbers.stream().map(Integer::parseInt).toList();
    }

    private static boolean validateWinNumberNotNumber(List<String> winNumbersStr) {
        try {
            winNumbersStr.stream().map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            return true;
        }

        return false;
    }
}
