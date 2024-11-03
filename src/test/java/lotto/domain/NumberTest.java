package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void validateTest_whenValueIsOutOfBound_throwException(int value) {
        assertThatThrownBy(() -> new Number(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자는 1 이상 45이하 이어야 합니다");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void validateTest_whenValueIsInbound(int value) {
        assertThatCode(() -> new Number(value))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void equalsTest_whenSameNumber_returnTrue(int value) {
        Number number1 = new Number(value);
        Number number2 = new Number(value);

        boolean result = number1.equals(number2);

        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1, 2", "44, 45"})
    void equalsTest_whenDifferentNumber_returnTrue(int value1, int value2) {
        Number number1 = new Number(value1);
        Number number2 = new Number(value2);

        boolean result = number1.equals(number2);

        assertThat(result).isFalse();
    }
}
