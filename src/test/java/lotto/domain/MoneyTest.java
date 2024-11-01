package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

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

}
