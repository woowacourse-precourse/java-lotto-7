package lotto.service.payment;

import lotto.domain.common.ThousandWons.ThousandWons;
import lotto.domain.payment.LottoQuantity;
import lotto.repository.paymnet.PaymentRepository;
import lotto.service.IdGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("PaymentService - 결제 서비스")
class PaymentServiceTest {
    private PaymentRepository paymentRepository;
    private IdGenerator idGenerator;
    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        paymentRepository = new PaymentRepository();
        idGenerator = new PaymentIdGenerator();
        paymentService = new PaymentService(paymentRepository, idGenerator);
    }


    @Test
    @DisplayName("정상적인 결제 성공")
    void 정상_결제_성공() {
        // given
        ThousandWons money = ThousandWons.of("5000");

        // when
        LottoQuantity quantity = paymentService.pay(money);

        // then
        Assertions.assertThat(quantity.getValue()).isEqualTo(5);
    }

    @Test
    @DisplayName("최소 금액으로 결제 성공")
    void 최소금액_결제_성공() {
        // given
        ThousandWons money = ThousandWons.of("1000");

        // when
        LottoQuantity quantity = paymentService.pay(money);

        // then
        Assertions.assertThat(quantity.getValue()).isEqualTo(1);
    }

}
