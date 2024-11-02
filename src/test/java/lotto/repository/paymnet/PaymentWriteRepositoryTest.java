package lotto.repository.paymnet;

import lotto.domain.common.ThousandWons.ThousandWons;
import lotto.domain.payment.LottoPrice;
import lotto.domain.payment.Payment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PaymentWriteRepository - 결제 저장소")
class PaymentWriteRepositoryTest {

    @Test
    @DisplayName("결제 정보 저장 성공")
    void 결제_정보_저장_성공() {
        // given
        PaymentWriteRepository repository = new PaymentWriteRepository();

        Payment payment = Payment.initialize(
                1L,
                ThousandWons.of("5000"),
                LottoPrice.basic());

        // when
        Long savedId = repository.save(payment);

        // then
        Assertions.assertThat(savedId).isEqualTo(1L);
    }

}
