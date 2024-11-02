package lotto.domain.payment.paymentResult;

import lotto.domain.common.ThousandWons.ThousandWons;
import lotto.domain.payment.LottoPrice;
import lotto.domain.payment.LottoQuantity;
import lotto.domain.payment.Payment;
import lotto.domain.payment.PaymentResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("PaymentResult - 생성")
class CreateTest {

    @Test
    @DisplayName("결제 결과 생성 성공")
    void 결제_결과_생성_성공() {
        // given
        LottoQuantity lottoQuantity = LottoQuantity.of(5);

        Payment initializedPayment = Payment.initialize(1L, ThousandWons.of("5000"), LottoPrice.basic());
        Payment validatedPayment = initializedPayment.validate();

        // when
        PaymentResult result = new PaymentResult(validatedPayment, lottoQuantity);

        // then
        Assertions.assertThat(result).isNotNull();
    }

}
