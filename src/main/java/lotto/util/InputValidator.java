package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
    private static final int LOTTO_PRICE_UNIT = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;

    // 구입 금액 검증
    public static void validatePurchaseAmount(String input) {
        int amount = parseAmount(input);
        validateAmountPositive(amount);
        validateAmountUnit(amount);
    }

    private static int parseAmount(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하여야 합니다.");
        }
    }

    private static void validateAmountPositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해주세요.");
        }
    }

    private static void validateAmountUnit(int amount) {
        if (amount % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입은 1,000원 단위만 가능합니다.");
        }
    }

    // 당첨 번호 검증
    public static List<Integer> validateWinningNumbers(String input) {
        List<Integer> numbers = parseWinningNumbers(input);
        validateWinningNumbersCount(numbers);
        return numbers;
    }

    private static List<Integer> parseWinningNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private static void validateWinningNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자 개수는 6개 여야 합니다.");
        }
    }

    // 보너스 번호 검증
    public static int validateBonusNumber(String input) {
        return parseBonusNumber(input);
    }

    private static int parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다. 다시 입력해주세요.");
        }
    }
}