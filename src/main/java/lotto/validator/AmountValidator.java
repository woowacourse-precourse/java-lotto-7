package lotto.validator;

import lotto.exception.RetryInputException;
import lotto.status.ErrorMessages;
import lotto.status.LottoConstants;
import lotto.util.InputUtils;
import lotto.view.Input;

import static lotto.validator.CommonValidator.*;

public class AmountValidator {

    public int processSetAmount() {
        return Integer.parseInt(
                InputUtils.retryRequest(Input.request(Input.PURCHASE_AMOUNT_PROMPT),
                        request -> inputAmountValidation(request)
                )
        );
    }

    private Boolean inputAmountValidation(String request) {
        String viewMessage = Input.PURCHASE_AMOUNT_PROMPT;

        if (!nonEmpty(viewMessage, request)) {
            return false;
        }

        if (!isNumeric(viewMessage, request)) {
            return false;
        }

        if (!isPositiveNumber(viewMessage, request)) {
            return false;
        }

        if (!isThousandUnit(viewMessage, request)) {
            return false;
        }

        return isPurchaseAmountExceeded(viewMessage, request);
    }

    private Boolean isThousandUnit(String viewMessage, String input) {
        if (Integer.parseInt(input) % LottoConstants.LOTTO_UNIT_PRICE == 0) {
            return true;
        }

        throw new RetryInputException(viewMessage, ErrorMessages.INVALID_FORMAT.getMessage());
    }

    private Boolean isPurchaseAmountExceeded(String viewMessage, String input) {
        if (Integer.parseInt(input) > LottoConstants.MAX_LOTTO_PURCHASE_AMOUNT) {
            return true;
        }

        throw new RetryInputException(viewMessage, ErrorMessages.MAX_PURCHASE_LIMIT.getMessage());
    }
}
