package lotto.domain.lottoMatchChecker;

import java.util.HashMap;
import java.util.List;
import lotto.dto.Lotto;
import lotto.dto.WinningLotto;
import lotto.utils.LottoMatchStatus;

public class DefaultLottoMatchChecker implements LottoMatchChecker{
    private HashMap<LottoMatchStatus, Integer> lottoResult;

    @Override
    public HashMap<LottoMatchStatus, Integer> countMatchingNumbers(WinningLotto winningLotto, List<Lotto> lottos) {
        lottoResult = new HashMap<>();

        for(Lotto lotto : lottos){
            LottoMatchStatus matchStatus = checkMatchStatus(winningLotto, lotto);
            if (matchStatus != null) {
                lottoResult.merge(matchStatus, 1, Integer::sum);
            }
        }

        return lottoResult;
    }

    private LottoMatchStatus checkMatchStatus(WinningLotto winningLotto, Lotto lotto){
        int count = lotto.countMatchingNumbers(winningLotto);
        boolean bonus = lotto.isMatchBonus(winningLotto);

        return getMatchStatus(count, bonus);
    }

    private LottoMatchStatus getMatchStatus(int count, boolean bonus){
        if (count == 3) return LottoMatchStatus.THREE_MATCH_RESULT;

        if (count == 4) return LottoMatchStatus.FOUR_MATCH_RESULT;

        if (count == 5) return LottoMatchStatus.FIVE_MATCH_RESULT;

        if (bonus && count == 5) return LottoMatchStatus.FIVE_MATCH_WITH_BONUS_RESULT;

        if (count == 6) return LottoMatchStatus.SIX_MATCH_RESULT;

        return null;
    }
}


