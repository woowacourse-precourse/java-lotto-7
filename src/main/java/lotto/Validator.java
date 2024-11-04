package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int LOTTO_PRICE = 1000;

    public static void validatePurchaseAmount(String input) {
        validateNumeric(input);
        int amount = Integer.parseInt(input);
        validateDivisibleByLottoPrice(amount);
        validatePositiveAmount(amount);
    }
    private static void validateNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 함");
        }
    }

    private static void validateDivisibleByLottoPrice(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 천원 단위로 나눠 떨어져야 함");
        }
    }

    private static void validatePositiveAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 천원 이상이어야 함");
        }
    }

    public static void validateWinningNumbers(List<String> inputs) {
        if (inputs.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 함.");
        }
        for (String input : inputs) {
            validateNumber(input);
        }
        validateNoDuplicateNumbers(inputs);
    }

    public static void validateBonusNumber(String input, List<Integer> winningNumbers) {
        validateWinningNumeric(input);
        int bonusNumber = Integer.parseInt(input);
        validateNumberRange(bonusNumber);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없음");
        }
    }

    private static void validateNoDuplicateNumbers(List<String> inputs) {
        Set<String> uniqueNumbers = new HashSet<>(inputs);
        if (uniqueNumbers.size() != inputs.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없음.");
        }
    }

    private static void validateNumber(String input) {
        validateWinningNumeric(input);
        int number = Integer.parseInt(input);
        validateNumberRange(number);
    }

    private static void validateWinningNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 함");
        }
    }

    private static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 함");
        }
    }

}
