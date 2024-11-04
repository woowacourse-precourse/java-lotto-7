package validator;

import common.ErrorMessage;
import common.LottoConstants;
import java.util.List;

public class InputValidator {

    public static boolean validatePurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            if (amount < LottoConstants.TICKET_PRICE.getValue() || amount %
                    LottoConstants.TICKET_PRICE.getValue() != 0) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASE_AMOUNT_UNIT.getMessage());
            }
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    public static boolean validateWinnerLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }

        return true;
    }

    public static boolean validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_NUMBER_OUT_OF_RANGE.getMessage());
        }

        return true;
    }

}