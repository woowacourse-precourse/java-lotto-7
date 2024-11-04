package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class LottoPrizeResult {
    private final Map<LottoPrize, Integer> lottoPrizeResult;

    public LottoPrizeResult() {
        lottoPrizeResult = new EnumMap<LottoPrize, Integer>(LottoPrize.class);
        Arrays.stream(LottoPrize.values())
                .forEach(prize -> lottoPrizeResult.put(prize, 0));
    }

    public void calculatePrizeResult(WinningNumbers winningnumbers, Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            LottoPrize lottoPrize = LottoPrize.getLottoPrize(lotto.getMatchLottoNumber(winningnumbers),
                    lotto.isContain(winningnumbers.getBonusNumber()));
            increaseLottoPrizeCount(lottoPrize);
        }
    }

    private void increaseLottoPrizeCount(LottoPrize lottoPrize) {
        lottoPrizeResult.put(lottoPrize, lottoPrizeResult.get(lottoPrize) + 1);
    }

    public Integer getLottoPrizeCount(LottoPrize lottoPrize) {
        return lottoPrizeResult.get(lottoPrize);
    }
}
