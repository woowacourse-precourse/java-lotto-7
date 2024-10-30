package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    @DisplayName("보너스 번호가 1보다 작은 숫자면 예외가 발생한다.")
    void should_ThrowException_When_BonusNumberBelowMinimum() {
        // when & then
        assertThatThrownBy(() -> new BonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 45보다 큰 숫자면 예외가 발생한다.")
    void should_ThrowException_When_BonusNumberAboveMaximum() {
        // when & then
        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
