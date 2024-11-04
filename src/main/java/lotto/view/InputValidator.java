package lotto.view;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자만 입력해 주세요.";
    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 1부터 45 사이의 숫자만 입력해 주세요";
    private static final String UNIT_ERROR_MESSAGE = "[ERROR] 1000원 단위로 입력해 주세요.";
    private static final String NUMBER_LENGTH_ERROR_MESSAGE = "[ERROR] 당첨 번호는 ,로 구분된 6개의 숫자만 입력해주세요.";
    private static final String NUMBERS_DELIMITER = ",";
    private static final Integer LOTTERY_PRICE = 1000;
    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 45;
    private static final Integer WINNING_NUMBERS_LENGTH = 6;

    public static Integer parseAmount(String raw) {
        isNumber(raw);
        Integer amount = Integer.parseInt(raw);
        validateAmount(amount);

        return amount / LOTTERY_PRICE;
    }

    private static void validateAmount(Integer amount) {
        if (amount % LOTTERY_PRICE != 0) {
            throw new IllegalArgumentException(UNIT_ERROR_MESSAGE);
        }
    }

    public static List<Integer> parseWinningNumbers(String raw) {
        List<Integer> winningNumbers = new ArrayList<>();

        validateNumbersLength(raw);
        for(String rawNumber : raw.split(",")) {
            Integer number = parseNumber(rawNumber);
            winningNumbers.add(number);
        }
        return winningNumbers;
    }

    private static void validateNumber(Integer number) {
        validateNumberRange(number);
    }

    private static void validateNumberRange(Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    private static void validateNumbersLength(String raw) {
        String[] numbers = raw.split(NUMBERS_DELIMITER);
        if (numbers.length != WINNING_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(NUMBER_LENGTH_ERROR_MESSAGE);
        }
    }

    public static Integer parseNumber(String raw) {
        isNumber(raw);
        Integer number = Integer.parseInt(raw);
        validateNumber(number);

        return number;
    }

    private static void isNumber(String raw) {
        try {
            Integer.parseInt(raw);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }
}
