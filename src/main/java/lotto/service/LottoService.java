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
import lotto.domain.Prize;
import lotto.domain.PrizeCount;
import lotto.domain.ProfitRate;

public class LottoService {
    private static final int MIN_PRIZE_COUNT = 3;
    private static final String PRIZE_NAME_PREFIX = "MATCHES_";
    private static final String PRIZE_BONUS_MATCH_NAME_SUFFIX = "_BONUS_MATCH";

    public Lottos issueLottos(Amount amount) {
        return new Lottos(IntStream.range(0, getIssuedCount(amount))
                .mapToObj(i -> issueLotto())
                .collect(Collectors.toList()));
    }

    public PrizeCount getPrizeCount(Lottos issuedLottos, Lotto winningLotto, Bonus bonusNumber) {
        PrizeCount prizeCount = new PrizeCount();
        for (Lotto issuedLotto : issuedLottos.getLottos()) {
            int matchCount = getMatchCount(issuedLotto, winningLotto);
            boolean isBonusMatch = isBonusMatch(issuedLotto, bonusNumber);
            calculatePrizeCount(prizeCount, matchCount, isBonusMatch);
        }
        return prizeCount;
    }

    public ProfitRate getProfitRate(Amount amount, PrizeCount prizeCount) {
        return ProfitRate.of(amount.getAmount(), getTotalPrize(prizeCount.getPrizeCount()));
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

    private void calculatePrizeCount(PrizeCount prizeCount, int matchCount, boolean isBonusMatch) {
        if (matchCount < MIN_PRIZE_COUNT) {
            return;
        }
        String prizeName = getPrizeName(matchCount, isBonusMatch);
        prizeCount.increaseCount(Prize.valueOf(prizeName));
    }

    private String getPrizeName(int matchCount, boolean isBonusMatch) {
        String prizeName = PRIZE_NAME_PREFIX + matchCount;
        if (matchCount == 5 && isBonusMatch) {
            prizeName += PRIZE_BONUS_MATCH_NAME_SUFFIX;
        }
        return prizeName;
    }

    private int getTotalPrize(Map<Prize, Integer> prizeCount) {
        int totalPrize = 0;
        for (Entry<Prize, Integer> entry : prizeCount.entrySet()) {
            Prize prize = entry.getKey();
            Integer count = entry.getValue();
            totalPrize += prize.calculate(count);
        }
        return totalPrize;
    }
}
