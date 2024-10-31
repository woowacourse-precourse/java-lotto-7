package lotto;

import java.util.Arrays;
import java.util.EnumMap;

public class WinningAnalyzer {

    private static final Long LOTTO_PRICE = 1_000L;
    private final WinningBalls winningBalls;
    private final BonusBall bonusBall;

    public WinningAnalyzer(WinningBalls winningBalls, BonusBall bonusBall) {
        this.winningBalls = winningBalls;
        this.bonusBall = bonusBall;
    }

    public Float calculateReturnRate(Lottos lottos) {
        EnumMap<Rank, Integer> result = getResult(lottos);
        Long winningAmount = Rank.calculateWinningAmount(result);
        long lottosPrice = lottos.getSize() * LOTTO_PRICE;
        return (Float.valueOf(winningAmount) / lottosPrice) * 100;
    }


    public EnumMap<Rank, Integer> getResult(Lottos lottos) {
        EnumMap<Rank, Integer> ranks = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(rank -> ranks.put(rank, 0));

        for (Lotto lotto : lottos.getLottos()) {
            int sameWinningCount = winningBalls.getSameNumberCount(lotto);
            int sameBonusCount = bonusBall.getSameNumberCount(lotto);
            Rank rank = Rank.valueOf(sameWinningCount, sameBonusCount);
            ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
        }
        return ranks;
    }
}
