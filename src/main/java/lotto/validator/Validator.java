package lotto.validator;

import java.util.List;
import lotto.view.message.ErrorMessage;

public class Validator {

    public boolean isNotNull(String input) {
        if(input == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL.name());
        }
        return true;
    }

    public boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_INTEGER_NOT_STRING.getMessage());
        }
        return true;
    }

    public boolean isPositive(Integer input) {
        if (input <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_POSITIVE_NUMBER.getMessage());
        }
        return true;
    }

    public boolean isOverMinimumPurchaseAmount(Integer input) {
        if (input <= 999) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_AMOUNT.getMessage());
        }
        return true;
    }

    public boolean isInLottoNumberRange(Integer input) {
        if (input <= 0 || input > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_RANGE.getMessage());
        }
        return true;
    }

    public boolean isUnique(List<Integer> numbers) {
        if (numbers.stream().distinct().toList().size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_UNIQUE_NUMBER.getMessage());
        }
        return true;
    }
}
