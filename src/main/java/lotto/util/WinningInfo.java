package lotto.util;

import java.util.Arrays;

public enum WinningInfo {
    NONE(0, "", 0),
    SAME3(3, "3개 일치 (5,000원) - %d개\n", 5_000),
    SAME4(4, "4개 일치 (50,000원) - %d개\n", 50_000),
    SAME5(5, "5개 일치 (1,500,000원) - %d개\n", 1_500_000),
    SAME5_BONUS(5.5, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", 30_000_000),
    SAME6(6, "6개 일치 (2,000,000,000원) - %d개\n", 2_000_000_000);

    private final double countOfSameNumber;
    private final String infoMessage;
    private final int returnMoney;

    WinningInfo(double countOfSameNumber, String infoMessage, int returnMoney) {
        this.countOfSameNumber = countOfSameNumber;
        this.infoMessage = infoMessage;
        this.returnMoney = returnMoney;
    }

    public double getCountOfSameNumber() {
        return this.countOfSameNumber;
    }

    public String getInfoMessage() {
        return infoMessage;
    }

    public int getReturnMoney() {
        return this.returnMoney;
    }

    // 일피하는 로또 번호 갯수에 해당하는 당첨 정보를 반환
    public static WinningInfo getWinningInfoByMatchCount(double matchCount) {
        return Arrays.stream(WinningInfo.values())
                .filter(winningInfo -> winningInfo.getCountOfSameNumber() == matchCount)
                .findAny()
                .orElse(NONE);
    }
}
