package lotto;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class Validator {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static void validatePurchaseAmount(String input) {
        int amount = parseInt(input, "[ERROR] 구입 금액은 숫자여야 합니다.");
        validatePositiveAmount(amount);
        validateDivisibleByLottoPrice(amount);
    }

    private static int parseInt(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void validatePositiveAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
        }
    }

    private static void validateDivisibleByLottoPrice(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public static void validateWinningNumbers(List<String> inputs) {
        if (inputs.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        List<Integer> numbers = new ArrayList<>();
        for (String input : inputs) {
            int number = parseInt(input, "[ERROR] 당첨 번호는 숫자여야 합니다.");
            validateNumberRange(number);
            numbers.add(number);
        }
        validateNoDuplicateNumbers(numbers);
    }

    private static void validateNoDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    public static void validateBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber = parseInt(input, "[ERROR] 보너스 번호는 숫자여야 합니다.");
        validateNumberRange(bonusNumber);
        validateBonusNotInWinningNumbers(bonusNumber, winningNumbers);
    }

    private static void validateBonusNotInWinningNumbers(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private static void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}