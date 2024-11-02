package lotto.util;

import java.util.List;

public class InputValidator {

    private static final String PURCHASE_AMOUNT_PREFIX = "금액: ";
    private static final int REQUIRED_WINNING_NUMBERS_COUNT  = 6;

    public void validatePurchaseAmount(int purchaseAmount, int lottoPrice) {
        if (purchaseAmount % lottoPrice != 0) {
            throw new IllegalArgumentException(
                    ErrorMessage.PURCHASE_AMOUNT_NOT_DIVISION_ERROR.getMessage()
                            + PURCHASE_AMOUNT_PREFIX
                            + purchaseAmount);
        }
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbersSize(winningNumbers);
        validateNoDuplicateWinningNumbers(winningNumbers);
        winningNumbers.forEach(InputValidator::validateLottoRange);
    }

    public void validateBonusNumber(int bonusNumber) {
        validateLottoRange(bonusNumber);
    }

    private static void validateNoDuplicateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.stream().distinct().count() != winningNumbers.size()) {
            throw new IllegalArgumentException(
                    ErrorMessage.WINNING_NUMBERS_DUPLICATE_ERROR.getMessage());
        }
    }

    private static void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != REQUIRED_WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException(
                    ErrorMessage.WINNING_NUMBERS_SIZE_ERROR.getMessage()
                            + "입력한 당첨 개수: " + winningNumbers.size());
        }
    }

    private static void validateLottoRange(int number) {
        if (!(number >= 1 && number <= 45)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE_ERROR.getMessage());
        }
    }

}
