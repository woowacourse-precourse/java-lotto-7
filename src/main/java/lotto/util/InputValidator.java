package lotto.util;

import static lotto.constants.LotteryConstant.LOTTO_NUMBERS_COUNT;
import static lotto.constants.LotteryConstant.MAX_NUMBER;
import static lotto.constants.LotteryConstant.MIN_NUMBER;
import static lotto.constants.LotteryConstant.TICKET_PRICE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputValidator {

    public static int parsePurchaseAmount(String input) {
        int amount = convertToInt(input);
        validateNonNegativeAmount(amount);
        validateThousandUnit(amount);
        return amount;
    }

    public static List<Integer> parseWinningNumbers(String input) {
        List<Integer> numbers = splitAndParseNumbers(input);
        validateNumberRange(numbers);
        validateWinningNumberCount(numbers);
        validateNoDuplicates(numbers);
        return numbers;
    }

    public static int parseBonusNumber(String input, List<Integer> winningNumbers) {
        int number = convertToInt(input);
        validateSingleNumberRange(number);
        validateNotInWinningNumbers(number, winningNumbers);
        return number;
    }

    private static int convertToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 숫자가 아닙니다.");
        }
    }

    private static List<Integer> splitAndParseNumbers(String input) {
        try {
            return List.of(input.split(","))
                    .stream()
                    .map(String::trim)
                    .map(InputValidator::convertToInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 모든 번호는 숫자여야 합니다.");
        }
    }

    private static void validateNonNegativeAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 음수일 수 없습니다.");
        }
    }

    private static void validateThousandUnit(int amount) {
        if (amount % TICKET_PRICE.getValue() != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private static void validateWinningNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_COUNT.getValue()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateSingleNumberRange(number);
        }
    }

    private static void validateSingleNumberRange(int number) {
        if (number < MIN_NUMBER.getValue() || number > MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException("[ERROR] 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않는 숫자여야 합니다.");
        }
    }

    private static void validateNotInWinningNumbers(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
