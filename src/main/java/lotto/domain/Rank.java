package lotto.domain;

import lotto.util.Constant;

public enum Rank {

    RANK_LOSE(0, Constant.RANK_LOSE_PROMPT),
    RANK_5(5_000, Constant.RANK_5_PROMPT),
    RANK_4(50_000, Constant.RANK_4_PROMPT),
    RANK_3(1_500_000, Constant.RANK_3_PROMPT),
    RANK_2(30_000_000, Constant.RANK_2_PROMPT),
    RANK_1(2_000_000_000, Constant.RANK_1_PROMPT);

    private final int prize;
    private final String message;

    Rank(int prize, String message) {
        this.prize = prize;
        this.message = message + Constant.RANK_PROMPT_SUFFIX;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }

}
