package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    void 당첨_번호를_저장한다() {
        WinningNumbers winningNumbers = new WinningNumbers(
                List.of(1, 2, 3, 4, 5, 6)
        );

        assertThat(winningNumbers.getWinningNumbers())
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
