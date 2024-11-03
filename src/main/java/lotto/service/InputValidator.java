package lotto.service;

import lotto.domain.Lotto;

public class InputValidator {
    private static final String ERROR_NOT_POSITIVE_NUMBER = "[ERROR] 입력 값은 양수여야 합니다.";
    private static final String ERROR_NUMBER_OUT_OF_TYPE_RANGE = "[ERROR] 숫자가 범위를 초과합니다.";
    private static final String ERROR_NOT_DIVISIBLE_BY_LOTTO_PRICE = "[ERROR] 입력 값이 로또 가격으로 나누어지지 않습니다.";
    private static final String ERROR_NOT_POSITIVE_NUMBER_OR_COMMA = "[ERROR] 당첨 번호는 숫자와 쉼표만 포함해야 합니다.";
    private static final String ERROR_BONUS_NUMBER_OUT_OF_LOTTO_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨번호와 중복되지 않는 숫자여야 합니다.";

    private static final String POSITIVE_NUMBERS_SEPARATED_BY_COMMA_REGEX = "^([1-9]\\d*)(,[1-9]\\d*)*$";
    private static final String POSITIVE_NUMBER_REGEX = "^[1-9]\\d*$";

    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    public void validateTotalPurchaseAmount(String totalPurchaseAmount) {
        validateIsPositiveNumber(totalPurchaseAmount);
        validateIsNumberInTypeRange(totalPurchaseAmount);
        validateDivisibleByLottoPrice(totalPurchaseAmount);
    }

    public void validateWinningNumbers(String winningNumbers) {
        validatePositiveNumbersSeparatedByComma(winningNumbers);

        for (String number : winningNumbers.split(",")) {
            validateIsNumberInTypeRange(number);
        }
    }

    public void validateBonusNumber(String bonusNumber, Lotto winningNumbers) {
        validateIsPositiveNumber(bonusNumber);
        validateIsNumberInTypeRange(bonusNumber);
        validateBonusNumberInLottoRange(bonusNumber);
        validateBonusNumberDuplicate(bonusNumber, winningNumbers);
    }

    private void validateIsPositiveNumber(String numbers) {
        if (!numbers.matches(POSITIVE_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ERROR_NOT_POSITIVE_NUMBER);
        }
    }

    private void validateIsNumberInTypeRange(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NUMBER_OUT_OF_TYPE_RANGE);
        }
    }

    private void validateDivisibleByLottoPrice(String totalPurchaseAmount) {
        int parsedPurchaseAmount = Integer.parseInt(totalPurchaseAmount);
        if (parsedPurchaseAmount % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_NOT_DIVISIBLE_BY_LOTTO_PRICE);
        }
    }

    private static void validatePositiveNumbersSeparatedByComma(String winningNumbers) {
        if (!winningNumbers.matches(POSITIVE_NUMBERS_SEPARATED_BY_COMMA_REGEX)) {
            throw new IllegalArgumentException(ERROR_NOT_POSITIVE_NUMBER_OR_COMMA);
        }
    }

    private void validateBonusNumberInLottoRange(String bonusNumber) {
        int parsedBonusNumber = Integer.parseInt(bonusNumber);
        if (parsedBonusNumber < LOTTO_NUMBER_MIN || parsedBonusNumber > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_OUT_OF_LOTTO_RANGE);
        }
    }

    private void validateBonusNumberDuplicate(String bonusNumber, Lotto winningNumbers) {
        int parsedBonusNumber = Integer.parseInt(bonusNumber);
        if (winningNumbers.containsNumber(parsedBonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_DUPLICATE);
        }
    }
}
