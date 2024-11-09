package lotto.domain.enums;

public enum Prize {
	FIRST(2000_000_000),
	SECOND(30_000_000),
	THIRD(1_500_000),
	FOURTH(50_000),
	FIFTH(5_000),
	NO_MATCH(0);

	private final int prize;

	Prize(int prize) {
		this.prize = prize;
	}

	public static Prize valueOf(int matchCount, boolean bonusMatch) {
		if (matchCount == 6)
			return FIRST;
		if (matchCount == 5 && bonusMatch)
			return SECOND;
		if (matchCount == 5)
			return THIRD;
		if (matchCount == 4)
			return FOURTH;
		if (matchCount == 3)
			return FIFTH;
		return NO_MATCH;
	}

	public int getPrize() {
		return prize;
	}
}
