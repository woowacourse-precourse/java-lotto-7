package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusTest {

    @DisplayName("보너스 번호가 1에서 45 사이의 숫자가 아닐 경우 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1, 1000000000})
    void 보너스_번호가_1에서_45_사이의_숫자가_아닐_경우_예외를_발생한다(Integer input) {
        assertThatThrownBy(() -> new Bonus(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}