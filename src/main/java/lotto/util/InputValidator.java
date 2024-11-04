package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
    private static final int LOTTO_PRICE_UNIT = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;

    // 구입 금액 검증
    public static void validatePurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input.trim());
            if (amount <= 0) {
                throw new IllegalArgumentException("[ERROR] 양수를 입력해주세요.");
            }
            if (amount % LOTTO_PRICE_UNIT != 0) {
                throw new IllegalArgumentException("[ERROR] 로또 구입은 1,000원 단위만 가능합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하여야 합니다.");
        }
    }

    // 당첨 번호 검증
    public static List<Integer> validateWinningNumbers(String input) {
        try {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            if (numbers.size() != LOTTO_NUMBER_COUNT) {
                throw new IllegalArgumentException("[ERROR] 로또 숫자 개수는 6개 여야 합니다.");
            }

            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    // 보너스 번호 검증
    public static int validateBonusNumber(String input) {
        try {
            int bonusNumber = Integer.parseInt(input.trim());
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다. 다시 입력해주세요.");
        }
    }
}