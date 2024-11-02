package lotto.validator;

import lotto.exception.RetryInputException;
import lotto.status.ErrorMessages;
import lotto.status.LottoConstants;
import lotto.util.InputUtils;
import lotto.view.Input;

import static lotto.validator.InputValidator.*;

public class AmountValidator {

    public AmountValidator() {
    }

    public int processSetAmount() {
        return Integer.parseInt(
                InputUtils.retryRequest(Input.request(Input.PURCHASE_AMOUNT_PROMPT),
                        this::inputAmountValidation
                )
        );
    }

    private Boolean inputAmountValidation(String request) {

        return nonEmpty(Input.PURCHASE_AMOUNT_PROMPT, request) &&
               isNumeric(Input.PURCHASE_AMOUNT_PROMPT, request) &&
               isPositiveNumeric(Input.PURCHASE_AMOUNT_PROMPT, request) &&
               isThousandUnit(request) &&
               isAmountUnderLimit(request);
    }

    private Boolean isThousandUnit(String input) {
        if (Integer.parseInt(input) % LottoConstants.LOTTO_UNIT_PRICE == 0) {
            return true;
        }

        throw new RetryInputException(Input.PURCHASE_AMOUNT_PROMPT, ErrorMessages.INVALID_FORMAT.getMessage());
    }

    private Boolean isAmountUnderLimit(String input) {
        if (Integer.parseInt(input) <= LottoConstants.MAX_LOTTO_PURCHASE_AMOUNT) {
            return true;
        }

        throw new RetryInputException(Input.PURCHASE_AMOUNT_PROMPT, ErrorMessages.MAX_PURCHASE_LIMIT.getMessage());
    }
}
