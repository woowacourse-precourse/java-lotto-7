package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.global.contents.LottoDetail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PaymentTest {

    private static final String ERROR_PREFIX = "[ERROR]";

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
                .hasMessageContaining(ERROR_PREFIX);
    }

    @DisplayName("지불 금액이 0원이면 예외 발생")
    @Test
    void 지불금액_제로_예외() {
        assertThatThrownBy(() -> Payment.of(0, LottoDetail.PRICE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }

    @DisplayName("로또 구입 금액은 100,000원을 넘을 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {101_000, 103_000, 1_000_000})
    void 최대_구입_금액_예외(int money) {
        assertThatThrownBy(() -> Payment.of(money, LottoDetail.PRICE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }
}
