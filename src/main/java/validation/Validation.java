package validation;

import static error.ErrorMessage.BLANK_INPUT_ERROR;
import static error.ErrorMessage.DIVIDE_LOTTO_VALUE_ERROR;
import static error.ErrorMessage.INVALID_INPUT_ERROR;
import static error.ErrorMessage.NUM_RANGE_ERROR;
import static error.ErrorMessage.OVER_INPUT_ERROR;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    private static final int MAX_MONEY = 100000;
    private static final int LOTTO_NUM_START = 1;
    private static final int LOTTO_NUM_END = 45;
    private static final int LOTTO_VALUE = 1000;

    public static void blankInput(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT_ERROR);
        }
    }

    public static void numberInput(String str) {
        int num;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
        if (num <= 0) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    public static void overInput(int inputMoney) {
        if (inputMoney > MAX_MONEY) {
            throw new IllegalArgumentException(OVER_INPUT_ERROR);
        }
    }

    public static <T> void duplicate(List<T> input) {
        Set<T> hashSet = new HashSet<>();
        hashSet.addAll(input);
        if (hashSet.size() != input.size()) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    public static void range(int inputNum) {
        if (inputNum < LOTTO_NUM_START || inputNum > LOTTO_NUM_END) {
            throw new IllegalArgumentException(NUM_RANGE_ERROR);
        }
    }

    public static void divideByLottoValue(int purchaseAmount) {
        if (purchaseAmount % LOTTO_VALUE != 0) {
            throw new IllegalArgumentException(DIVIDE_LOTTO_VALUE_ERROR);
        }
    }
}

