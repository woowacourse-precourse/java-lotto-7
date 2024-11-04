package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @DisplayName("당첨 번호 객체 정상 생성 테스트")
    @Test
    void createWinningLotto() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        assertEquals(winningNumbers, winningLotto.getNumbers());
        assertEquals(bonusNumber, winningLotto.getBonusNumber());
    }
}
