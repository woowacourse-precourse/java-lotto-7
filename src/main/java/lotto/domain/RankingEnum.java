package lotto.domain;

import java.util.Collections;
import java.util.List;

public enum RankingEnum {


    TREE_MATCH("3개 일치 (5,000원)", 5_000),
    FOUR_MATCH("4개 일치 (50,000원)", 50_000),
    FIVE_MATCH("5개 일치 (1,500,000원)", 1_500_000),
    BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    SIX_MATCH("6개 일치 (2,000,000,000원)", 2_000_000_000);

    RankingEnum(String message, int prize) {
        this.message = message;
        this.prize = prize;

    }

    private String message;
    private int prize;

    public String getMessage() {
        return message;
    }

    public int getPrize() {
        return prize;
    }

}
