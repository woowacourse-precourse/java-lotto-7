package lotto.domain;

import lotto.constants.Constants;

import static lotto.constants.Constants.*;

public enum LottoRank {
	FIRST(6, false, FIRST_PRIZE, MATCH_SIX_MESSAGE),
	SECOND(5, true, SECOND_PRIZE, MATCH_FIVE_WITH_BONUS_MESSAGE),
	THIRD(5, false, THIRD_PRIZE, MATCH_FIVE_MESSAGE),
	FOURTH(4, false, FOURTH_PRIZE, MATCH_FOUR_MESSAGE),
	FIFTH(3, false, FIFTH_PRIZE, MATCH_THREE_MESSAGE),
	NONE(0, false, 0, "");

	private final int matchCount;
	private final boolean matchBonus;
	private final int prize;
	private final String message;

	LottoRank(int matchCount, boolean matchBonus, int prize, String message) {
		this.matchCount = matchCount;
		this.matchBonus = matchBonus;
		this.prize = prize;
		this.message = message;
	}
	public static LottoRank valueOf(int matchCount, boolean matchBonus) {
		for (LottoRank rank : values()) {
			if (rank.matchCount == matchCount && rank.matchBonus == matchBonus) {
				return rank;
			}
		}
		return NONE;
	}

	public int getPrize() {
		return prize;
	}
}
