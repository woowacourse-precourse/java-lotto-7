package lotto.service;

import lotto.domain.Lotto;

public class InputValidator {
    private static final String ERROR_NOT_POSITIVE_NUMBER = "[ERROR] 입력 값은 양수여야 합니다.";
    private static final String ERROR_NOT_DIVISIBLE_BY_LOTTO_PRICE = "[ERROR] 입력 값이 로또 가격으로 나누어지지 않습니다.";
    private static final String ERROR_NUMBER_OUT_OF_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨번호와 중복되지 않는 숫자여야 합니다.";
    private static final String ERROR_WINNING_NUMBER = "[ERROR] 당첨 번호는 숫자와 쉼표만 포함해야 합니다.";

    private static final String POSITIVE_NUMBER_SEPARATED_BY_COMMA = "^([1-9]\\d*)(,[1-9]\\d*)*$";
    private static final String POSITIVE_NUMBER_REGEX = "^[1-9]\\d*$";

    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    public void validatePurchaseAmount(String input) {
        validatePositiveNumber(input);
        validateDivisibleByLottoPrice(input);
    }

    public void validateWinningNumber(String input) {
        if (!input.matches(POSITIVE_NUMBER_SEPARATED_BY_COMMA)) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBER);
        }
    }

    public void validateBonusNumber(String input, Lotto winningLotto) {
        validatePositiveNumber(input);
        validateNumberInRange(input);
        validateNoDuplicateWithWinningNumbers(winningLotto, input);
    }

    private void validatePositiveNumber(String input) {
        if (!input.matches(POSITIVE_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ERROR_NOT_POSITIVE_NUMBER);
        }
    }

    private void validateDivisibleByLottoPrice(String input) {
        int purchaseAmount = Integer.parseInt(input.trim());
        if (purchaseAmount % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_NOT_DIVISIBLE_BY_LOTTO_PRICE);
        }
    }

    private void validateNumberInRange(String input) {
        int bonusNumber = Integer.parseInt(input.trim());
        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ERROR_NUMBER_OUT_OF_RANGE);
        }
    }

    private void validateNoDuplicateWithWinningNumbers(Lotto winningLotto, String input) {
        int bonusNumber = Integer.parseInt(input.trim());
        if (winningLotto.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_DUPLICATE);
        }
    }
}
