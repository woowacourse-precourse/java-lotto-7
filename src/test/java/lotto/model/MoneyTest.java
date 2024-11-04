package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class MoneyTest {

    @Test
    void 금액이_0보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Money(-1000L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 0보다 커야 합니다.");
    }

    @Test
    void 금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Money(1500L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    @DisplayName("Money 객체 간의 덧셈 결과가 올바르게 반환된다.")
    @Test
    void 금액_더하기_검증() {
        Money money1 = new Money(2000L);
        Money money2 = new Money(3000L);
        Money result = money1.add(money2);

        assertThat(result.toLong()).isEqualTo(5000L);
    }

    @DisplayName("Money 객체를 지정한 값으로 곱한 결과가 올바르게 반환된다.")
    @Test
    void 금액_곱하기_검증() {
        Money money = new Money(1000L);
        Money result = money.multiply(3);

        assertThat(result.toLong()).isEqualTo(3000L);
    }

    @DisplayName("Money 객체 간의 나눗셈 결과가 올바르게 반환된다.")
    @Test
    void 금액_나누기_검증() {
        Money money1 = new Money(5000L);
        Money money2 = new Money(2000L);
        double result = money1.divide(money2);

        assertThat(result).isEqualTo(2.5);
    }
}