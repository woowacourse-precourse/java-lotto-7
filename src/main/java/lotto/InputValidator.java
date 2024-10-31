package lotto;

import static lotto.ErrorCode.CONTIGIOUS_COMMA;
import static lotto.ErrorCode.DUPLICATE_WINNIG_NUMBER;
import static lotto.ErrorCode.INVALID_NUMBER_RANGE;
import static lotto.ErrorCode.INVALID_PURCHASE_AMOUNT;
import static lotto.ErrorCode.INVALID_WINNIG_NUMBER_COUNT;

import java.util.List;

public class InputValidator {

    private static final int TICKET_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int VALID_LOTTO_NUMBER_COUNT = 6;
    private static final String COMMAS = ",,";

    //구매 금액 검증
    public static void validatePurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    //당첨 번호 검증
    public static void validateInputWinnigNumber(final String inputWinnigNumber) {
        if (inputWinnigNumber.contains(COMMAS)) {
            throw new IllegalArgumentException(CONTIGIOUS_COMMA.getMessage());
        }
    }

    public static void validateWinningNumberRange(final List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber < MIN_LOTTO_NUMBER || winningNumber > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
            }
        }
    }

    public static void validateWinningNumberDuplicate(final List<Integer> winningNumbers) {
        if (winningNumbers.stream().distinct().count() != winningNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_WINNIG_NUMBER.getMessage());
        }
    }

    public static void validateWinningNumberCount(final List<Integer> winningNumbers) {
        if (winningNumbers.size() != VALID_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_WINNIG_NUMBER_COUNT.getMessage());
        }
    }
}
