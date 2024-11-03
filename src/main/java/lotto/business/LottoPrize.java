package lotto.business;

import java.text.DecimalFormat;
import java.util.List;
import lotto.lotto.Lotto;
import lotto.lotto.LottoResult;

public enum LottoPrize {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    NONE(0, 0, false),
    ;

    private final int reward;
    private final int countOfMatch;
    private final boolean matchBonus;

    LottoPrize(int reward, int countOfMatch, boolean matchBonus) {
        this.reward = reward;
        this.countOfMatch = countOfMatch;
        this.matchBonus = matchBonus;
    }

    public static LottoPrize from(Lotto lotto, LottoResult lottoResult) {
        for (LottoPrize prize : values()) {
            long countOfMatch = lottoResult.countMatch(lotto);
            boolean matchBonus = lottoResult.checkBonus(lotto);

            if (countOfMatch == prize.countOfMatch && matchBonus == prize.matchBonus) {
                return prize;
            }
        }
        return NONE;
    }

    public static List<LottoPrize> from(List<Lotto> lotteries, LottoResult lottoResult) {
        return lotteries.stream().map(lotto -> from(lotto, lottoResult)).toList();
    }

    public static int sumOfRewards(List<LottoPrize> prizes) {
        return prizes.stream()
                .mapToInt(prize -> prize.reward)
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(countOfMatch).append("개 일치");
        if (matchBonus) {
            sb.append(", 보너스 볼 일치");
        }
        DecimalFormat df = new DecimalFormat("#,###");
        sb.append(" (").append(df.format(reward)).append("원)");
        return sb.toString();
    }
}
