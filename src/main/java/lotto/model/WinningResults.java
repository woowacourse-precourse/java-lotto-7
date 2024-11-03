package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningResults{
    private final List<WinningResult> winningResults;

    public WinningResults() {
        this.winningResults = initializeWinningResults();
    }

    private List<WinningResult> initializeWinningResults() {
        List<WinningResult> winningResults = new ArrayList<>();
        for (WinningRank winningRank : WinningRank.values()) {
            winningResults.add(new WinningResult(winningRank));
        }
        return winningResults;
    }

    public void add(WinningRank winningRank) {
        for (WinningResult winningResult : winningResults) {
            if (winningResult.correspondsTo(winningRank)) {
                winningResult.addLottoAmount();
            }
        }
    }

    public int findLottoAmountByRank(WinningRank winningRank) {
        for (WinningResult winningResult : winningResults) {
            if (winningResult.correspondsTo(winningRank)) {
                return winningResult.getWinningLottoAmount();
            }
        }
        throw new IllegalStateException("Can't find correct such WinningRank");
    }

    public List<WinningResult> getWinningResults() {
        return Collections.unmodifiableList(winningResults);
    }
}
