package lotto.domain.enums;

import java.util.Optional;

public enum Rank {

	FIFTH(3, 5_000),
	FOURTH(4, 50_000),
	THIRD(5, 1_500_000),
	SECOND(5, 30_000_000),
	FIRST(6, 2_000_000_000),
	;

	Rank(int matchCount, int prizeMoney) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
	}

	private final int matchCount;
	private final int prizeMoney;

	public static Optional<Rank> judgeBy(int winCount, boolean isBonusNumberWin) {
		if (winCount == FIRST.matchCount) {
			return Optional.of(Rank.FIRST);
		} else if (winCount == SECOND.matchCount && isBonusNumberWin) {
			return Optional.of(Rank.SECOND);
		} else if (winCount == THIRD.matchCount) {
			return Optional.of(Rank.THIRD);
		} else if (winCount == FOURTH.matchCount) {
			return Optional.of(Rank.FOURTH);
		} else if (winCount == FIFTH.matchCount) {
			return Optional.of(Rank.FIFTH);
		}

		return Optional.empty();
	}
}
