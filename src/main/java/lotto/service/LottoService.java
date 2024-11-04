package lotto.service;

import lotto.domain.buyer.Buyer;
import lotto.domain.buyer.BuyerFactory;
import lotto.view.InputHandler;

public class LottoService {
    private final InputHandler inputHandler;

    public LottoService(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public Buyer createBuyer(String inputMoney) {
        int money = inputHandler.stringToNumber(inputMoney);

        return BuyerFactory.createBuyer(money);
    }
}
