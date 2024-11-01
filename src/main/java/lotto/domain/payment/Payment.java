package lotto.domain.payment;

import static lotto.domain.payment.PaymentStatus.COMPLETED;
import static lotto.domain.payment.PaymentStatus.PAYABLE;
import static lotto.domain.payment.PaymentStatus.PENDING;

import lotto.ThousandWons;

public class Payment {
    
    private final Long id;
    private final ThousandWons money;
    private final PaymentStatus status;
    private final LottoPrice lottoPrice;

    public Payment(Long id, ThousandWons money, LottoPrice lottoPrice, PaymentStatus status) {
        this.id = id;
        this.money = money;
        this.lottoPrice = lottoPrice;
        this.status = status;
    }

    public static Payment initialize(Long id, ThousandWons money, LottoPrice lottoPrice) {
        return new Payment(id, money, lottoPrice, PENDING);
    }

    public Payment validate() {
        validatePayable();
        return new Payment(id, money, lottoPrice, PAYABLE);
    }

    public PaymentResult execute() {
        validatePayable();

        int count = lottoPrice.calculateLottoCount(money);
        Payment completedPayment = new Payment(id, money, lottoPrice, COMPLETED);

        return new PaymentResult(completedPayment, LottoQuantity.of(count));
    }

    public Long getId() {
        return id;
    }

    private void validatePayable() {
        if (!lottoPrice.isAffordable(money)) {
            throw new IllegalArgumentException("구매 금액이 부족합니다.");
        }
    }

}
