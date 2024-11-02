package lotto.validator;

import lotto.exception.RetryInputException;
import lotto.status.ErrorMessages;
import lotto.util.InputUtils;
import lotto.util.RegexUtils;
import lotto.view.Input;

import java.util.Set;


public class InputValidator {
    private int amount;
    private Set<Integer> winningNumbers;
    private int bonusNumber;

    public InputValidator() {
        this.amount = processSetAmount();

    }

    private int processSetAmount() {
        return Integer.parseInt(
                InputUtils.retryRequest(Input.request(Input.PURCHASE_AMOUNT_PROMPT),
                        request -> inputAmountValidation(Input.PURCHASE_AMOUNT_PROMPT, request)
                )
        );
    }

    private Boolean inputAmountValidation(String viewMessage, String request) {

        if (this.isEmpty(viewMessage, request)) {
            return false;
        }

        if (!isPositiveNumber(viewMessage, request)) {
            return false;
        }

        return isThousandUnit(viewMessage, request);
    }

    private Boolean isEmpty(String viewMessage, String value) {
        if (value.isEmpty()) {
            throw new RetryInputException(viewMessage, value);
        }
        return true;
    }


    private Boolean isPositiveNumber(String viewMessage, String value) {
        if (RegexUtils.isPositiveNumeric(value)) {
            return true;
        }
        throw new RetryInputException(viewMessage, ErrorMessages.NON_POSITIVE_NUMERIC.getMessage());
    }

    private Boolean isThousandUnit(String veiwMessage, String value) {
        if (Integer.parseInt(value) % 1000 == 0) {
            return true;
        }

        throw new RetryInputException(veiwMessage, ErrorMessages.INVALID_FORMAT.getMessage());
    }

}
