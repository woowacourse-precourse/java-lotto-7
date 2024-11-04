package lotto.view;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자만 입력해 주세요.";
    private static final String NUMBERS_DELIMITER = ",";
    private static final Integer WINNING_NUMBERS_LENGTH = 6;
    private static final String NUMBER_LENGTH_ERROR_MESSAGE = "[ERROR] 당첨 번호는 ,로 구분된 6개의 숫자만 입력해주세요.";

    public static Integer parseTotalMoney(String raw) {
        isNumber(raw);

        return Integer.parseInt(raw);
    }

    public static List<Integer> parseWinningNumbers(String raw) {
        validateLength(raw);

        List<Integer> winningNumbers = new ArrayList<>();

        for(String rawNumber : raw.split(",")) {
            Integer number = parseNumber(rawNumber);
            winningNumbers.add(number);
        }

        return winningNumbers;
    }

    public static Integer parseNumber(String raw) {
        isNumber(raw);

        return Integer.parseInt(raw);
    }

    public static void validateLength(String raw) {
        String[] numbers = raw.split(NUMBERS_DELIMITER);
        if (numbers.length != WINNING_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(NUMBER_LENGTH_ERROR_MESSAGE);
        }
    }

    private static void isNumber(String raw) {
        try {
            Integer.parseInt(raw);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }
}
