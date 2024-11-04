package lotto;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum LottoPlace implements Comparable<LottoPlace> {
    FIRST(
            2000000000,
            "6개 일치 (2,000,000,000원) - "
    ),

    SECOND(
            30000000,
            "5개 일치, 보너스 볼 일치 (30,000,000원) - "
    ),

    THIRD(
            1500000,
            "5개 일치 (1,500,000원) - "
    ),

    FORTH(
            50000,
            "4개 일치 (50,000원) - "
    ),

    FIFTH(
            5000,
            "3개 일치 (5,000원) - "
    ),

    LOSE(
            0,
            "당첨되지 않았습니다."
    );

    private final int winningMoney;
    private final String summaryComment;

    LottoPlace(int winningMoney, String summaryComment) {
        this.winningMoney = winningMoney;
        this.summaryComment = summaryComment;
    }

    public static List<LottoPlace> getWinningPlaces() {
        return Arrays.stream(values())
                .filter(lottoPlace -> lottoPlace.winningMoney > 0)
                .sorted(Collections.reverseOrder())
                .toList();
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public String provideSummaryComment(int numberOfTicket) {
        return this.summaryComment + numberOfTicket + "개";
    }
}
