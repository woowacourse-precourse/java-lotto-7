package lotto.buyer.infrastructure;

import lotto.buyer.domain.InsertMoneyService;
import lotto.buyer.domain.Money;
import lotto.view.input.hanlder.domain.InputHandlerService;

public class InsertMoney implements InsertMoneyService {
    private final InputHandlerService inputHandlerService;
    public InsertMoney(InputHandlerService inputHandlerService) {
        this.inputHandlerService = inputHandlerService;
    }
    @Override
    public Money insert() {
        return inputHandlerService.retrieveReceive(Won::new);
    }
}
