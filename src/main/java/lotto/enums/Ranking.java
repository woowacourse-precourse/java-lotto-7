package lotto.enums;

public enum Ranking {
    MISS(0, 0, ""),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "), // 5등
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "), // 4등
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "), // 3등
    SECOND(7, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), // 2등
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "); // 1등
    Ranking(int countOfMatch, int winningAmount, String message) {
        this.countOfMatch = countOfMatch;
        this.winningAmount = winningAmount;
        this.message = message;
    }
    private int countOfMatch;
    private int winningAmount;
    private String message;

    public static Ranking valueOf(int countOfMatch){
        for (Ranking rank : values()){
            if (rank.getCountOfMatch() == countOfMatch) {
                return rank;
            }
        }
        return MISS;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public String getMessage() {
        return message;
    }
}
