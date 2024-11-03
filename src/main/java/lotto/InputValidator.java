package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final int MULTIPLE = 1000;
    private static final int PURCHASE_AMOUNT_RANGE_START = 1000;
    private static final int PURCHASE_AMOUNT_RANGE_END = 100000;
    private static final int LOTTO_NUMBER_RANGE_START = 1;
    private static final int LOTTO_NUMBER_RANGE_END = 45;
    private static final String ERROR_PREFIX= "[ERROR] ";
    private static final String PURCHASE_AMOUNT = "구매 금액은 1000부터 100000 사이의 1000 단위 숫자여야 합니다.";
    private static final String WINNING_NUMBER = "당첨 번호는 서로 중복되지 않는 1부터 45 사이 6개의 숫자여야 합니다.";
    private static final String BONUS_NUMBER = "보너스 번호는 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자여야 합니다.";
    private static int purchaseAmount;
    private static List<Integer> winningNumbers = new ArrayList<>();
    private static int bonusNumber;

    public static int getPurchaseAmount() {
        return purchaseAmount;
    }

    public static List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public static int getBonusNumber() {
        return bonusNumber;
    }

    public static boolean purchaseAmountValidator(String purchaseAmountStr) {
        try {
            purchaseAmount = stringToInt(purchaseAmountStr);
            rangeValidator(purchaseAmount, PURCHASE_AMOUNT_RANGE_START, PURCHASE_AMOUNT_RANGE_END);
            multipleValidator(purchaseAmount);
        } catch (IllegalArgumentException exception) {
            System.out.println(ERROR_PREFIX + PURCHASE_AMOUNT);
            return false;
        }
        return true;
    }

    private static void multipleValidator(int value) {
        if (value % MULTIPLE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean winningNumberValidator(String winningNumberStr) {
        try {
            List<String> winningNumbersStr = new ArrayList<>(Arrays.asList(winningNumberStr.split(",")));
            if (winningNumbersStr.size() != 6) {
                throw new IllegalArgumentException();
            }
            winningNumbers = stringsToNumbers(winningNumbersStr);
            for (Integer winningNumber : winningNumbers) {
                rangeValidator(winningNumber, LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END);
            }
            if (Utils.hasDuplicate(winningNumbers)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(ERROR_PREFIX + WINNING_NUMBER);
            return false;
        }
        return true;
    }

    private static List<Integer> stringsToNumbers(List<String> strings) {
        List<Integer> numbers = new ArrayList<>();
        for (String string : strings) {
            numbers.add(stringToInt(string));
        }
        return numbers;
    }

    public static boolean bonusNumberValidator(String bonusNumberStr) {
        try {
            bonusNumber = stringToInt(bonusNumberStr);
            rangeValidator(bonusNumber, LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END);
            bonusNumberDuplicateValidator(bonusNumber);
        } catch (IllegalArgumentException exception) {
            System.out.println(ERROR_PREFIX + BONUS_NUMBER);
            return false;
        }
        return true;
    }

    private static void bonusNumberDuplicateValidator(int bonusNumber) {
        Set<Integer> numbers = new HashSet<>(winningNumbers);
        numbers.add(bonusNumber);
        if (numbers.size() != 7) {
            throw new IllegalArgumentException();
        }
    }

    private static int stringToInt(String str) throws IllegalArgumentException {
        return Integer.parseInt(str);
    }

    private static void rangeValidator(int value, int rangeStart, int rangeEnd) {
        if (value < rangeStart || value > rangeEnd) {
            throw new IllegalArgumentException();
        }
    }
}
