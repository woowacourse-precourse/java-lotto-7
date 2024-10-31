package lotto.service;

import static lotto.constant.Constant.THOUSAND;

import lotto.constant.ExceptionMessage;
import lotto.parse.InputParser;
import lotto.validation.InputValidator;

public class LottoService {

    private final InputValidator inputValidator;
    private final InputParser inputParser;

    public LottoService() {
        this.inputValidator = new InputValidator();
        this.inputParser = new InputParser();
    }

    public void processPurchaseAmount(String purchaseAmountInput) {
        inputValidator.validateInputIsEmpty(purchaseAmountInput);
        Long purchaseAmount = inputParser.parsePurchaseAmount(purchaseAmountInput);
        validateNonThousandDivisibility(purchaseAmount);
    }

    public void validateNonThousandDivisibility(Long number) {
        if (number % THOUSAND != 0) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_THOUSAND_DIVISIBILITY);
        }
    }
}
