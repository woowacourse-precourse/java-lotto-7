package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {

    @DisplayName("당첨번호 생성 성공")
    @Test
    void createWinningNumberSuccessTest() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        WinningNumbers winningNums = new WinningNumbers(winningNumbers, bonusNumber);

        assertThat(winningNums.getWinningLotto().getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningNums.getBonusNumber()).isEqualTo(7);
    }
}
