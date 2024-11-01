package lotto.domain.payment;

import lotto.LottoCount;

public class PaymentResult {
    private final Payment completedPayment;
    private final LottoCount lottoCount;

    public PaymentResult(Payment completedPayment, LottoCount lottoCount) {
        this.completedPayment = completedPayment;
        this.lottoCount = lottoCount;
    }

    public Payment getCompletedPayment() {
        return completedPayment;
    }

    public LottoCount getLottoCount() {
        return lottoCount;
    }
}
