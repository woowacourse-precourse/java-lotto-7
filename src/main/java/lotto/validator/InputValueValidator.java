package lotto.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.LottoConstants;

public class InputValueValidator {

    private static final int NUMBER_COUNT = LottoConstants.NUMBER_COUNT.getValue();
    private static final int MAX_NUMBER = LottoConstants.MAX_NUMBER.getValue();
    private static final int MIN_NUMBER = LottoConstants.MIN_NUMBER.getValue();

    public static int validateAndParseAmount(String input) {
        int amount = parseAmount(input);
        validatePositiveAmount(amount);
        validateAmount(amount);
        return amount;
    }

    private static int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자로 입력해야 합니다.");
        }
    }

    private static void validatePositiveAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 음수가 될 수 없습니다.");
        }
    }

    private static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public static List<Integer> validateAndParseWinningNumbers(String input) {
        List<Integer> numbers = parseWinningNumbers(input);
        validateWinningNumbers(numbers);
        return numbers;
    }

    private static List<Integer> parseWinningNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 숫자여야 합니다.");
        }
    }

    private static void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 " + NUMBER_COUNT + "개여야 합니다.");
        }
        if (new HashSet<>(numbers).size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
        }
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    public static int validateAndParseBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber = parseBonusNumber(input);
        validatePositiveNumber(bonusNumber);
        validateBonusNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static void validatePositiveNumber(int bonusNumber) {
        if (bonusNumber < 0) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 음수가 될 수 없습니다.");
        }
    }

    private static int parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.");
        }
    }

    private static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateNumberRange(bonusNumber);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    private static void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 번호는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + " 사이의 숫자여야 합니다.");
        }
    }
    
}
