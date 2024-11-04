package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.constant.Constant;
import lotto.domain.Amount;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.ProfitRate;
import lotto.domain.Rank;
import lotto.domain.RankCount;

public class LottoService {
    private static final int MIN_RANK_COUNT = 3;
    private static final String RANK_NAME_PREFIX = "MATCHES_";
    private static final String RANK_BONUS_MATCH_NAME_SUFFIX = "_BONUS_MATCH";

    public Lottos issueLottos(Amount amount) {
        return new Lottos(IntStream.range(0, getIssuedCount(amount))
                .mapToObj(i -> issueLotto())
                .collect(Collectors.toList()));
    }

    public RankCount getRankCount(Lottos issuedLottos, Lotto winningLotto, Bonus bonusNumber) {
        RankCount rankCount = new RankCount();
        for (Lotto issuedLotto : issuedLottos.getLottos()) {
            int matchCount = getMatchCount(issuedLotto, winningLotto);
            boolean isBonusMatch = isBonusMatch(issuedLotto, bonusNumber);
            calculateRankCount(rankCount, matchCount, isBonusMatch);
        }
        return rankCount;
    }

    public ProfitRate getProfitRate(Amount amount, RankCount rankCount) {
        return ProfitRate.of(amount.getAmount(), getTotalProfit(rankCount.getRankCount()));
    }

    private int getIssuedCount(Amount amount) {
        return amount.getAmount() / Constant.AMOUNT_UNIT;
    }

    private Lotto issueLotto() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(
                Constant.MIN_LOTTO_NUMBER, Constant.MAX_LOTTO_NUMBER, Constant.LOTTO_NUMBER_COUNT
        ).stream().sorted().toList();
        return new Lotto(lotto);
    }

    private int getMatchCount(Lotto issuedLotto, Lotto winningLotto) {
        return (int) issuedLotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }

    private boolean isBonusMatch(Lotto issuedLotto, Bonus bonusNumber) {
        return issuedLotto.getNumbers().contains(bonusNumber.getNumber());
    }

    private void calculateRankCount(RankCount rankCount, int matchCount, boolean isBonusMatch) {
        if (matchCount < MIN_RANK_COUNT) {
            return;
        }
        String rankName = getRankName(matchCount, isBonusMatch);
        rankCount.increaseCount(Rank.valueOf(rankName));
    }

    private String getRankName(int matchCount, boolean isBonusMatch) {
        String rankName = RANK_NAME_PREFIX + matchCount;
        if (matchCount == 5 && isBonusMatch) {
            rankName += RANK_BONUS_MATCH_NAME_SUFFIX;
        }
        return rankName;
    }

    private int getTotalProfit(Map<Rank, Integer> rankCount) {
        int totalPrize = 0;
        for (Entry<Rank, Integer> entry : rankCount.entrySet()) {
            Rank rank = entry.getKey();
            Integer count = entry.getValue();
            totalPrize += rank.calculatePrize(count);
        }
        return totalPrize;
    }
}
