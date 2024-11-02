package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.FieldSource;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("구입 금액이 null 또는 음수일 때 예외가 발생한다.")
    @ParameterizedTest
    @FieldSource("invalidAmounts")
    void amountCannotBeNullOrZeroOrNegative(BigInteger amount) {
        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액이 올바르지 않습니다.");
    }

    static final List<BigInteger> invalidAmounts = Arrays.asList(null, BigInteger.valueOf(-1));

    @DisplayName("돈은 나머지 계산을 할 수 있다.")
    @Test
    void calculateRemainder() {
        Money dividend = new Money(BigInteger.valueOf(12500));
        Money divisor = new Money(BigInteger.valueOf(1000));

        assertThat(dividend.remainder(divisor)).isEqualTo(BigInteger.valueOf(500));
    }

    @DisplayName("0으로 나머지 계산 시 예외가 발생한다.")
    @Test
    void cannotRemainderWithZero() {
        Money dividend = new Money(BigInteger.valueOf(12500));
        Money divisor = new Money(BigInteger.valueOf(0));

        assertThatThrownBy(() -> dividend.remainder(divisor))
                .isInstanceOf(ArithmeticException.class);
    }

    @DisplayName("돈은 나누기 계산을 할 수 있다.")
    @Test
    void calculateDivide() {
        Money dividend = new Money(BigInteger.valueOf(12500));
        Money divisor = new Money(BigInteger.valueOf(1000));

        assertThat(dividend.divide(divisor)).isEqualTo(BigInteger.valueOf(12));
    }

    @DisplayName("0으로 나누기 계산 시 예외가 발생한다.")
    @Test
    void cannotDivideWithZero() {
        Money dividend = new Money(BigInteger.valueOf(12500));
        Money divisor = new Money(BigInteger.valueOf(0));

        assertThatThrownBy(() -> dividend.divide(divisor))
                .isInstanceOf(ArithmeticException.class);
    }

    @DisplayName("금액이 같으면 같은 돈이고, 다른 금액이면 다른 돈이다.")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1000, true", "1000, 500, false"})
    void compareMoney(int amount1, int amount2, boolean expected) {
        Money money1 = new Money(BigInteger.valueOf(amount1));
        Money money2 = new Money(BigInteger.valueOf(amount2));

        assertThat(money1.equals(money2)).isEqualTo(expected);
    }

}
