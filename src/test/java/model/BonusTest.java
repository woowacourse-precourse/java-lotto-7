package model;

import lotto.model.Bonus;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BonusTest {

    @Test
    void createBonus_WithValidNumber_ShouldCreateSuccessfully() {
        // given
        int bonusNumber = 7;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        Bonus bonus = new Bonus(bonusNumber, winningNumbers);

        // then
        assertThat(bonus.getNumber()).isEqualTo(bonusNumber);
    }

    @Test
    void createBonus_WithNumberLessThan1_ShouldThrowException() {
        // given
        int bonusNumber = 0;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatThrownBy(() -> new Bonus(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void createBonus_WithNumberGreaterThan45_ShouldThrowException() {
        // given
        int bonusNumber = 46;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatThrownBy(() -> new Bonus(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void createBonus_WithDuplicateWinningNumber_ShouldThrowException() {
        // given
        int bonusNumber = 1;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatThrownBy(() -> new Bonus(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}
