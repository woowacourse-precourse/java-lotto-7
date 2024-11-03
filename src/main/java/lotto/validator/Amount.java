package lotto.validator;

import lotto.exception.RetryInputException;
import lotto.status.ErrorMessages;
import lotto.status.LottoConstants;
import lotto.util.InputUtils;
import lotto.view.Input;

public class Amount extends Validator implements LottoConstants {
    private int amount;


    public int getAmount() {
        return amount;
    }

    public void processSetAmount() {
        String request = InputUtils.retryRequest(Input.request(Input.PURCHASE_AMOUNT_PROMPT), this::validate);

        this.amount = Integer.parseInt(request);
    }

    @Override
    protected Boolean validate(String request) {
        return nonEmpty(Input.PURCHASE_AMOUNT_PROMPT, request) &&
               isNumeric(Input.PURCHASE_AMOUNT_PROMPT, request) &&
               isPositiveNumeric(Input.PURCHASE_AMOUNT_PROMPT, request) &&
               isThousandUnit(request) &&
               isAmountUnderLimit(request);
    }

    ;

    private Boolean isThousandUnit(String input) {
        if (Integer.parseInt(input) % LOTTO_UNIT_PRICE == 0) {
            return true;
        }

        throw new RetryInputException(Input.PURCHASE_AMOUNT_PROMPT, ErrorMessages.INVALID_FORMAT.getMessage());
    }

    private Boolean isAmountUnderLimit(String input) {
        if (Integer.parseInt(input) <= MAX_LOTTO_PURCHASE_AMOUNT) {
            return true;
        }

        throw new RetryInputException(Input.PURCHASE_AMOUNT_PROMPT, ErrorMessages.MAX_PURCHASE_LIMIT.getMessage());
    }
}
