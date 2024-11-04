package lotto.store.user;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CashTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 10000})
    void 로또_구매_금액의_단위가_맞으면_예외가_발생하지_않는다(int amount) {
        assertDoesNotThrow(() -> Cash.from(amount));
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 1234, 10500})
    void 로또_구매_금액의_단위가_아니면_예외가_발생한다(int amount) {
        assertThatThrownBy(() -> Cash.from(amount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 1장의 가격은 1,000원 입니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 50000, 99000})
    void 로또_구매_금액이_최대값을_초과하지_않으면_예외가_발생하지_않는다(int amount) {
        assertDoesNotThrow(() -> Cash.from(amount));
    }

    @ParameterizedTest
    @ValueSource(ints = {101000, 1000000})
    void 로또_구매_금액이_최대값을_초과하면_예외가_발생한다(int amount) {
        assertThatThrownBy(() -> Cash.from(amount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 1회차당 구매 금액은 최대 10만원 입니다.");
    }

}
