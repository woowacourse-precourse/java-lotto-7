package lotto.util.validator;

import java.util.Arrays;
import java.util.HashSet;

public class InputValidator {

    private final static String MONEY_REGEX = "[1-9][0-9]*000";
    private final static String WINNING_NUMBERS_REGEX
        = "\\d+(,\\d+){5}";

    public static void validateMoney(String money) {
        checkNull(money);
        checkMoneyForm(money);
    }

    private static void checkNull(String money) {
        if (money == null || money.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요");
        }
    }

    private static void checkMoneyForm(String money) {
        if (!money.matches(MONEY_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000의 배수인 양수를 입력해야 합니다");
        }
    }

    public static void validateWinningNumbers(String winningNumbers) {
        checkNull(winningNumbers);
        checkWinningNumbersForm(winningNumbers);
        checkDuplication(winningNumbers);
        checkNumberRange(winningNumbers);
    }

    private static void checkWinningNumbersForm(String winningNumbers) {
        if (!winningNumbers.matches(WINNING_NUMBERS_REGEX)) {
            throw new IllegalArgumentException(
                "[ERROR] 로또 번호는 쉼표로 구분된 6자리 숫자여야 합니다.");
        }
    }

    private static void checkDuplication(String winningNumbers) {
        HashSet<String> hashSet = new HashSet<>();
        boolean isDuplicated = Arrays.stream(winningNumbers.split(","))
            .anyMatch(num -> !hashSet.add(num));
        if (isDuplicated) {
            throw new IllegalArgumentException("[ERROR] 중복된 당첨 번호를 입력하셨습니다.");
        }
    }

    private static void checkNumberRange(String winningNumbers) {
        boolean rangeResult = Arrays.stream(winningNumbers.split(","))
            .anyMatch(num -> Integer.parseInt(num) < 1 || Integer.parseInt(num) > 45);
        if (rangeResult) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이여야 합니다.");
        }
    }
}
