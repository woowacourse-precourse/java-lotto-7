package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @DisplayName("당첨 로또가 유효한 입력일 때 정상 동작한다.")
    @Test
    public void testWinningLotto_ValidInput() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        assertEquals(winningNumbers, winningLotto.getNumbers());
        assertEquals(bonusNumber, winningLotto.getBonusNumber());
    }

    @DisplayName("당첨 로또 번호 개수가 6개가 아닐 경우 예외가 발생한다.")
    @Test
    public void testWinningLotto_InvalidNumberCount() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3);
        Integer bonusNumber = 4;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(winningNumbers, bonusNumber);
        });
        assertEquals("[ERROR] 로또 번호는 6개여야 합니다.", exception.getMessage());
    }

    @DisplayName("당첨 로또 번호가 1~45 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    public void testWinningLotto_InvalidNumberRange() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);
        Integer bonusNumber = 7;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(winningNumbers, bonusNumber);
        });
        assertEquals("[ERROR] 로또 번호는 1~45 사이의 숫자만 가능합니다.", exception.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함될 경우 예외가 발생한다.")
    @Test
    public void testWinningLotto_BonusNumberInWinningNumbers() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 6;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(winningNumbers, bonusNumber);
        });
        assertEquals("[ERROR] 보너스 번호는 당첨 번호에 포함되지 않아야 합니다.", exception.getMessage());
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    public void testWinningLotto_InvalidBonusNumberRange() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 46;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(winningNumbers, bonusNumber);
        });
        assertEquals("[ERROR] 보너스 번호는 1~45 사이의 숫자만 가능합니다.", exception.getMessage());
    }
}
