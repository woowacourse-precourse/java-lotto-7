package lotto.view;

import lotto.rule.Prize;

public enum WinningMatchMessage {

    FIFTH("3개 일치 (%s원) - %d개\n"),
    FOURTH("4개 일치 (%s원) - %d개\n"),
    THIRD("5개 일치 (%s원) - %d개\n"),
    SECOND("5개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    FIRST("6개 일치 (%s원) - %d개\n"),
    ;

    private final String message;

    WinningMatchMessage(String message) {
        this.message = message;
    }

    public String getMessage(int count) {
        return String.format(message, formatPrizeAmount(), count);
    }

    private String formatPrizeAmount() {
        String CURRENCY_FORMAT_PATTERN = "%,d";
        if (this.equals(FIRST)) {
            return String.format(CURRENCY_FORMAT_PATTERN, Prize.FIRST.getPrizeAmount());
        }
        if (this.equals(SECOND)) {
            return String.format(CURRENCY_FORMAT_PATTERN, Prize.SECOND.getPrizeAmount());
        }
        if (this.equals(THIRD)) {
            return String.format(CURRENCY_FORMAT_PATTERN, Prize.THIRD.getPrizeAmount());
        }
        if (this.equals(FOURTH)) {
            return String.format(CURRENCY_FORMAT_PATTERN, Prize.FOURTH.getPrizeAmount());
        }
        if (this.equals(FIFTH)) {
            return String.format(CURRENCY_FORMAT_PATTERN, Prize.FIFTH.getPrizeAmount());
        }
        throw new IllegalStateException("[ERROR] 존재하지 않는 당첨 유형입니다.");
    }
}
