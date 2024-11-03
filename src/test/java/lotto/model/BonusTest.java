package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusTest {
    @DisplayName("보너스 번호가 1보다 작은 숫자면 예외가 발생한다.")
    @Test
    void bonusUnderRange() {
        assertThatThrownBy(() -> new Bonus(0, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 45보다 큰 숫자면 예외가 발생한다.")
    @Test
    void bonusOverRange() {
        assertThatThrownBy(() -> new Bonus(46, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void bonusDuplicatedNumber() {
        assertThatThrownBy(() -> new Bonus(1, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
