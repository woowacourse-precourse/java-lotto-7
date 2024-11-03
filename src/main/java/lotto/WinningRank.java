package lotto;

public enum WinningRank {
	 	FIRST(3, 5_000, "3개 일치"),
	    SECOND(4, 50_000, "4개 일치"),
	    THIRD(5, 1_500_000, "5개 일치"),
	    FOURTH(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
	    FIFTH(6, 2_000_000_000, "6개 일치"),
	    NONE(0, 0, "미당첨");

	    private final int matchCount;
	    private final long prize;
	    private final String description;

	    WinningRank(int matchCount, long prize, String description) {
	        this.matchCount = matchCount;
	        this.prize = prize;
	        this.description = description;
	    }

	    public static WinningRank calculate(int matchCount, boolean matchBonus) {
	        if (matchCount == 3) {
	            return FIRST;
	        }
	        if (matchCount == 4) {
	            return SECOND;
	        }
	        if (matchCount == 5) {
	            return THIRD;
	        }
	        if (matchCount == 5 && matchBonus) {
	            return FOURTH;
	        }
	        if (matchCount == 6) {
	            return FIFTH;
	        }
	        return NONE;
	    }

	    public long getPrize() {
	        return prize;
	    }

	    public String getDescription() {
	        return description;
	    }

}
