package lotto.model.shop;

import lotto.util.Validator;
import lotto.model.ticket.LottoTickets;
import lotto.rule.LottoRule;

public class TicketSeller {

    private final LottoMachine lottoMachine;

    public TicketSeller(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public LottoTickets exchangeMoneyForTickets(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int quantity = calculateLottoQuantity(purchaseAmount);
        return lottoMachine.issueTicket(quantity);
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        Validator.checkAboveBaseAmount(purchaseAmount);
        Validator.checkPurchaseAmountUnit(purchaseAmount);
    }

    private int calculateLottoQuantity(int purchaseAmount) {
        return purchaseAmount / LottoRule.PURCHASE_AMOUNT_UNIT.get();
    }
}
