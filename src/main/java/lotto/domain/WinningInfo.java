package lotto.domain;

public enum WinningInfo {
    FIRST_WINNER(6,"6개 일치 (2,000,000,000원)", 2_000_000_000),
    SECOND_WINNER(5,"5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    THIRD_WINNER(5,"5개 일치 (1,500,000원)", 1_500_000),
    FOURTH_WINNER(4,"4개 일치 (50,000원)", 50_000),
    FIFTH_WINNER(3,"3개 일치 (5,000원)", 5_000),
    UNDEFINED(-1, "undefined", 0),
    NOT_MATCH(0, "not match", 0);

    private final int match;
    private final String info;
    private final int winningAmount;


    WinningInfo(int match, String info, int winningAmount) {
        this.match = match;
        this.info = info;
        this.winningAmount = winningAmount;
    }

    public int getMatch() {
        return match;
    }

    public String getInfo() {
        return info;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public static WinningInfo getWinningInfo(int count) {
        for (WinningInfo winningInfo : WinningInfo.values()) {
            if (count == 5) {
                return UNDEFINED;
            }
            if (winningInfo.getMatch() == count) {
                return winningInfo;
            }
        }
        return NOT_MATCH;
    }
}
