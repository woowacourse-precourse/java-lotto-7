package lotto.util;

import java.util.List;

public class InputValidator {

    private static final String PURCHASE_AMOUNT_SUFFIX = " (금액: ";
    private static final String PURCHASE_AMOUNT_SUFFIX_END = ")";
    private static final int LOTTO_WINNING_SIZE = 6;

    public void validatePurchaseAmount(int purchaseAmount, int lottoPrice) {
        if (purchaseAmount % lottoPrice != 0) {
            throw new IllegalArgumentException(
                    ErrorMessage.PURCHASE_AMOUNT_NOT_DIVISION_ERROR.getMessage()
                            + PURCHASE_AMOUNT_SUFFIX + purchaseAmount
                            + PURCHASE_AMOUNT_SUFFIX_END);
        }
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.isEmpty() || winningNumbers.size() < LOTTO_WINNING_SIZE || winningNumbers.size() > LOTTO_WINNING_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_SIZE_ERROR.getMessage() + "입력한 당첨 개수: " + winningNumbers.size());
        }

        if (winningNumbers.stream().distinct().count() != winningNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_DUPLICATE_ERROR.getMessage());
        }
    }

}
