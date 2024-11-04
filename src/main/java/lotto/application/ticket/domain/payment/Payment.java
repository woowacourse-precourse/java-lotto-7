package lotto.application.ticket.domain.payment;

import static lotto.application.ticket.domain.payment.PaymentStatus.COMPLETED;
import static lotto.application.ticket.domain.payment.PaymentStatus.PAYABLE;
import static lotto.application.ticket.domain.payment.PaymentStatus.PENDING;

import lotto.application.common.ThousandWons.ThousandWons;

public class Payment {

    private final Long id;
    private final ThousandWons money;
    private final PaymentStatus status;
    private final LottoPrice lottoPrice;

    private Payment(Long id, ThousandWons money, LottoPrice lottoPrice, PaymentStatus status) {
        this.id = id;
        this.money = money;
        this.lottoPrice = lottoPrice;
        this.status = status;
    }

    public static Payment initialize(Long id, ThousandWons money, LottoPrice lottoPrice) {
        return new Payment(id, money, lottoPrice, PENDING);
    }

    public Payment validate() {
        validateStatusPending();
        validatePurchaseAmount();

        return new Payment(id, money, lottoPrice, PAYABLE);
    }

    public PaymentResult execute() {
        validateStatusPayable();

        return createPaymentResult();
    }

    public Long getId() {
        return id;
    }

    private PaymentResult createPaymentResult() {
        int count = lottoPrice.calculateLottoCount(money);
        Payment completedPayment = new Payment(id, money, lottoPrice, COMPLETED);

        return new PaymentResult(completedPayment, LottoQuantity.of(count));
    }

    private void validateStatusPending() {
        if (status != PENDING) {
            throw new IllegalStateException("[ERROR] 결제 대기 상태가 아닙니다.");
        }
    }

    private void validateStatusPayable() {
        if (status != PAYABLE) {
            throw new IllegalStateException("[ERROR] 결제 가능한 상태가 아닙니다.");
        }
    }

    private void validatePurchaseAmount() {
        lottoPrice.validateAffordable(money);
    }


}
