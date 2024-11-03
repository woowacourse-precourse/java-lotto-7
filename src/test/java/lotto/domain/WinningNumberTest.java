package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {

    @DisplayName("당첨번호 생성 성공")
    @Test
    void createWinningNumberSuccessTest() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        WinningNumbers winningNums = new WinningNumbers(winningNumbers, bonusNumber);

        assertThat(winningNums.getWinningLotto().getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningNums.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("보너스번호 당첨번호와 중복 예외")
    @Test
    void duplicateBonusNumberAndWinningNumbersTest() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        assertThatThrownBy(() -> new WinningNumbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("보너스번호 범위 벗어남 예외")
    @Test
    void bonusNumberNotInRangeTest() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 46;

        assertThatThrownBy(() -> new WinningNumbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
    }

    @DisplayName("당첨번호 개수 6개 아님 예외")
    @Test
    void winningNumbersSizeNotSix() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5);
        int bonusNumber = 7;

        assertThatThrownBy(() -> new WinningNumbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개여야 합니다.");
    }
}
