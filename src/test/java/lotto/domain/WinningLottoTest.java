package lotto.domain;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {


    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void createWinningLotto_WithInvalidNumberCount_ThrowsException() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5);
        int bonusNumber = 6;

        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(LottoException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningLotto_WithDuplicateNumbers_ThrowsException() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 5);
        int bonusNumber = 6;

        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(LottoException.class)
                .hasMessage("[ERROR] 당첨 번호는 중복될 수 없습니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createWinningLotto_WithDuplicateBonusNumber_ThrowsException() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(LottoException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("보너스 번호가 1 이상 45 이하가 아니면 예외가 발생한다.")
    @Test
    void createWinningLotto_WithInvalidBonusNumberRange_ThrowsException() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 46;

        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(LottoException.class)
                .hasMessage("[ERROR] 보너스 번호는 1 이상 45 이하의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 로또 번호 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createWinningLotto_WithBonusNumberOutOfRange_ThrowsException() {
        List<Integer> winningNumbers = List.of(10, 20, 30, 40, 41, 42);
        int bonusNumber = 0;

        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(LottoException.class)
                .hasMessage("[ERROR] 보너스 번호는 1 이상 45 이하의 숫자여야 합니다.");
    }
}
