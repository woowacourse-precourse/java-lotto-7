package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
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
}
