package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @DisplayName("당첨 번호가 유효한 숫자가 아니면 예외가 발생한다.")
    @Test
    void invalidWinningNumbers() {
        List<Integer> invalidWinningNumbers = List.of(0, 1, 2, 3, 4, 5);
        int invalidBonusNumber = 2000;

        assertThatThrownBy(() -> new WinningLotto(invalidWinningNumbers, invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 유효한 숫자가 아니면 예외가 발생한다.")
    @Test
    void invalidBonusNumber() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int invalidBonusNumber = 2000;

        assertThatThrownBy(() -> new WinningLotto(winningNumbers, invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되는 번호이면 예외가 발생한다.")
    @Test
    void winningNumbersContainBonusNumber() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int invalidBonusNumber = 4;

        assertThatThrownBy(() -> new WinningLotto(winningNumbers, invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
