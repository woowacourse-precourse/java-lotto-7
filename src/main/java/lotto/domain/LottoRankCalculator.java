package lotto.domain;

import lotto.domain.CustomLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoRankCalculator {

    public static void calculateLottoRank(LottoGame lottoGame){
        for (Lotto lotto : lottoGame.getLottos()) {
            int matchCount = getMatchCount(lotto, lottoGame.getCustomLotto());
            if(matchCount<3){
                continue;
            }
            boolean isBonus = false;
            isBonus = isBonusMatch(lottoGame, lotto, matchCount, isBonus);
            updateRank(lottoGame, matchCount, isBonus);
        }
    }

    private static boolean isBonusMatch(LottoGame lottoGame, Lotto lotto, int matchCount, boolean isBonusMatch) {
        if (matchCount == 5) {
            int bonus = lottoGame.getCustomLotto().getBonus();
            isBonusMatch = lotto.getNumbers().contains(bonus);
        }
        return isBonusMatch;
    }

    private static void updateRank(LottoGame lottoGame, int matchCount, boolean isBonusMatch) {
        if(isBonusMatch || matchCount == 6){
            matchCount++;
        }
        matchCount-=3;
        Integer update = lottoGame.getRank().get(matchCount)+1;
        lottoGame.getRank().set(matchCount,update);
    }

    private static int getMatchCount(Lotto lotto, CustomLotto customLotto) {
        List<Integer> targetNumbers = lotto.getNumbers();
        List<Integer> compareNumbers = customLotto.getNumbers();

        Set<Integer> commonNumbers = new HashSet<>(targetNumbers);
        commonNumbers.retainAll(compareNumbers);

        return commonNumbers.size();
    }
}
