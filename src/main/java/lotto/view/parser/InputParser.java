package lotto.view.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import lotto.exception.ErrorMessage;
import lotto.exception.ExceptionHandler;

public class InputParser {

    public int parseInteger(String input) {
        validInteger(input);
        return Integer.parseInt(input);
    }

    public List<Integer> parseWinningNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(input, ",");

        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            validInteger(token);
            numbers.add(Integer.parseInt(token));
        }

        return numbers;
    }

    private void validInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            ExceptionHandler.throwIllegalArgException(ErrorMessage.INVALID_NUMBER);
        }
    }
}
