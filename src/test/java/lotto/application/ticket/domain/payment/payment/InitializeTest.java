package lotto.application.ticket.domain.payment.payment;

import lotto.application.common.ThousandWons.ThousandWons;
import lotto.application.ticket.domain.payment.LottoPrice;
import lotto.application.ticket.domain.payment.Payment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Payment - 결제 초기화")
class InitializeTest {

    @Test
    @DisplayName("결제 초기화 성공")
    void 결제_초기화_성공() {
        // given
        Long id = 1L;
        ThousandWons money = ThousandWons.of("5000");
        LottoPrice lottoPrice = LottoPrice.basic();

        // when
        Payment payment = Payment.initialize(id, money, lottoPrice);

        // then
        Assertions.assertThat(payment.getId()).isEqualTo(id);
    }

}
