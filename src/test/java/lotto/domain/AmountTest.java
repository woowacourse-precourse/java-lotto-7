package lotto.domain;

import static lotto.domain.Amount.ZERO;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AmountTest {

    @ParameterizedTest(name = "테스트 금액 : [{arguments}]")
    @ValueSource(ints = {1000, 2000, 5000})
    void 유효한_금액_입력은_예외가_발생하지_않는다(int amount) {
        assertThatCode(() -> new Amount(amount))
                .doesNotThrowAnyException();
    }

    @Test
    void 구입금액이_0원인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Amount(ZERO))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "테스트 금액 : [{arguments}]")
    @ValueSource(ints = {123, 1234, 12345})
    void 가격_단위가_아닌_금액은_예외가_발생한다(int amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
