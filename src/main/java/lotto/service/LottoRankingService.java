package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.model.FirstRankLotto;
import lotto.model.Lotto;
import lotto.model.constant.LottoRank;

public class LottoRankingService {

    private static final Map<RankCondition, LottoRank> RANK_MAP = Map.of(
            new RankCondition(6, false), LottoRank.FIRST,
            new RankCondition(5, true), LottoRank.SECOND,
            new RankCondition(5, false), LottoRank.THIRD,
            new RankCondition(4, false), LottoRank.FOURTH,
            new RankCondition(3, false), LottoRank.FIFTH
    );

    public LottoRankingService() {
    }

    public LottoRank getRank(Lotto lotto, FirstRankLotto firstRankLotto) {
        int matchCount = calculateMatchCount(lotto, firstRankLotto);
        boolean bonusNumberMatched = checkBonusNumberMatch(lotto, firstRankLotto);

        RankCondition rankCondition = new RankCondition(matchCount, bonusNumberMatched);

        return RANK_MAP.getOrDefault(rankCondition, LottoRank.OTHERS);
    }

    private int calculateMatchCount(Lotto lotto, FirstRankLotto firstRankLotto) {
        int matchCount = 0;

        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> firstRankLottoNumbers = firstRankLotto.getNumbers();

        matchCount = (int) lottoNumbers.stream()
                .filter(firstRankLottoNumbers::contains)
                .count();

        return matchCount;
    }

    private boolean checkBonusNumberMatch(Lotto lotto, FirstRankLotto firstRankLotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int bonusNumber = firstRankLotto.getBonusNumber();

        return lottoNumbers.contains(bonusNumber);
    }

    private record RankCondition(int matchCount, boolean bonusMatch) {
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof RankCondition that)) {
                return false;
            }
            return matchCount == that.matchCount && bonusMatch == that.bonusMatch;
        }
    }
}
