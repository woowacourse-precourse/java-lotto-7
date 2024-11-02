package lotto;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int correctCount;
    private final long price;

    LottoRank(int correctCount, long price) {
        this.correctCount = correctCount;
        this.price = price;
    }

    public static LottoRank getRank(Lotto lotto, Lotto winner, Integer bonusBall) {
        return findByWinningCountAndBonusBall(lotto.winningCount(winner), lotto.isBonusBallMatch(bonusBall));
    }

    public static List<LottoRank> getRanks(List<Lotto> lottos, Lotto winner, Integer bonusBall) {
        return lottos.stream()
                .map(lotto -> LottoRank.getRank(lotto, winner, bonusBall))
                .toList();
    }

    public static LottoRank findByWinningCountAndBonusBall(int correctCount, boolean bonusBall) {
        LottoRank rottoRank = Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.correctCount == correctCount)
                .findAny()
                .orElse(null);

        if (rottoRank == LottoRank.THIRD && bonusBall) {
            return LottoRank.SECOND;
        }
        return rottoRank;
    }

    public String getCondition() {
        String condition = correctCount + "개 일치";

        if (this == SECOND) {
            condition += ", 보너스 볼 일치";
        }
        return condition;
    }

    public long getPrice() {
        return price;
    }
}
