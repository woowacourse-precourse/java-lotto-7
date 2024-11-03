package lotto;

import lotto.domain.Bonus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {

    @DisplayName("보너스 번호는 1과 45사이여야 한다.")
    @Test
    void validate() {
        Assertions.assertThatThrownBy(() -> new Bonus(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
