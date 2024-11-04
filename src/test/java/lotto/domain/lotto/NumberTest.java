package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 45})
    void 객체생성_테스트(int value) {
        Number number = Number.of(value);

        assertThat(number).isNotNull();
        assertThat(number.getValue()).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 범위_밖_숫자_예외(int value) {
        assertThatThrownBy(() -> Number.of(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "45, 45"
    })
    void 같은_숫자_판단_테스트(int value1, int value2) {
        Number number1 = Number.of(value1);
        Number number2 = Number.of(value2);

        assertThat(number1.equals(number2)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 5",
            "5, 45"
    })
    void 다른_숫자_판단_테스트(int value1, int value2) {
        Number number1 = Number.of(value1);
        Number number2 = Number.of(value2);

        assertThat(number1.equals(number2)).isFalse();
    }
}
