package lotto.model.purchase;

import static lotto.enums.LottoConstant.PRICE;

import java.util.List;

public class Purchase {
    private final int payment; // TODO 원시타입 포장 고민
    private final int lottoCount;
    private final LottoTickets purchasedLottoTickets;

    public Purchase(final String payment) {
        validate(payment);
        this.payment = Integer.parseInt(payment);
        this.lottoCount = this.payment / PRICE.getNumber();
        this.purchasedLottoTickets = new LottoTickets(this.lottoCount);
    }

    public int getPayment() {
        return payment;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getPurchasedLottoTickets() {
        return purchasedLottoTickets.getLottoTickets();
    }

    private void validate(final String payment) {
        // TODO 예외 처리
    }
}
