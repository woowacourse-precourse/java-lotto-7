package lotto.buyer.infrastructure;

import lotto.buyer.service.InsertMoneyService;
import lotto.money.domain.Money;
import lotto.money.infrastructure.PurchaseAmount;
import lotto.view.input.hanlder.domain.InputHandlerService;

public class UserInputInsertMoney implements InsertMoneyService {
    private final InputHandlerService inputHandlerService;
    public UserInputInsertMoney(InputHandlerService inputHandlerService) {
        this.inputHandlerService = inputHandlerService;
    }
    @Override
    public Money insert() {
        return inputHandlerService.retrieveReceive(PurchaseAmount::of);
    }
}
