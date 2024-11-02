package lotto.validator;

import lotto.exception.RetryInputException;
import lotto.status.ErrorMessages;

import java.util.Set;


public class InputValidator {
    private final int amount;
    private int bonus;
    private Set<Integer> winningNumbers;
    private Set<String> duplicateCheck;

    public InputValidator(AmountValidator amountValidator) {
        this.amount = amountValidator.processSetAmount();

    }


    public Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonus() {
        return bonus;
    }


    private void isRegexCheck(String viewMessage, String input) {
        if (!input.matches("^,*(-?\\d+,*)*$")) {
            throw new RetryInputException(viewMessage, ErrorMessages.INVALID_FORMAT.getMessage());
        }
    }


    private Boolean isLottoNumberRange(String viewMessage, String request) {
        return true;
    }

}
