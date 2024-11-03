package lotto.handler.purchase.validation;

import java.util.List;
import lotto.display.DisplayFormat;
import lotto.handler.LottoHandler;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;

public class PurchaseInputValidationHandler extends LottoHandler {
    private final PurchaseInputValidatorFactory purchaseInputValidatorFactory;

    public PurchaseInputValidationHandler(PurchaseInputValidatorFactory purchaseInputValidatorFactory) {
        this.purchaseInputValidatorFactory = purchaseInputValidatorFactory;
    }

    @Override
    protected HandlerToken process(HandlerToken handlerToken) {
        try {
            validateAll(getPurchaseInputValidators(), handlerToken);
        } catch (IllegalArgumentException e) {
            handlerToken.addContent(TokenType.INVALID_INPUT_ERROR, null);
            System.out.println(DisplayFormat.ERROR.displayWithOneValue(e.getMessage()));
        }

        checkInvalidInputAndRevert(handlerToken);
        return handlerToken;
    }

    private void validateAll(List<PurchaseInputValidator> purchaseInputValidators, HandlerToken handlerToken) {
        for (PurchaseInputValidator purchaseInputValidator : purchaseInputValidators) {
            purchaseInputValidator.validate(handlerToken);
        }
    }

    private List<PurchaseInputValidator> getPurchaseInputValidators() {
        return purchaseInputValidatorFactory.create();
    }

    private void checkInvalidInputAndRevert(HandlerToken handlerToken) {
        if (handlerToken.hasInvalidInput()) {
            removeInputAndError(handlerToken);
            prevHandler.handle(handlerToken);
        }
    }

    private void removeInputAndError(HandlerToken handlerToken) {
        handlerToken.removeContent(TokenType.PURCHASE_AMOUNT_DTO);
        handlerToken.removeContent(TokenType.INVALID_INPUT_ERROR);
    }

}
