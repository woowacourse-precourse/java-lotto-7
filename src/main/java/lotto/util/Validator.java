package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    // 로또 번호의 개수 검사
    public static void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Config.ERROR_INVALID_LOTTO_NUMBER_COUNT);
        }
    }

    // 로또 번호의 범위 검사 (1부터 45 사이여야 함)
    public static void validateLottoNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(Config.ERROR_OUT_OF_RANGE_NUMBER);
            }
        }
    }

    // 중복 검사
    public static void validateLottoNumberDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(Config.ERROR_DUPLICATE_NUMBER);
        }
    }

    // 구입 금액의 1,000원 단위 여부 검사
    public static void validatePurchaseAmount(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(Config.ERROR_INVALID_TICKET_COUNT);
        }
    }

    // 숫자 형식 확인
    public static int validateAndParseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Config.ERROR_INVALID_MONEY_FORMAT);
        }
    }

    // 보너스 번호가 당첨 번호와 중복되는지 검사
    public static void validateBonusNumberDuplication(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Config.ERROR_BONUS_NUMBER_DUPLICATE);
        }
    }
}
