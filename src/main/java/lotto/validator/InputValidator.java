package lotto.validator;

import static lotto.model.Constants.MULTIPLES_OF_LOTTO_PRICE;

import lotto.exception.InputException;
import lotto.message.ErrorMessage;

public class InputValidator {

    /**
     * 구매 금액 blank 여부 체크
     */
    public static void isPurchaseAmountBlank(String input) {
        if (input.isBlank()) {
            throw new InputException(ErrorMessage.IS_BLANK_PURCHASE_AMOUNT.getMessage());
        }
    }

    /**
     * 구매 금액 1000배수 체크
     */
    public static void isMultiplesOfThousand(int purchaseAmount) {
        if (purchaseAmount % MULTIPLES_OF_LOTTO_PRICE != 0 || purchaseAmount < 1000) {
            throw new InputException(ErrorMessage.UNAVAILABLE_PURCHASE_AMOUNT.getMessage());
        }
    }

    /**
     * 당첨번호 blank 여부 체크
     */
    public static void isWinningNumbersBlank(String winningNumbers) {
        if (winningNumbers.isBlank()) {
            throw new InputException(ErrorMessage.IS_BLANK_WINNING_LOTTO_NUMBERS.getMessage());
        }
    }

    /**
     * 당첨번호 유효한 범위 체크
     */
    public static void isWinningNumbersRangeIn(int winningNumber) {
        if (winningNumber < 1 || winningNumber > 45) {
           throw new InputException(ErrorMessage.UNAVAILABLE_WINNING_LOTTO_NUMBERS.getMessage());
        }
    }
}
