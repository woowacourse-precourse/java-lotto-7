package lotto.model.winningResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.winnerRank.WinnerRank;

public class WinningResults{
    private final List<WinningResult> winningResults;

    public WinningResults() {
        this.winningResults = initializeWinningResults();
    }

    private List<WinningResult> initializeWinningResults() {
        List<WinningResult> winningResults = new ArrayList<>();
        for (WinnerRank winnerRank : WinnerRank.values()) {
            winningResults.add(new WinningResult(winnerRank));
        }
        return winningResults;
    }

    public void add(WinnerRank winnerRank) {
        for (WinningResult winningResult : winningResults) {
            if (winningResult.correspondsTo(winnerRank)) {
                winningResult.addLottoAmount();
            }
        }
    }

    public int findLottoAmountByRank(WinnerRank winnerRank) {
        for (WinningResult winningResult : winningResults) {
            if (winningResult.correspondsTo(winnerRank)) {
                return winningResult.getWinningLottoAmount();
            }
        }
        throw new IllegalStateException("Can't find correct such WinningRank");
    }

    public List<WinningResult> getWinningResults() {
        return Collections.unmodifiableList(winningResults);
    }
}
