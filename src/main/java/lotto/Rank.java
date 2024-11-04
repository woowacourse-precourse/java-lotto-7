package lotto;

/**
 * 1등: 6개 번호 일치 / 2,000,000,000원
 * 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
 * 3등: 5개 번호 일치 / 1,500,000원
 * 4등: 4개 번호 일치 / 50,000원
 * 5등: 3개 번호 일치 / 5,000원
 * 꽝 : 2개이하로 일치
 */
public enum Rank {
    //등수(일치하는 번호 개수,금액,보너스 일치 여부)
    FIRST(6,2_000_000_000,true),
    SECOND(5,30_000_000,true),
    THIRD(5,1_500_000,false),
    FOURTH(4,50_000,false),
    FIFTH(3,5000,false);

    private final int matchNumbers;
    private final int winningPrice;
    private final Boolean isBonusMatch;

    Rank(int matchNumbers, int winningPrice, Boolean isBonusMatch) {
        this.matchNumbers = matchNumbers;
        this.winningPrice = winningPrice;
        this.isBonusMatch = isBonusMatch;
    }

    public int getMatchNumbers() {
        return matchNumbers;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public Boolean getIsBonusMatch() {
        return isBonusMatch;
    }

    public static Rank findByAttributes(int count, boolean isMatch) {
        for (Rank rank : Rank.values()) {
            if (rank.getMatchNumbers() == count && rank.getIsBonusMatch() == isMatch) {
                return rank;
            }
        }
        throw new IllegalArgumentException("일치하는 등수가 없습니다");
    }
}
