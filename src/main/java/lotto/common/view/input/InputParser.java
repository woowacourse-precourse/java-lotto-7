package lotto.common.view.input;

import lotto.common.error.CustomException;
import lotto.common.error.ErrorMessage;
import java.util.Arrays;
import java.util.List;

public class InputParser {
    private static final String COMMA = ",";
    private static final int PURCHASE_UNIT = 1000;
    private static final int MAX_LOTTO = 10;
    private static final int ZERO = 0;
    private static final int MAX = 45;
    private static final int MIN = 0;

    public static int toAmount(String input) {
        int number = toInteger(input);
        validateNegative(number);
        validateAmount(number);
        return number;
    }

    public static List<Integer> toLottoNumbers(String input) {
        return Arrays.stream(split(input))
                .map(InputParser::toLottoNumber)
                .toList();
    }

    public static int toLottoNumber(String input) {
        int number = toInteger(input);
        validateNegative(number);
        validateRange(number);
        return number;
    }

    private static String[] split(String input) {
        return input.split(COMMA);
    }

    private static int toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new CustomException(ErrorMessage.AMOUNT_SHOULD_NUMBER_ERROR_MESSAGE.toString());
        }
    }

    private static void validateAmount(int amount) {
        if (isAmountUnit(amount)) {
            throw new CustomException(ErrorMessage.PURCHASE_AMOUNT_ERROR_MESSAGE.format(PURCHASE_UNIT));
        }

        if (isMaxPurchase(amount)) {
            throw new CustomException(ErrorMessage.LOTTO_MAX_PURCHASE_ERROR_MESSAGE.toString());
        }
    }

    private static void validateNegative(int number) {
        if (isNegative(number)) {
            throw new CustomException(ErrorMessage.AMOUNT_SHOULD_NUMBER_ERROR_MESSAGE.toString());
        }
    }

    private static void validateRange(int n) {
        if (isLottoRange(n)) {
            throw new CustomException(ErrorMessage.NUMBER_RANGE_ERROR_MESSAGE.toString());
        }
    }

    private static boolean isMaxPurchase(int amount) {
        return amount / PURCHASE_UNIT > MAX_LOTTO;
    }

    private static boolean isAmountUnit(int amount) {
        return amount % PURCHASE_UNIT != ZERO || amount == ZERO;
    }

    private static boolean isNegative(int number) {
        return number < MIN;
    }

    private static boolean isLottoRange(int n) {
        return n < MIN || n > MAX;
    }

}
