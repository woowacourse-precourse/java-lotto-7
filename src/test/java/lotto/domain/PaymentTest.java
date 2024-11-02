package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.global.contents.LottoDetail;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PaymentTest {

    @ParameterizedTest
    @ValueSource(ints = {1_000, 10_000, 100_000})
    void 객체생성_테스트(int money) {
        Payment payment = Payment.of(money, LottoDetail.PRICE);

        assertThat(payment).isNotNull();
        assertThat(payment.calculateCount(LottoDetail.PRICE))
                .isEqualTo(money / 1000);
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 10_500, 100_100})
    void 천_단위_안떨어지면_예외(int money) {
        assertThatThrownBy(() -> Payment.of(money, LottoDetail.PRICE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
