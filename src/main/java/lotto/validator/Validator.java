package lotto.validator;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.util.Util;
import lotto.view.OutputView;
import lotto.view.message.ErrorMessage;

public class Validator {

    private final OutputView outputView = new OutputView();

    public boolean validateMoneyAmount(String input) {
        try {
            isNotNull(input);
            isNumber(input);
            int number = Integer.parseInt(input);
            isOverMinimumPurchaseAmount(number);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean validateLotto(String input) {
        try {
            isNotNull(input);
            Arrays.stream(input.split(","))
                    .forEach(Validator::isNumber);
            List<Integer> lotto = Util.stringToInt(input);
            lotto.forEach(Validator::isInLottoNumberRange);
            isAllUnique(lotto);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return false;
        }
        return true;
    }

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
