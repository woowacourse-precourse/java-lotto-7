package lotto.domain.payment.paymentResult;

import lotto.domain.common.ThousandWons.ThousandWons;
import lotto.domain.payment.LottoPrice;
import lotto.domain.payment.LottoQuantity;
import lotto.domain.payment.Payment;
import lotto.domain.payment.PaymentResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PaymentResult - 완료된 결제 정보 조회")
public class GetCompletePaymentTest {

    @Test
    @DisplayName("완료된 결제 정보 조회 성공")
    void 완료된_결제_정보_조회_성공() {
        // given
        Payment initializedPayment = Payment.initialize(1L, ThousandWons.of("5000"), LottoPrice.basic());
        Payment validatePayment = initializedPayment.validate();
        PaymentResult result = new PaymentResult(validatePayment, LottoQuantity.of(5));

        // when
        Payment completedPayment = result.getCompletedPayment();

        // then
        Assertions.assertThat(completedPayment).isEqualTo(validatePayment);
    }

}
