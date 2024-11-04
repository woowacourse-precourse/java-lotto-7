package lotto.application.ticket.domain.payment;

public class PaymentResult {
    private final Payment completedPayment;
    private final LottoQuantity lottoQuantity;

    public PaymentResult(Payment completedPayment, LottoQuantity lottoQuantity) {
        this.completedPayment = completedPayment;
        this.lottoQuantity = lottoQuantity;
    }

    public Payment getCompletedPayment() {
        return completedPayment;
    }

    public LottoQuantity getLottoCount() {
        return lottoQuantity;
    }

    public int getLottoQuantity() {
        return lottoQuantity.getValue();
    }
}
