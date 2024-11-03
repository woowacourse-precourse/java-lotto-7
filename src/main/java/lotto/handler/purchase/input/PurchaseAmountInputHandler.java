package lotto.handler.purchase.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.display.DisplayFormat;
import lotto.handler.LottoHandler;
import lotto.handler.purchase.dto.PurchaseAmountDTO;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;

public class PurchaseAmountInputHandler extends LottoHandler {

    @Override
    protected HandlerToken process(HandlerToken handlerToken) {
        String purchaseAmount = inputPurchaseAmount();
        handlerToken.addContent(TokenType.PURCHASE_AMOUNT_DTO, PurchaseAmountDTO.create(purchaseAmount));
        return handlerToken;
    }

    private String inputPurchaseAmount() {
        System.out.println(DisplayFormat.PURCHASE_INPUT.displayDefault());
        return Console.readLine();
    }
}
