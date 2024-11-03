package lotto.model;

public enum Winning {
	NONE(0, 0, false),
	FIFTH(3, 5000, false),
	FOURTH(4, 50000, false),
	THIRD(5, 1500000, false),
	SECOND(5, 30000000, true),
	FIRST(6, 2000000000, false);

	private final int count;
	private final int prize;
	private final boolean hasBonusNumber;

	Winning(int count, int prize, boolean hasBonusNumber) {
		this.count = count;
		this.prize = prize;
		this.hasBonusNumber = hasBonusNumber;
	}
}
