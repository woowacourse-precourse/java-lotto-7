package lotto.model.winning;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersAndBonusNumberTest {

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 올바르게 설정되고 반환되어야 한다.")
    void shouldReturnWinningNumbersAndBonusNumber() {
        WinningNumbersAndBonusNumber winningNumbersAndBonusNumber = new WinningNumbersAndBonusNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), winningNumbersAndBonusNumber.getWinningNumbers().getNumbers());
        assertEquals(7, winningNumbersAndBonusNumber.getBonusNumber().getNumber());
    }

}
