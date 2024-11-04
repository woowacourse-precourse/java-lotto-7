package lotto;

public enum WinnerPrice {

    //LottoView 에서 출력할 떄 이용할 enum 클래스
    FIRST(6, 2000000000, 4, false, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30000000, 3, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1500000, 2, false, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50000, 1, false, "4개 일치 (50,000원) - "),
    FIFTH(3, 5000, 0, false, "3개 일치 (5,000원) - ");


    private final int countMatch;
    private final int prize;
    private final int winnerStatisticsIndex;
    private final boolean isBonusNumberMatch;
    private final String outputMessage;

    WinnerPrice(int countMatch, int prize, int winnerStatisticsIndex, boolean isBonusNumberMatch, String outputMessage) {
        this.countMatch = countMatch;
        this.prize = prize;
        this.winnerStatisticsIndex = winnerStatisticsIndex;
        this.isBonusNumberMatch = isBonusNumberMatch;
        this.outputMessage = outputMessage;
    }

    public int getCountMatch() {
        return this.countMatch;
    }

    public int getPrize() {
        return this.prize;
    }

    public String getOutputMessage() {
        return this.outputMessage;
    }

    public int getWinningStatisticsIndex() {
        return this.winnerStatisticsIndex;
    }

    public boolean getIsBonusNumberMatch() {
        return this.isBonusNumberMatch;
    }

    public static int getWinnerStatisticsIndexByCountMatch(int countMatch, boolean isBonusNumberMatch) {
        for (WinnerPrice winnerPrice : WinnerPrice.values()) {
            if (winnerPrice.getCountMatch() == countMatch && countMatch == 5 && isBonusNumberMatch) {
                return SECOND.getWinningStatisticsIndex();
            }

            if (winnerPrice.getCountMatch() == countMatch && !winnerPrice.getIsBonusNumberMatch()) {
                return winnerPrice.getWinningStatisticsIndex();
            }
        }

        return -1;

    }
}


