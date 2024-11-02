package lotto.dto;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되는 경우 예외 발생")
    void createWinningLottoWithDuplicateBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        assertThrows(IllegalArgumentException.class,
            () -> new WinningLotto(lotto, bonusNumber)
        );
    }

}