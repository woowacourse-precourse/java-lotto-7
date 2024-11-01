package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "a"})
    void 숫자가_아닌_값이_입력되면_예외가_발생한다(String invalidBonusNumber) {
        assertThatThrownBy(() -> new Number(invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void 숫자_범위를_벗어난_값이_입력되면_예외가_발생한다(String outOfRangeNumber) {
        assertThatThrownBy(() -> new Number(outOfRangeNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
