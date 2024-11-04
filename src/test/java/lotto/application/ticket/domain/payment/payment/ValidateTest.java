package lotto.application.ticket.domain.payment.payment;

import lotto.application.common.ThousandWons.ThousandWons;
import lotto.application.ticket.domain.payment.LottoPrice;
import lotto.application.ticket.domain.payment.Payment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Payment - 결제 검증")
class ValidateTest {

    @Test
    @DisplayName("결제 검증 성공")
    void 결제_검증_성공() {
        // given
        Payment payment = Payment.initialize(1L,
                ThousandWons.of("5000"),
                LottoPrice.basic());

        // expect
        Assertions.assertThatCode(() -> payment.validate())
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("이미 검증된 결제는 재검증 불가")
    void 이미_검증된_결제_재검증_불가() {
        // given
        Payment payment = Payment.initialize(1L,
                ThousandWons.of("5000"),
                LottoPrice.basic());

        Payment validatedPayment = payment.validate();

        // expect
        Assertions.assertThatThrownBy(() -> validatedPayment.validate())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("[ERROR] 결제 대기 상태가 아닙니다.");
    }

}
