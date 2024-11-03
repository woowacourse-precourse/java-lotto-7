package lotto.domain;

import java.text.NumberFormat;

public enum LottoRank {
    FIFTH(3, 5_000, "%d개 일치 (%s원) - %d개"),
    FOURTH(4, 50_000, "%d개 일치 (%s원) - %d개"),
    THIRD(5, 1_500_000, "%d개 일치 (%s원) - %d개"),
    SECOND(5, 30_000_000, "%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    FIRST(6, 2_000_000_000, "%d개 일치 (%s원) - %d개"),
    NONE(0, 0, "");

    private final int matchCount;
    private final int prize;
    private final String messageFormat;

    LottoRank(int matchCount, int prize, String messageFormat) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.messageFormat = messageFormat;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessageFormat() {
        return messageFormat;
    }

    public String getFormattedPrize() {
        return NumberFormat.getInstance().format(prize);
    }

    public String formatMessage(int count) {
        return String.format(messageFormat, matchCount, getFormattedPrize(), count);
    }
}
