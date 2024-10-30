package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
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
}
