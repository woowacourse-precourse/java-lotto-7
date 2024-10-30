package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputValidatorTest {
    @Test
    void 범위_테스트() {
        assertThatThrownBy(() -> InputValidator.validateRange(46)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 단위_테스트() {
        assertThatThrownBy(() -> InputValidator.canDividedByThousand(30001)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수값_테스트() {
        assertThatThrownBy(() -> InputValidator.isNotNegativeNumber(-1)).isInstanceOf(IllegalArgumentException.class);
    }

}