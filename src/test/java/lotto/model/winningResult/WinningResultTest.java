package lotto.model.winningResult;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.lotto.winningResult.WinningResult;
import lotto.model.lotto.winningResult.rank.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningResultTest {
    WinningResult defaultWinningResult;

    @BeforeEach
    void setUp() {
        defaultWinningResult = new WinningResult(Rank.FIRST);
    }

    @Test
    void 당첨로또_개수를_0으로_초기화한다() {
        assertThat(defaultWinningResult.getWinningLottoAmount()).isEqualTo(0);
    }

    @Test
    void 당첨로또_개수를_1_증가시킨다() {
        defaultWinningResult.addLottoAmount();
        defaultWinningResult.addLottoAmount();
        defaultWinningResult.addLottoAmount();

        assertThat(defaultWinningResult.getWinningLottoAmount()).isEqualTo(3);
    }
}
