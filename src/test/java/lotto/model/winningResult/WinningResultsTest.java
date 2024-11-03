package lotto.model.winningResult;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class WinningResultsTest {
    private final WinningResults winningResults = new WinningResults();
    @Test
    void 등수별로_6개의_WinningResult를_초기화한다() {
        assertThat(winningResults.getWinningResults().size())
                .isEqualTo(6);
    }

    @Test
    void 등수에_해당하는_당첨로또_개수를_1_증가시킨다() {
        winningResults.add(WinningRank.FIRST);
        winningResults.add(WinningRank.FIRST);
        winningResults.add(WinningRank.FIRST);

        assertThat(winningResults.findLottoAmountByRank(WinningRank.FIRST))
                .isEqualTo(3);
    }
}
