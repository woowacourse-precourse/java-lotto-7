package lotto.domain;

import java.util.Arrays;

public enum BonusExistence {
    HAVE_BONUS(5,true),
    NO_BONUS(5,false),
    IRRELEVANT(0,false);

    int hits;
    boolean haveBonus;

    BonusExistence(int hits, boolean haveBonus) {
        this.hits=hits;
        this.haveBonus=haveBonus;
    }

    static BonusExistence of(int hits, boolean haveBonus){
        return Arrays.stream(values())
                .filter(bonus ->bonus.matches(hits, haveBonus))
                .findFirst().orElse(IRRELEVANT);
    }

    private boolean matches(int hits, boolean haveBonus) {
       return (this.hits==hits && this.haveBonus==haveBonus);
    }
}
