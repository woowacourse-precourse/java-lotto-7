package lotto.winner;

import java.util.Arrays;
import java.util.List;
import lotto.lotto.Lotto;
import lotto.lotto.LottoWinning;

public class WinnerService {

    private final Winner winner;

    public WinnerService(Winner winner) {
        this.winner = winner;
    }

    public void announceWinner(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int matchedCount = winner.determineLottoRank(lotto);
            incrementMatchedCount(matchedCount);
        }
    }

    private static void incrementMatchedCount(int matchedCount) {
        Arrays.stream(LottoWinning.values())
                .filter(winning -> winning.getMatchedCount() == matchedCount)
                .findFirst()
                .ifPresent(LottoWinning::incrementCount);
    }

}
