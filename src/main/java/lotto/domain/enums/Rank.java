package lotto.domain.enums;

public enum Rank {

	NONE(0, 0),
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

	public static Rank judgeBy(int winCount, boolean isBonusNumberWin) {
		if (winCount == FIRST.matchCount) {
			return Rank.FIRST;
		} else if (winCount == SECOND.matchCount && isBonusNumberWin) {
			return Rank.SECOND;
		} else if (winCount == THIRD.matchCount) {
			return Rank.THIRD;
		} else if (winCount == FOURTH.matchCount) {
			return Rank.FOURTH;
		}
		else if(winCount == FIFTH.matchCount){
			return Rank.FIFTH;
		}

		return Rank.NONE;
	}
}
