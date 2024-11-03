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
import lotto.domain.ProfitRate;
import lotto.domain.WinningCount;

public class LottoService {

    public Lottos issueLottos(Amount amount) {
        return new Lottos(IntStream.range(0, getIssuedCount(amount))
                .mapToObj(i -> issueLotto())
                .collect(Collectors.toList()));
    }

    public WinningCount getWinningCount(Lottos issuedLottos, Lotto winningLotto, Bonus bonusNumber) {
        WinningCount winningCount = new WinningCount();
        for (Lotto issuedLotto : issuedLottos.getLottos()) {
            int matchCount = getMatchCount(issuedLotto, winningLotto);
            boolean isBonusMatch = isBonusMatch(issuedLotto, bonusNumber);
            calculateWinningCount(winningCount, matchCount, isBonusMatch);
        }
        return winningCount;
    }

    public ProfitRate getProfitRate(Amount amount, WinningCount winningCount) {
        return ProfitRate.of(amount.getAmount(), getTotalPrize(winningCount.getWinningCount()));
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

    private void calculateWinningCount(WinningCount winningCount, int matchCount, boolean isBonusMatch) {
        if (matchCount < Constant.MIN_PRIZE_COUNT) {
            return;
        }
        String prizeName = getPrizeName(matchCount, isBonusMatch);
        winningCount.increaseCount(Prize.valueOf(prizeName));
    }

    private String getPrizeName(int matchCount, boolean isBonusMatch) {
        String prizeName = Constant.PRIZE_NAME_PREFIX + matchCount;
        if (matchCount == 5 && isBonusMatch) {
            prizeName += Constant.PRIZE_BONUS_MATCH_NAME_SUFFIX;
        }
        return prizeName;
    }

    private int getTotalPrize(Map<Prize, Integer> winningCount) {
        int totalPrize = 0;
        for (Entry<Prize, Integer> entry : winningCount.entrySet()) {
            Prize prize = entry.getKey();
            Integer count = entry.getValue();
            totalPrize += prize.calculate(count);
        }
        return totalPrize;
    }
}
