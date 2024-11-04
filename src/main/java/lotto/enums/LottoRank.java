package lotto.enums;

import java.util.List;
import lotto.model.vo.MatchResult;
import lotto.model.vo.Money;

public enum LottoRank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    LOSS(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final Money prize;

    LottoRank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = new Money(prize);
    }

    public static LottoRank determineLottoRank(MatchResult matchResult) {
        for (LottoRank lottoRank : values()) {
            if (lottoRank.matchCount == matchResult.matchCount() && determineBonusValid(lottoRank, matchResult)) {
                return lottoRank;
            }
        }
        return LOSS;
    }

    private static boolean determineBonusValid(LottoRank lottoRank, MatchResult matchResult) {
        if (lottoRank.matchBonus) {
            return matchResult.matchBonus();
        }
        return true;
    }

    @Override
    public String toString() {
        String toString =
                matchCount
                        + "개 일치";
        if (matchBonus) {
            toString += ", 보너스 볼 일치";
        }
        toString += " ("
                + prize.toString()
                + ") - ";
        return toString;
    }

    public static List<LottoRank> getAllLottoRanks() {
        return List.of(LOSS, FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getPrize() {
        return prize.value();
    }
}
