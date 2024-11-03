package lotto.system.lottoGetter;

import static lotto.system.utils.constants.LottoConstants.TICKET_PRICE;

import java.util.List;
import lotto.system.unit.LottoTicket;

public class LottoTicketIssuer { // 로또 구매 금액을 입력 받아 로또 티켓을 발급하는 객체

    private final int purchaseAmount;
    private final int quantity;

    public LottoTicketIssuer(int totalPayment) {
        LottoPaymentValidator.validate(totalPayment);
        this.purchaseAmount = totalPayment;
        this.quantity = calculateQuantity(totalPayment);
    }

    private int calculateQuantity(int totalPayment) {
        return totalPayment / TICKET_PRICE;
    }

    public List<LottoTicket> issueLottoTickets() {
        return LottoTicketFactory.generate(quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}