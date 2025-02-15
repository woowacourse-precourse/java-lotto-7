package lotto.model;

import lotto.common.Constants;
import lotto.common.Prompts;

public enum LottoRank {
    FIRST(6, false, Prompts.OUTPUT_FIRST_LOTTO_PROMPT, Constants.FIRST_PRIZE),
    SECOND(5, false, Prompts.OUTPUT_SECOND_LOTTO_PROMPT, Constants.SECOND_PRIZE),
    THIRD(5, false, Prompts.OUTPUT_THIRD_LOTTO_PROMPT, Constants.THIRD_PRIZE),
    FOURTH(4, false, Prompts.OUTPUT_FOURTH_LOTTO_PROMPT, Constants.FOURTH_PRIZE),
    FIFTH(3, false, Prompts.OUTPUT_FIFTH_LOTTO_PROMPT, Constants.FIFTH_PRIZE);

    private final int matchCount;
    private final boolean matchBonus;
    private final String message;
    private final int prize;

    LottoRank(int matchCount, boolean matchBonus, String message, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.message = message;
        this.prize = prize;
    }

    public String getMessage() {
        return message;
    }

    public int getPrize() {
        return prize;
    }


    public static LottoRank lottoResult(int matchCount, boolean matchBonus) {
        for (LottoRank lottoRank : values()) {
            if (lottoRank.matchCount == matchCount && lottoRank.matchBonus == matchBonus) {
                return lottoRank;
            }
        }
        return null;
    }
}
