package lotto.model;

public enum Result {
    FIRST(6,2_000_000_000, "6개 일치"),
    SECOND(6,30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5,1_500_000, "5개 일치"),
    FOURTH(4,50_000, "4개 일치"),
    FIFTH(3,5_000, "3개 일치"),
    ELSE(0,0, "0개 일치");
    Result(int matchCount, int winningAmount, String message) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.message = message;
    }
    public final int matchCount;
    public final int winningAmount;
    public final String message;

    public static Result valueOf(int correctCount, int bonusCount) {
        if(correctCount == FIRST.matchCount) {
            return FIRST;
        }
        if(correctCount + bonusCount == FIRST.matchCount) {
            return SECOND;
        }
        for(Result result : values()) {
            if(correctCount + bonusCount == result.matchCount) {
                return result;
            }
        }
        return ELSE;
    }
}
