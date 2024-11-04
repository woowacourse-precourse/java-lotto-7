package lotto.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Prize, Integer> lottoResult;

    public LottoResult() {
        lottoResult = new EnumMap<>(Prize.class);
        Arrays.stream(Prize.values())
                .forEach(prize -> lottoResult.put(prize, 0));
    }

    public void calculateResult(List<Lotto> lottos, WinningLotto winningLotto) {
        lottos.forEach(lotto -> {
            int matchCount = winningLotto.matchWinningNumber(lotto.getNumbers());
            boolean bonusMatch = winningLotto.matchBonusNumber(lotto.getNumbers());
            Prize prize = Prize.valueOf(matchCount, bonusMatch);
            lottoResult.put(prize, lottoResult.get(prize) + 1);
        });
    }

    public int getPrizeCount(Prize prize) {
        return lottoResult.get(prize);
    }

    public double calculateRateOfReturn(int price) {
        return Arrays.stream(Prize.values())
                .mapToDouble(prize -> prize.getPrizeMoney() * lottoResult.get(prize))
                .sum() / price * 100 ;
    }
}
