package lotto.model;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    @DisplayName("WinningLotto 객체 생성 테스트")
    void 객체_생성_테스트() {
        Lotto winningNumbers = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);
        
        Assertions.assertEquals(winningNumbers, winningLotto.getLotto());
        Assertions.assertEquals(bonusNumber, winningLotto.getBonusNumber());
    }
}
