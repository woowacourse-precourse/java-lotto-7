package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumbersTest {

    @Test
    @DisplayName("같은 번호 개수를 반환한다.")
    void compareAt() {
        WinningNumbers winningNumbers = WinningNumbers.of(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = Lotto.of(List.of(4, 5, 6, 7, 8, 9));

        int result = winningNumbers.compareAt(lotto);

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자가 포함되어 있는지 확인한다.")
    void containAt() {
        WinningNumbers winningNumbers = WinningNumbers.of(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        boolean result = winningNumbers.containAt(bonusNumber);

        assertThat(result).isTrue();
    }

}