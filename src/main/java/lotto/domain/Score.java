package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Score {
    THREE_CORRECT(5000, "3개 일치 (5,000원)"),
    FOUR_CORRECT(50000, "4개 일치 (50,000원)"),
    FIVE_CORRECT(1500000, "5개 일치 (1,500,000원)"),
    FIVE_CORRECT_BONUS_CORRECT(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_CORRECT(2000000000, "6개 일치 (2,000,000,000원)"),
    NONE(0, null);

    private final int prizeMoney;
    private final String printMessage;

    Score(int prizeMoney, String printMessage) {
        this.prizeMoney = prizeMoney;
        this.printMessage = printMessage;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrintMessage() {
        return printMessage;
    }

    public static List<Score> getWinningScores() {
        return Arrays.stream(values())
                .filter(score -> score != NONE)
                .collect(Collectors.toList());
    }
}