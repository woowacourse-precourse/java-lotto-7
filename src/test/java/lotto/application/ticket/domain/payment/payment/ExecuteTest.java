package lotto.application.ticket.domain.payment.payment;

import lotto.application.common.ThousandWons.ThousandWons;
import lotto.application.ticket.domain.payment.LottoPrice;
import lotto.application.ticket.domain.payment.Payment;
import lotto.application.ticket.domain.payment.PaymentResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Payment - 실행")
public class ExecuteTest {

    @Test
    @DisplayName("결제 실행 성공")
    void 결제_실행_성공() {
        // given
        Payment payment = Payment.initialize(1L, ThousandWons.of("5000"), LottoPrice.basic());
        Payment validatePayment = payment.validate();

        // when
        PaymentResult result = validatePayment.execute();

        // then
        Assertions.assertThat(result).isNotNull();
    }

    @Test
    @DisplayName("이미 완료된 결제는 재실행 불가")
    void 이미_완료된_결제_재실행_불가() {
        // given
        Payment payment = Payment.initialize(1L, ThousandWons.of("5000"), LottoPrice.basic());
        Payment validatedPayment = payment.validate();
        PaymentResult paymentResult = validatedPayment.execute();
        Payment completedPayment = paymentResult.getCompletedPayment();

        // expect
        Assertions.assertThatThrownBy(() -> completedPayment.execute())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("[ERROR] 결제 가능한 상태가 아닙니다.");
    }

    @Test
    @DisplayName("로또 수량이 정확히 계산됨")
    void 로또_수량이_정확히_계산됨() {
        // given
        Payment payment = Payment.initialize(1L, ThousandWons.of("5000"), LottoPrice.basic());
        Payment validatedPayment = payment.validate();

        // when
        PaymentResult paymentResult = validatedPayment.execute();
        int lottoQuantity = paymentResult.getLottoQuantity();

        // then
        Assertions.assertThat(lottoQuantity).isEqualTo(5);
    }

}
