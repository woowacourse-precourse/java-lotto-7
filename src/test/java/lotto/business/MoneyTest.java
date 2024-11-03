package lotto.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {
    @Nested
    class TestConstructor {
        @Test
        void should_create() {
            // given
            int value = 1_000;

            // when, then
            assertThatCode(() -> new Money(value)).doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(ints = {-1, -100, -1_000})
        void should_throw_when_negative_value(int negativeValue) {
            // when, then
            assertThatThrownBy(() -> new Money(negativeValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 금액은 0 이상이어야 합니다.");
        }

        @ParameterizedTest
        @ValueSource(ints = {1_001, 2_050, 3_200})
        void should_throw_when_invalid_unit(int invalidUnit) {
            // when, then
            assertThatThrownBy(() -> new Money(invalidUnit))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    @Nested
    class TestIsDivisibleBy {
        @Test
        void should_return_true() {
            // given
            Money money = new Money(2_000);
            Money divisor = new Money(1_000);

            // when
            boolean actual = money.isDivisibleBy(divisor);

            // then
            assertThat(actual).isTrue();
        }

        @Test
        void should_return_false() {
            // given
            Money money = new Money(3_000);
            Money divisor = new Money(2_000);

            // when
            boolean actual = money.isDivisibleBy(divisor);

            // then
            assertThat(actual).isFalse();
        }
    }

    @Nested
    class TestMultiply {
        @Test
        void should_return_multiplied_value() {
            // given
            Money money = new Money(1_000);
            int multiplier = 2;

            // when
            int actual = money.multiply(multiplier);

            // then
            assertThat(actual).isEqualTo(2_000);
        }
    }

    @Nested
    class TestDivide {
        @Test
        void should_return_divided_value() {
            // given
            Money money = new Money(2_000);
            Money divisor = new Money(1_000);

            // when
            int actual = money.divide(divisor);

            // then
            assertThat(actual).isEqualTo(2);
        }
    }
}
