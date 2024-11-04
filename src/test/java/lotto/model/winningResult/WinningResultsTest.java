package lotto.model.winningResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.lotto.winningResult.WinningResult;
import lotto.model.lotto.winningResult.WinningResults;
import lotto.model.lotto.winningResult.rank.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningResultsTest {
    private final WinningResults defaultWinningResults = new WinningResults();

    @Test
    @DisplayName("[success] 등수 별로 6개의 WinningResult 객체를 리스트에 담아 초기화한다.")
    void initializeWinningResultListByWinningRank() {
        assertThat(defaultWinningResults.getWinningResults().size())
                .isEqualTo(6);
    }

    @Test
    @DisplayName("[success] 특정 등수에 해당하는 당첨 로또 개수를 1 증가시킨다.")
    void increaseLottoAmountOfWinningResultByWinningRank() {
        defaultWinningResults.add(Rank.FIRST);
        defaultWinningResults.add(Rank.FIRST);
        defaultWinningResults.add(Rank.FIRST);

        assertThat(defaultWinningResults.findLottoAmountByRank(Rank.FIRST))
                .isEqualTo(3);
    }

    @Test
    @DisplayName("[fail] getter로 받은 당첨결과 리스트를 수정하는 경우 예외가 발생한다.")
    void fail_IfModifyWinningResultList() {
        WinningResults winningResults = new WinningResults();
        List<WinningResult> winningResultList = winningResults.getWinningResults();

        assertThatThrownBy(() -> winningResultList.add(new WinningResult(Rank.FAIL)))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> winningResultList.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
