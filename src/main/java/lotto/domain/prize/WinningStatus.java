package lotto.domain.prize;

public enum WinningStatus {

    first("6개 일치", 2000000000),
    second("5개 일치, 보너스 볼 일치", 30000000),
    third("5개 일치", 1500000),
    fourth("4개 일치", 50000),
    fifth("3개 일치", 5000),
    blank("꽝", 0);

    private String numberMatchInfo;
    private int winningMoney;

    WinningStatus(String numberMatchInfo, int winningMoney) {
        this.numberMatchInfo = numberMatchInfo;
        this.winningMoney = winningMoney;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
