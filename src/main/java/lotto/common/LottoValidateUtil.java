package lotto.common;

import java.util.List;

public final class LottoValidateUtil {
    private LottoValidateUtil() {
    }

    public static void validatePurchaseAmount(int amount) {
        if (amount > LottoConstants.PURCHASE_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 100,000원까지만 구매가 가능합니다.");
        }
        if (amount < LottoConstants.PRICE) {
            throw new IllegalArgumentException("[ERROR] 1,000원 이상의 금액을 입력하셔야 합니다.");
        }
        if (amount % LottoConstants.PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1,000원 단위만 가능합니다.");
        }
    }

    public static void validateLottoNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        boolean isAllInRange = numbers.stream()
                .allMatch(number -> number >= LottoConstants.MIN_NUMBER && number <= LottoConstants.MAX_NUMBER);

        if (!isAllInRange) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateNumberExists(List<Integer> numbers, Integer number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
        }
    }
}
