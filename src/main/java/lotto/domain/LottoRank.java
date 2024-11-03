package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    NONE(0, false, 0, "0"),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원) -"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원) -"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원) -"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) -"),
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) -");

    private final int matchCount;
    private final boolean bonusRequired;
    private final int prize;
    private final String prizeStr;

    LottoRank(int matchCount, boolean bonusRequired, int prize, String prizeStr){
        this.matchCount = matchCount;
        this.bonusRequired = bonusRequired;
        this.prize = prize;
        this.prizeStr = prizeStr;
    }

    public int getPrize(){
        return prize;
    }

    public int getMatchCount(){
        return matchCount;
    }

    public String getPrizeStr(){
        return prizeStr;
    }

    public static LottoRank getRank(Lotto lotto, Lotto winningLotto, int bonusNumber){
        int matchCount = lotto.countMatchedNumbers(winningLotto);
        boolean bonusMatched = lotto.containsNumber(bonusNumber);
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank.bonusRequired == bonusMatched)
                .findFirst()
                .orElse(NONE);
    }
}
