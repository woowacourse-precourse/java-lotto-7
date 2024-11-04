package lotto.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.model.lotto.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외 발생")
    void bonusNumberOverlappingWithWinningNumbers() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 3; // 중복되는 숫자
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("보너스 번호가 1에서 45 사이가 아닌 경우 예외 발생")
    void bonusNumberOutOfRange() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 50; // 유효 범위를 벗어난 숫자
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아닌 경우 예외 발생")
    void winningNumbersSizeInvalid() {
        List<Integer> invalidWinningNumbers = List.of(1, 2, 3, 4, 5); // 5개의 숫자
        int bonusNumber = 7;
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(invalidWinningNumbers, bonusNumber));
    }
}
