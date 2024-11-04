package lotto.application.prize.repository.paymnet;

import lotto.application.common.ThousandWons.ThousandWons;
import lotto.application.ticket.domain.payment.LottoPrice;
import lotto.application.ticket.domain.payment.Payment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("PaymentWriteRepository 테스트")
class PaymentWriteRepositoryTest {

    @DisplayName("저장 성공")
    @Test
    void 저장_성공() {
        // given
        PaymentWriteRepository repository = new PaymentWriteRepository();
        Payment payment = Payment.initialize(1L,
                ThousandWons.of("1000"),
                LottoPrice.basic()
        );

        // when
        Long savedId = repository.save(payment);

        // then
        Assertions.assertThat(savedId).isEqualTo(1L);

    }

    @DisplayName("중복 아이디 저장시 덮어쓰기 성공")
    @Test
    void 중복_아이디_저장시_덮어쓰기_성공() {
        // given
        PaymentWriteRepository repository = new PaymentWriteRepository();
        Payment payment1 = Payment.initialize(1L,
                ThousandWons.of("1000"),
                LottoPrice.basic()
        );

        Payment payment2 = Payment.initialize(1L,
                ThousandWons.of("2000"),
                LottoPrice.basic()
        );

        // when
        Long savedId1 = repository.save(payment1);
        Long savedId2 = repository.save(payment2);

        // then
        Assertions.assertThat(savedId1).isEqualTo(savedId2);

    }


}
