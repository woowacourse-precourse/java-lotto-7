package lotto;

import java.util.HashSet;
import java.util.List;

public class InputValidate {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final String ERROR_EMPTY_PURCHASE_AMOUNT = "[ERROR] 구입 금액은 비어 있을 수 없습니다.";
    private static final String ERROR_NEGATIVE_OR_ZERO_PURCHASE_AMOUNT = "[ERROR] 구입 금액은 0보다 큰 양수여야 합니다.";
    private static final String ERROR_NOT_DIVISIBLE_BY_LOTTO_PRICE = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";
    private static final String ERROR_EMPTY_WINNING_NUMBERS = "[ERROR] 당첨 번호는 비어 있을 수 없습니다.";
    private static final String ERROR_INVALID_WINNING_NUMBER_RANGE = "[ERROR] 당첨 번호는 1에서 45 사이의 숫자여야 합니다.";
    private static final String ERROR_DUPLICATE_WINNING_NUMBER = "[ERROR] 당첨 번호에는 중복된 숫자가 없어야 합니다.";
    private static final String ERROR_EMPTY_BONUS_NUMBER = "[ERROR] 보너스 번호는 비어 있을 수 없습니다.";
    private static final String ERROR_INVALID_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.";
    private static final String ERROR_DUPLICATE_BONUS_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    // 구매 금액 검증
    public void validatePurchaseAmount(Integer amount) {
        validatePurchaseAmountNotEmpty(amount);
        validatePurchaseAmountPositive(amount);
        validatePurchaseAmountDivisibleByLottoPrice(amount);
    }

    private void validatePurchaseAmountNotEmpty(Integer amount) {
        if (amount == null) {
            throw new IllegalArgumentException(ERROR_EMPTY_PURCHASE_AMOUNT);
        }
    }

    private void validatePurchaseAmountPositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_OR_ZERO_PURCHASE_AMOUNT);
        }
    }

    private void validatePurchaseAmountDivisibleByLottoPrice(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_NOT_DIVISIBLE_BY_LOTTO_PRICE);
        }
    }

    // 당첨 번호 검증
    public void validateWinningNumbers(List<Integer> numbers) {
        validateNotEmpty(numbers, ERROR_EMPTY_WINNING_NUMBERS);
        validateNumberRange(numbers);
        validateNoDuplicates(numbers);
    }

    private void validateNotEmpty(List<Integer> numbers, String errorMessage) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < MIN_NUMBER || num > MAX_NUMBER)) {
            throw new IllegalArgumentException(ERROR_INVALID_WINNING_NUMBER_RANGE);
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_WINNING_NUMBER);
        }
    }

    // 보너스 번호 검증
    public void validateBonusNumber(Integer bonusNumber, List<Integer> winningNumbers) {
        validateBonusNumberNotEmpty(bonusNumber);
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplication(bonusNumber, winningNumbers);
    }

    private void validateBonusNumberNotEmpty(Integer bonusNumber) {
        if (bonusNumber == null) {
            throw new IllegalArgumentException(ERROR_EMPTY_BONUS_NUMBER);
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_INVALID_BONUS_NUMBER_RANGE);
        }
    }

    private void validateBonusNumberDuplication(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_BONUS_NUMBER);
        }
    }
}
