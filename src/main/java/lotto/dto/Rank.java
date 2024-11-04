package lotto.dto;

public enum Rank {
    FIRST(2000000000,6,"6개 일치 (2,000,000,000원)"),
    SECOND(30000000,5,"5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(1500000,5,"5개 일치 (1,500,000원)"),
    FOURTH(50000,4,"4개 일치 (50,000원)"),
    FIFTH(5000,3,"3개 일치 (5,000원)"),
    NONE(0,0,"당첨되지 않음");

    private final int prize;   // 상금을 나타내는 필드
    private final int match_count;
    private final String message;

    Rank(int prize,int match_count,String message) {
        this.prize = prize;
        this.match_count=match_count;
        this.message=message;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }

    public static Rank valueOfMatchCount(int count, boolean bonusMatched) {
        if (count == Rank.FIRST.match_count) return FIRST;
        if (count == Rank.SECOND.match_count && bonusMatched) return SECOND;
        if (count == Rank.THIRD.match_count) return THIRD;
        if (count == Rank.FOURTH.match_count) return FOURTH;
        if (count == Rank.FIFTH.match_count) return FIFTH;
        return NONE;
    }
}
