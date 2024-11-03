package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.constant.Constant;
import lotto.domain.Amount;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Profit;
import lotto.domain.ProfitRate;
import lotto.domain.WinningCount;

public class LottoService {

    public Lottos issueLottos(Amount amount) {
        List<Lotto> lottos = IntStream.range(0, getIssuedCount(amount))
                .mapToObj(i -> issueLotto())
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    public WinningCount getWinningCount(Lottos issuedLottos, Lotto winningLotto, Bonus bonusNumber) {
        WinningCount winningCount = new WinningCount();
        for (Lotto issuedLotto : issuedLottos.getLottos()) {
            boolean isBonusMatch = isBonusMatch(issuedLotto, bonusNumber);
            int matchCount = (int) issuedLotto.getNumbers().stream()
                    .filter(winningLotto.getNumbers()::contains)
                    .count();
            calculateWinningCount(winningCount, matchCount, isBonusMatch);
        }
        return winningCount;
    }

    public ProfitRate getProfitRate(Amount amount, WinningCount winningCount) {
        return ProfitRate.of(amount.getAmount(), getTotalProfit(winningCount.getWinningCount()));
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

    private boolean isBonusMatch(Lotto issuedLotto, Bonus bonusNumber) {
        return issuedLotto.getNumbers().contains(bonusNumber.getNumber());
    }

    private void calculateWinningCount(WinningCount winningCount, int matchCount, boolean isBonusMatch) {
        if (matchCount < 3) {
            return;
        }
        String key = Constant.WINNING_COUNT_KEY_PREFIX + matchCount;
        if (matchCount == 5 && isBonusMatch) {
            key += Constant.WINNING_COUNT_BONUS_MATCH_KEY_SUFFIX;
        }
        winningCount.increaseCount(key);
    }

    private int getTotalProfit(Map<String, Integer> winningCount) {
        return Arrays.stream(Profit.values())
                .mapToInt(proceeds -> proceeds.calculate(winningCount.get(proceeds.name())))
                .sum();
    }
}
