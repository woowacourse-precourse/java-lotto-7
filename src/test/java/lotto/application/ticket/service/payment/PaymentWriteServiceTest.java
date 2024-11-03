package lotto.application.ticket.service.payment;

import lotto.application.common.IdGenerator;
import lotto.application.common.ThousandWons.ThousandWons;
import lotto.application.prize.repository.paymnet.PaymentWriteRepository;
import lotto.application.ticket.domain.payment.LottoQuantity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("PaymentWriteService - 결제 서비스")
class PaymentWriteServiceTest {
    private PaymentWriteRepository paymentWriteRepository;
    private IdGenerator idGenerator;
    private PaymentWriteService paymentWriteService;

    @BeforeEach
    void setUp() {
        paymentWriteRepository = new PaymentWriteRepository();
        idGenerator = new PaymentIdGenerator();
        paymentWriteService = new PaymentWriteService(paymentWriteRepository, idGenerator);
    }


    @Test
    @DisplayName("정상적인 결제 성공")
    void 정상_결제_성공() {
        // given
        ThousandWons money = ThousandWons.of("5000");

        // when
        LottoQuantity quantity = paymentWriteService.pay(money);

        // then
        Assertions.assertThat(quantity.getValue()).isEqualTo(5);
    }

    @Test
    @DisplayName("최소 금액으로 결제 성공")
    void 최소금액_결제_성공() {
        // given
        ThousandWons money = ThousandWons.of("1000");

        // when
        LottoQuantity quantity = paymentWriteService.pay(money);

        // then
        Assertions.assertThat(quantity.getValue()).isEqualTo(1);
    }

}
