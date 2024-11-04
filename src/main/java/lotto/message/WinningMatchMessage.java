package lotto.message;

import lotto.rule.Prize;

public enum WinningMatchMessage implements Message {

    FIRST("6개 일치 (%s원)", Prize.FIRST),
    SECOND("5개 일치, 보너스 볼 일치 (%s원)", Prize.SECOND),
    THIRD("5개 일치 (%s원)", Prize.THIRD),
    FOURTH("4개 일치 (%s원)", Prize.FOURTH),
    FIFTH("3개 일치 (%s원)", Prize.FIFTH),
    ;

    private final String message;
    private final Prize prize;

    WinningMatchMessage(String message, Prize prize) {
        this.message = message;
        this.prize = prize;
    }

    @Override
    public String get() {
        return String.format(message, formatPrizeAmount());
    }

    private String formatPrizeAmount() {
        String currencyFormatPattern = "%,d";
        return String.format(currencyFormatPattern, prize.getPrizeAmount());
    }
}
