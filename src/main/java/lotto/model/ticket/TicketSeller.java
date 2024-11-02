package lotto.model.ticket;

import lotto.error.InputError;
import lotto.rule.LottoRule;

public class TicketSeller {

    private final LottoMachine lottoMachine;

    public TicketSeller(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public LottoTickets exchangeMoneyForTickets(int purchaseAmount) {
        validatePurchaseAmountUnit(purchaseAmount);
        int quantity = calculateLottoQuantity(purchaseAmount);
        return lottoMachine.issueTicket(quantity);
    }

    private void validatePurchaseAmountUnit(int purchaseAmount) {
        if (purchaseAmount % LottoRule.PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(InputError.PURCHASE_AMOUNT_UNIT_INVALID.getMessage());
        }
    }

    private int calculateLottoQuantity(int purchaseAmount) {
        return purchaseAmount / LottoRule.PURCHASE_AMOUNT_UNIT;
    }
}
