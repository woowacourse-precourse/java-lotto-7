package lotto.application.ticket.domain.payment.paymentResult;

import lotto.application.common.ThousandWons.ThousandWons;
import lotto.application.ticket.domain.payment.LottoPrice;
import lotto.application.ticket.domain.payment.LottoQuantity;
import lotto.application.ticket.domain.payment.Payment;
import lotto.application.ticket.domain.payment.PaymentResult;
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
