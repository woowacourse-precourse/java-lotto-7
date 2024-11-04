package lotto.model;

import lotto.common.Prompts;

public enum LottoRank {
    FIRST(6, false, Prompts.OUTPUT_FIRST_LOTTO_PROMPT),
    SECOND(5, false, Prompts.OUTPUT_SECOND_LOTTO_PROMPT),
    THIRD(5, false, Prompts.OUTPUT_THIRD_LOTTO_PROMPT),
    FOURTH(4, false, Prompts.OUTPUT_FOURTH_LOTTO_PROMPT),
    FIFTH(3, false, Prompts.OUTPUT_FIFTH_LOTTO_PROMPT);

    private final int matchCount;
    private final boolean matchBonus;
    private final String message;

    LottoRank(int matchCount, boolean matchBonus, String message) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.message = message;
    }

    public LottoRank lottoResult(int matchCount, boolean matchBonus) {
        for (LottoRank lottoRank : values()) {
            if (lottoRank.matchCount == matchCount && lottoRank.matchBonus == matchBonus) {
                return lottoRank;
            }
        }
        return null;
    }
}
