package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoneyTest {

    @Test
    void 금액이_음수면_예외를_발생시킨다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(-1000));
    }

    @ParameterizedTest(name = "{0}으로 {1}짜리를 사면 잔돈이 생긴다={2}")
    @CsvSource(value = {"15000,1500,false", "10000,1100,true"}, delimiter = ',')
    void 잔돈의_유무를_알_수_있다(int amount, int price, boolean expected) {
        assertThat(new Money(amount).hasChangesWith(price)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0}으로 {1}짜리를 {2}개 살 수 있다")
    @CsvSource(value = {"15000,1500,10", "10000,1100,9"}, delimiter = ',')
    void 투입_금액으로_살_수_있는_양을_알_수_있다(int amount, int price, int expected) {
        assertThat(new Money(amount).countAffordableFor(price)).isEqualTo(expected);
    }
}
