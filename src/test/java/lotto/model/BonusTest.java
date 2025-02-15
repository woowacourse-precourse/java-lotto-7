package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {

    @Test
    @DisplayName("보너스 번호 범위는 1이상 45이하만 가능합니다.")
    void givenOutOfRangeNumber_whenBonus_thenIllegalArgumentException() {
        assertThatThrownBy(() -> new Bonus(-1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Bonus(48))
                .isInstanceOf(IllegalArgumentException.class);
    }

}