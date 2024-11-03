package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.winningResult.WinningRank;
import lotto.model.winningResult.WinningResult;
import org.junit.jupiter.api.Test;

public class WinningResultTest {
    @Test
    void 당첨로또_개수를_0으로_초기화한다() {
        WinningResult winningResult = new WinningResult(WinningRank.FIRST);

        assertThat(winningResult.getWinningLottoAmount()).isEqualTo(0);
    }

    @Test
    void 당첨로또_개수를_1_증가시킨다() {
        WinningResult winningResult = new WinningResult(WinningRank.FIRST);
        winningResult.addLottoAmount();
        winningResult.addLottoAmount();
        winningResult.addLottoAmount();

        assertThat(winningResult.getWinningLottoAmount()).isEqualTo(3);
    }
}
