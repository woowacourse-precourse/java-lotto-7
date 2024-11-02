package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class WinningNumbersTest {

    @DisplayName("당첨번호가 6개다.")
    @RepeatedTest(1000)
    void 당첨번호_6개_테스트() {
        WinningNumbers winningNumbers = new WinningNumbers();
        List<Integer> numbers = winningNumbers.getWinningNumbers();
        int bonusNumber = winningNumbers.getBonusNumber();

        assertThat(numbers)
                .hasSize(6)
                .doesNotHaveDuplicates();
    }
}