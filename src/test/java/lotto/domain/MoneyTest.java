package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("구입 금액이 null, 0, 또는 음수일 때 예외가 발생한다.")
    @ParameterizedTest
    @FieldSource("invalidAmounts")
    void amountCannotBeNullOrZeroOrNegative(BigInteger amount) {
        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구입 금액이 올바르지 않습니다.");
    }

    static final List<BigInteger> invalidAmounts = Arrays.asList(null, BigInteger.ZERO, BigInteger.valueOf(-1));

    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void amountShouldBeDividedBy1000() {
        assertThatThrownBy(() -> new Money(BigInteger.valueOf(1100)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
    }

    @DisplayName("구입 금액에 따라 구매할 수 있는 로또 개수를 반환한다.")
    @Test
    void returnAvailableLottoCountByAmount() {
        Money money = new Money(BigInteger.valueOf(8000));

        assertThat(money.availableLottoCount()).isEqualTo(8);
    }

}
