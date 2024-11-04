package lotto.validator;

import static lotto.constant.Constants.LOTTO_PRICE;

import java.util.HashSet;
import java.util.List;
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
        if (purchaseAmount % LOTTO_PRICE != 0 || purchaseAmount < LOTTO_PRICE) {
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
    public static void isLottoNumbersRangeIn(int winningNumber) {
        if (winningNumber < 1 || winningNumber > 45) {
           throw new InputException(ErrorMessage.UNAVAILABLE_LOTTO_NUMBERS.getMessage());
        }
    }

    /**
     * 당첨번호 중복 검사
     */
    public static void hasDuplicateNumbers(List<Integer> winningNumbers) {
        HashSet<Integer> numberSet = new HashSet<>();
        for (Integer number : winningNumbers) {
            if (!numberSet.add(number)) {
                throw new InputException(ErrorMessage.HAS_DUPLICATED_NUMBER_LOTTO.getMessage());
            }
        }
    }

    /**
     * 보너스 번호 blank 여부 체크
     */
    public static void isBonusNumberBlank(String bonusNumber) {
        if(bonusNumber.isBlank()) {
            throw new InputException(ErrorMessage.IS_BLANK_BONUS_NUMBER.getMessage());
        }
    }

    /**
     * 당번번호와 보너스 번호의 중복 검사
     */
    public static void hasDuplicateBonusNumber(List<Integer> winningNumberList, int bonusNumber) {
        if(winningNumberList.contains(bonusNumber)) {
            throw new InputException(ErrorMessage.HAS_DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }
}
