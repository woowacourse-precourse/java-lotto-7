package lotto.model.lotto.winningResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.lotto.winningResult.rank.Rank;

public class WinningResults {
    private final List<WinningResult> winningResults;

    public WinningResults() {
        this.winningResults = initializeWinningResults();
    }

    private List<WinningResult> initializeWinningResults() {
        List<WinningResult> winningResults = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            winningResults.add(new WinningResult(rank));
        }
        return winningResults;
    }

    public void add(Rank rank) {
        for (WinningResult winningResult : winningResults) {
            if (winningResult.correspondsTo(rank)) {
                winningResult.addLottoAmount();
            }
        }
    }

    public int findLottoAmountByRank(Rank rank) {
        for (WinningResult winningResult : winningResults) {
            if (winningResult.correspondsTo(rank)) {
                return winningResult.getWinningLottoAmount();
            }
        }
        throw new IllegalStateException("Can't find correct such WinningRank");
    }

    public List<WinningResult> getWinningResults() {
        return Collections.unmodifiableList(winningResults);
    }
}
