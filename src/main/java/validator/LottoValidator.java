package validator;

import java.util.List;

public class LottoValidator {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int PURCHASE_UNIT = 1000;

    private static final String ERROR_MESSAGE_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String ERROR_MESSAGE_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_DUPLICATE = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
    private static final String ERROR_MESSAGE_PURCHASE_UNIT = "[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다.";
    private static final String ERROR_MESSAGE_BONUS_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";
    private static final String ERROR_MESSAGE_BONUS_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_SIZE);
        }
        if (numbers.stream().anyMatch(num -> num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_RANGE);
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE);
        }
    }

    public static void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PURCHASE_UNIT);
        }
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BONUS_RANGE);
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BONUS_DUPLICATE);
        }
    }
}