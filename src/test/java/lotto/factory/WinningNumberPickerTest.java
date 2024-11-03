package lotto.factory;

import lotto.model.Lotto;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberPickerTest {

    @DisplayName("당첨 번호를 올바르게 생성한다.")
    @Test
    void 당첨번호를_올바르게_생성한다() {
        String mainNumbers = "1,2,3,4,5,6";
        int bonusNumber = 7;

        WinningNumbers winningNumbers = WinningNumberPicker.createWinningNumbers(mainNumbers, bonusNumber);
        Lotto lottoMainNumbers = winningNumbers.mainNumbers();

        assertThat(lottoMainNumbers.numbers()).hasSize(6);
        assertThat(lottoMainNumbers.numbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningNumbers.bonusNumber()).isEqualTo(bonusNumber);
    }
}
