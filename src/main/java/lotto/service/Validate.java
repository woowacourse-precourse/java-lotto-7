package lotto.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.LottoConstants.SEPARATOR;
import static lotto.constants.LottoConstants.MIN_NUMBER;
import static lotto.constants.LottoConstants.MAX_NUMBER;
import static lotto.constants.LottoConstants.NUMBER_COUNT;
import static lotto.constants.LottoConstants.PURCHASE_AMOUNT_UNIT;
import static lotto.constants.LottoConstants.ZERO;
import static lotto.constants.ExceptionMessage.INVALID_PURCHASE_AMOUNT;
import static lotto.constants.ExceptionMessage.INVALID_PURCHASE_AMOUNT_UNIT;
import static lotto.constants.ExceptionMessage.NOT_A_NUMBER;
import static lotto.constants.ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.constants.ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.constants.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;

public class Validate {
    // 구매 금액
    public int validatePurchaseAmount (String purchaseAmountInput) {
        int purchaseAmount = validateInputIsDigit(purchaseAmountInput);
        checkPurchaseAmountRange(purchaseAmount);
        checkPurchaseAmountUnit(purchaseAmount);
        return purchaseAmount / PURCHASE_AMOUNT_UNIT;
    }
    private void checkPurchaseAmountRange (int purchaseAmount) {
        if (purchaseAmount < PURCHASE_AMOUNT_UNIT) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT);
        }
    }
    private void checkPurchaseAmountUnit (int purchaseAmount) {
        if (purchaseAmount % PURCHASE_AMOUNT_UNIT != ZERO) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_UNIT);
        }
    }

    // 당첨 번호
    public List<Integer> validateWinningNumbers (String winningNumbersInput) {
        List<Integer> winningNumbers = new ArrayList<>();
        checkWinningNumbersIsDigit(winningNumbers, winningNumbersInput);
        checkWinningNumbersSize(winningNumbers);
        checkWinningNumbersRange(winningNumbers);
        validateDuplicateWinningNumbers(winningNumbers);
        return winningNumbers;
    }
    private void checkWinningNumbersIsDigit (List<Integer> winningNumbers, String winningNumbersInput) {
        for (String winningNumber : winningNumbersInput.split(SEPARATOR)) {
            winningNumbers.add(validateInputIsDigit(winningNumber));
        }
    }
    private void checkWinningNumbersSize (List<Integer> winningNumbers) {
        if (winningNumbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT);
        }
    }
    private void checkWinningNumbersRange (List<Integer> winningNumbers) {
        for (int winningNumber : winningNumbers) {
            validateNumberRange(winningNumber);
        }
    }
    private void validateDuplicateWinningNumbers (List<Integer> winningNumbersInput) {
        Set<Integer> winningNumbers = new HashSet<>(winningNumbersInput);
        if (winningNumbers.size() != winningNumbersInput.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER);
        }
    }

    // 보너스 번호
    public int validateBonusNumber (String bonusNumberInput, List<Integer> winningNumbers) {
        int bonusNumber = validateInputIsDigit(bonusNumberInput);
        validateNumberRange(bonusNumber);
        validateDuplicateBonusNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }
    private void validateDuplicateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        for (int winningNumber : winningNumbers) {
            if (bonusNumber == winningNumber) {
                throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER);
            }
        }
    }

    // 공통 사용 메서드
    private int validateInputIsDigit (String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER);
        }
    }
    private void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE);
        }
    }
}
