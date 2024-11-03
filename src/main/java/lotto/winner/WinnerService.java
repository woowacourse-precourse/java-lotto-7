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

            if (!bonusNumberCountDetermine(lotto, matchedCount)) {
                incrementMatchedCount(matchedCount);
            }
        }
    }

    private boolean bonusNumberCountDetermine(Lotto lotto, int matchedCount) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int bonusNumber = winner.getBonusNumber();

        if (matchedCount == 5 && lottoNumbers.contains(bonusNumber)) {
            LottoWinning.FIVE_MATCH_WITH_BONUS_NUMBER.incrementCount();
            return true;
        }

        return false;
    }

    private void incrementMatchedCount(int matchedCount) {
        Arrays.stream(LottoWinning.values())
                .filter(winning -> winning.getMatchedCount() == matchedCount)
                .findFirst()
                .ifPresent(LottoWinning::incrementCount);
    }

}
