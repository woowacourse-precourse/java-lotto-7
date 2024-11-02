package lotto.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum Rank {
    UNDER_TWO_HIT(0, BonusExistence.IRRELEVANT, 0,
            (cnt)->"") ,
    THREE_HIT(3, BonusExistence.IRRELEVANT, 5000L,
            (cnt)-> String.join(cnt.toString(),"3개 일치 (5,000원) - ","개")),
    FOUR_HIT(4, BonusExistence.IRRELEVANT, 50000L,
            (cnt)-> String.join(cnt.toString(),"4개 일치 (50,000원) - ","개")),
    FIVE_HIT_WITHOUT_BONUS(5, BonusExistence.NO_BONUS, 1500000L,
            (cnt)-> String.join(cnt.toString(),"5개 일치 (1,500,000원) - ","개")),
    FIVE_HIT_WITH_BONUS(5, BonusExistence.HAVE_BONUS, 30000000L,
            (cnt)-> String.join(cnt.toString(),"5개 일치, 보너스 볼 일치 (30,000,000원) - ","개")),
    SIX_HIT(6, BonusExistence.IRRELEVANT, 2000000000L,
            (cnt)-> String.join(cnt.toString(),"6개 일치 (2,000,000,000원) - ","개"));

    private int hits;
    private BonusExistence bonusExistence;
    private long prizeAmount;
    Function<String,String> showHitState;

    Rank(int hits, BonusExistence haveBonus, long prizeAmount,Function sp) {
        this.hits = hits;
        this.bonusExistence = haveBonus;
        this.prizeAmount = prizeAmount;
        this.showHitState =sp;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

    public static Rank of(int hits, BonusExistence bonusExistence) {
        return Arrays.stream(values())
                .filter(rank -> rank.matches(hits, bonusExistence))
                .findFirst()
                .orElse(UNDER_TWO_HIT);
    }

    private boolean matches(long hits, BonusExistence bonusExistence) {
        return this.hits == hits && this.bonusExistence == bonusExistence;
    }

    public  String getInfo(int cnt) {
        return showHitState.apply(String.valueOf(cnt));
    }
}