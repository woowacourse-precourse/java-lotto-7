package lotto.handler.purchase.validation;

import lotto.handler.purchase.dto.PurchaseAmountDTO;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;

public interface PurchaseInputValidator {
    void validate(HandlerToken handlerToken);

    default String getPurchaseAmountToString(HandlerToken handlerToken) {
        PurchaseAmountDTO purchaseAmountDTO = handlerToken.getContent(TokenType.PURCHASE_AMOUNT_DTO,
                PurchaseAmountDTO.class);
        return purchaseAmountDTO.getPurchaseAmount();
    }

    default int getPurchaseAmountToInteger(HandlerToken handlerToken) {
        return Integer.parseInt(getPurchaseAmountToString(handlerToken));
    }
}
